package ru.mironov.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mironov.springaop.dto.TimeTrackDto;
import ru.mironov.springaop.service.TimeTrackService;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TrackAsyncTimeAspectTest {

    @Mock
    private TimeTrackService timeTrackService;
    @Mock
    private ProceedingJoinPoint joinPoint;

    @InjectMocks
    private TrackAsyncTimeAspect trackAsyncTimeAspect;

    private Signature signature;

    @Test
    void aroundAnyTrackAsyncTimeAnnotatedMethod_whenTrackerActive_thenTimeTrackSaved() throws Throwable {
        trackAsyncTimeAspect.setTimeTrackerActive(true);
        when(joinPoint.getSignature()).thenReturn(signature);
        when(joinPoint.proceed()).thenReturn(null);
        trackAsyncTimeAspect.aroundAnyTrackAsyncTimeAnnotatedMethod(joinPoint);

        verify(joinPoint, times(1)).proceed();
        verify(timeTrackService, times(1)).save(any(TimeTrackDto.class));
    }

    @Test
    void aroundAnyTrackAsyncTimeAnnotatedMethod_whenTrackerNotActive_thenTimeTrackNotSaved() throws Throwable {
        when(joinPoint.proceed()).thenReturn(null);
        trackAsyncTimeAspect.aroundAnyTrackAsyncTimeAnnotatedMethod(joinPoint);

        verify(joinPoint, times(1)).proceed();
        verify(timeTrackService, never()).save(any());
    }

    @BeforeEach
    public void init(){
        this.signature = new Signature() {
            @Override
            public String toShortString() {
                return null;
            }

            @Override
            public String toLongString() {
                return null;
            }

            @Override
            public String getName() {
                return null;
            }

            @Override
            public int getModifiers() {
                return 0;
            }

            @Override
            public Class getDeclaringType() {
                return Class.class;
            }

            @Override
            public String getDeclaringTypeName() {
                return null;
            }
        };
    }


}