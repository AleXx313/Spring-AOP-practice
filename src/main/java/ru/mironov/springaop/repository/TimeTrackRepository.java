package ru.mironov.springaop.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.mironov.springaop.dto.TimeTrackAggregationData;
import ru.mironov.springaop.model.TimeTrack;

import java.time.LocalDateTime;
import java.util.List;

public interface TimeTrackRepository extends CrudRepository<TimeTrack, Integer> {

    @Query("""
            select new ru.mironov.springaop.dto.TimeTrackAggregationData(avg(tt.time), tt.className, tt.methodName, ru.mironov.springaop.util.enums.AggregationType.AVG)
            from TimeTrack as tt
            where tt.methodName like ?2 and tt.className like ?1 and tt.timestamp between ?3 and ?4
            group by tt.methodName, tt.className
            """)
    List<TimeTrackAggregationData> getAverageByClassNameAndMethodName(String className, String methodName, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select new ru.mironov.springaop.dto.TimeTrackAggregationData(avg(tt.time), tt.className, tt.methodName, ru.mironov.springaop.util.enums.AggregationType.AVG)
            from TimeTrack as tt
            where tt.methodName like ?1 and tt.timestamp between ?2 and ?3
            group by tt.methodName, tt.className
            """)
    List<TimeTrackAggregationData> getAverageByMethodName(String methodName, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select new ru.mironov.springaop.dto.TimeTrackAggregationData(avg(tt.time), tt.className, tt.methodName, ru.mironov.springaop.util.enums.AggregationType.AVG)
            from TimeTrack as tt
            where tt.className like ?1 and tt.timestamp between ?2 and ?3
            group by tt.methodName, tt.className
            """)
    List<TimeTrackAggregationData> getAverageByClassName(String className, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select new ru.mironov.springaop.dto.TimeTrackAggregationData(avg(tt.time), tt.className, tt.methodName, ru.mironov.springaop.util.enums.AggregationType.AVG)
            from TimeTrack as tt
            where tt.timestamp between ?1 and ?2
            group by tt.methodName, tt.className
            """)
    List<TimeTrackAggregationData> getAverage(LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select new ru.mironov.springaop.dto.TimeTrackAggregationData(sum(tt.time), tt.className, tt.methodName, ru.mironov.springaop.util.enums.AggregationType.SUM)
            from TimeTrack as tt
            where tt.methodName like ?2 and tt.className like ?1 and tt.timestamp between ?3 and ?4
            group by tt.methodName, tt.className
            """)
    List<TimeTrackAggregationData> getSumByClassNameAndMethodName(String className, String methodName, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select new ru.mironov.springaop.dto.TimeTrackAggregationData(sum(tt.time), tt.className, tt.methodName, ru.mironov.springaop.util.enums.AggregationType.SUM)
            from TimeTrack as tt
            where tt.methodName like ?1 and tt.timestamp between ?2 and ?3
            group by tt.methodName, tt.className
            """)
    List<TimeTrackAggregationData> getSumByMethodName(String methodName, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select new ru.mironov.springaop.dto.TimeTrackAggregationData(sum(tt.time), tt.className, tt.methodName, ru.mironov.springaop.util.enums.AggregationType.SUM)
            from TimeTrack as tt
            where tt.className like ?1 and tt.timestamp between ?2 and ?3
            group by tt.methodName, tt.className
            """)
    List<TimeTrackAggregationData> getSumByClassName(String className, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select new ru.mironov.springaop.dto.TimeTrackAggregationData(sum(tt.time), tt.className, tt.methodName, ru.mironov.springaop.util.enums.AggregationType.SUM)
            from TimeTrack as tt
            where tt.timestamp between ?1 and ?2
            group by tt.methodName, tt.className
            """)
    List<TimeTrackAggregationData> getSum(LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select new ru.mironov.springaop.dto.TimeTrackAggregationData(max(tt.time), tt.className, tt.methodName, ru.mironov.springaop.util.enums.AggregationType.MAX)
            from TimeTrack as tt
            where tt.methodName like ?2 and tt.className like ?1 and tt.timestamp between ?3 and ?4
            group by tt.methodName, tt.className
            """)
    List<TimeTrackAggregationData> getMaxByClassNameAndMethodName(String className, String methodName, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select new ru.mironov.springaop.dto.TimeTrackAggregationData(max(tt.time), tt.className, tt.methodName, ru.mironov.springaop.util.enums.AggregationType.MAX)
            from TimeTrack as tt
            where tt.methodName like ?1 and tt.timestamp between ?2 and ?3
            group by tt.methodName, tt.className
            """)
    List<TimeTrackAggregationData> getMaxByMethodName(String methodName, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select new ru.mironov.springaop.dto.TimeTrackAggregationData(max(tt.time), tt.className, tt.methodName, ru.mironov.springaop.util.enums.AggregationType.MAX)
            from TimeTrack as tt
            where tt.className like ?1 and tt.timestamp between ?2 and ?3
            group by tt.methodName, tt.className
            """)
    List<TimeTrackAggregationData> getMaxByClassName(String className, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    @Query("""
            select new ru.mironov.springaop.dto.TimeTrackAggregationData(max(tt.time), tt.className, tt.methodName, ru.mironov.springaop.util.enums.AggregationType.MAX)
            from TimeTrack as tt
            where tt.timestamp between ?1 and ?2
            group by tt.methodName, tt.className
            """)
    List<TimeTrackAggregationData> getMax(LocalDateTime rangeStart, LocalDateTime rangeEnd);
}
