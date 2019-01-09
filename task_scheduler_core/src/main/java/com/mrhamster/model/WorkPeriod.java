package com.mrhamster.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.NavigableMap;
import java.util.TreeMap;

public class WorkPeriod {
    private LocalDateTime startTime;
    private Duration duration;
    private NavigableMap<LocalDateTime, CalendarTask> taskParts = new TreeMap<>();

    public WorkPeriod(LocalDateTime startTime, Duration duration){
        this.startTime = startTime;
        this.duration = duration;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Duration getDuration() {
        return duration;
    }
}
