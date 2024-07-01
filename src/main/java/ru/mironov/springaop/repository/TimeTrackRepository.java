package ru.mironov.springaop.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.mironov.springaop.model.TimeTrack;

import java.time.LocalDateTime;

public interface TimeTrackRepository extends CrudRepository<TimeTrack, Integer> {

    @Query("""
            select avg(tt.time)
            from TimeTrack as tt
            where tt.methodName like ?2 and tt.className like ?1 and tt.timestamp between ?3 and ?4
            group by tt.methodName, tt.className
            """)
    Integer getAverageByClassNameAndMethodName(String className, String methodName, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select avg(tt.time)
            from TimeTrack as tt
            where tt.methodName like ?1 and tt.timestamp between ?2 and ?3
            group by tt.methodName
            """)
    Integer getAverageByMethodName(String methodName, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select avg(tt.time)
            from TimeTrack as tt
            where tt.className like ?1 and tt.timestamp between ?2 and ?3
            group by tt.className
            """)
    Integer getAverageByClassName(String className, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select avg(tt.time)
            from TimeTrack as tt
            where tt.timestamp between ?1 and ?2
            """)
    Integer getAverage(LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select sum(tt.time)
            from TimeTrack as tt
            where tt.methodName like ?2 and tt.className like ?1 and tt.timestamp between ?3 and ?4
            group by tt.methodName, tt.className
            """)
    Long getSumByClassNameAndMethodName(String className, String methodName, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select sum(tt.time)
            from TimeTrack as tt
            where tt.methodName like ?1 and tt.timestamp between ?2 and ?3
            group by tt.methodName
            """)
    Long getSumByMethodName(String methodName, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select sum(tt.time)
            from TimeTrack as tt
            where tt.className like ?1 and tt.timestamp between ?2 and ?3
            group by tt.className
            """)
    Long getSumByClassName(String className, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select sum(tt.time)
            from TimeTrack as tt
            where tt.timestamp between ?1 and ?2
            """)
    Long getSum(LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select max(tt.time)
            from TimeTrack as tt
            where tt.methodName like ?2 and tt.className like ?1 and tt.timestamp between ?3 and ?4
            group by tt.methodName, tt.className
            """)
    Integer getMaxByClassNameAndMethodName(String className, String methodName, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select max(tt.time)
            from TimeTrack as tt
            where tt.methodName like ?1 and tt.timestamp between ?2 and ?3
            group by tt.methodName
            """)
    Integer getMaxByMethodName(String methodName, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select max(tt.time)
            from TimeTrack as tt
            where tt.className like ?1 and tt.timestamp between ?2 and ?3
            group by tt.className
            """)
    Integer getMaxByClassName(String className, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select max(tt.time)
            from TimeTrack as tt
            where tt.timestamp between ?1 and ?2
            """)
    Integer getMax(LocalDateTime rangeStart, LocalDateTime rangeEnd);
}
