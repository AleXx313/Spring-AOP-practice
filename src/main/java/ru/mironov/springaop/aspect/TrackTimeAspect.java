package ru.mironov.springaop.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.mironov.springaop.dto.TimeTrackDto;
import ru.mironov.springaop.exception.JoinPointProceedException;
import ru.mironov.springaop.service.TimeTrackService;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class TrackTimeAspect {

    @Value("${spring.application.activate-tracker: true}")
    private boolean timeTrackerActive;

    private final TimeTrackService timeTrackService;

    @Pointcut("@annotation(ru.mironov.springaop.annotation.TrackTime)")
    public void trackTimeAnnotatedMethod() {
    }

    @Around("trackTimeAnnotatedMethod()")
    public Object aroundAnyTrackTimeAnnotatedMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        if (timeTrackerActive){
            long start = System.nanoTime();
            try {
                return joinPoint.proceed();
            } catch (Throwable e) {
                log.error("Ошибка при выполнении метода {}", joinPoint.getSignature().toLongString());
                throw new JoinPointProceedException(e.getMessage());
            } finally {
                long time = System.nanoTime() - start;
                String className = joinPoint.getSignature().getDeclaringTypeName();
                String methodName = joinPoint.getSignature().getName();
                timeTrackService.save(new TimeTrackDto(className, methodName, time));
            }
        } else {
            return joinPoint.proceed();
        }
    }
}
