package ru.mironov.springaop.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.mironov.springaop.dto.TimeTrackDto;
import ru.mironov.springaop.service.TimeTrackService;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class TrackTimeAspect {

    private final TimeTrackService timeTrackService;

    @Pointcut("@annotation(ru.mironov.springaop.annotation.TrackTime)")
    public void trackTimeAnnotatedMethod() {
    }

    @Around("trackTimeAnnotatedMethod()")
    public Object aroundAnyTrackTimeAnnotatedMethod(ProceedingJoinPoint joinPoint) {
        long start = System.nanoTime();
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            log.error("Ошибка при выполнении метода {}", joinPoint.getSignature().toLongString());
            throw new RuntimeException();
        } finally {
            long time = System.nanoTime() - start;
            String className = joinPoint.getSignature().getDeclaringTypeName();
            String methodName = joinPoint.getSignature().getName();
            timeTrackService.save(new TimeTrackDto(className, methodName, time));
        }
    }
}
