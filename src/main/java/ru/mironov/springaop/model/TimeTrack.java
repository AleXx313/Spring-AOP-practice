package ru.mironov.springaop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stats")
public class TimeTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "class_name")
    private String className;
    @Column(name = "method_name")
    private String methodName;
    @Column(name = "time")
    private long time;
    @Column(name = "timestamp")
    private LocalDateTime timestamp;
}
