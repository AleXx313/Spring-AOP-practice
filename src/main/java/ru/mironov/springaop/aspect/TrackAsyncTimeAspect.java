package ru.mironov.springaop.aspect;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import ru.mironov.springaop.dto.TimeTrackDto;
import ru.mironov.springaop.service.TimeTrackService;

import java.util.concurrent.CompletableFuture;

@Aspect
@Component
@Slf4j
@AllArgsConstructor
public class TrackAsyncTimeAspect {

    private TimeTrackService timeTrackService;

    @Pointcut("@annotation(ru.mironov.springaop.annotation.TrackAsyncTime)")
    public void trackAsyncTimeAnnotatedMethod() {
    }

    @Around("trackAsyncTimeAnnotatedMethod()")
    public Object aroundAnyTrackAsyncTimeAnnotatedMethod(ProceedingJoinPoint joinPoint) {
        CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> {
            long start = System.nanoTime();
            try {
                return joinPoint.proceed();
            } catch (Throwable e) {
                log.error("Ошибка при выполнении метода {}", joinPoint.getSignature().toLongString());
                throw new RuntimeException();
            } finally {
                long time = System.nanoTime() - start;
                String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
                String methodName = joinPoint.getSignature().getName();
                timeTrackService.save(new TimeTrackDto(className, methodName, time));
            }
        });
        return future.join();
    }
}
