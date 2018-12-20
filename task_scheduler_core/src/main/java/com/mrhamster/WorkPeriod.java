package com.mrhamster;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Optional;
import java.util.TreeMap;

public class WorkPeriod {
    private LocalDateTime startTime;
    private Duration duration;
    private NavigableMap<LocalDateTime, WorkTaskPart> taskParts = new TreeMap<>();

    public WorkPeriod(LocalDateTime startTime, Duration duration){
        this.startTime = startTime;
        this.duration = duration;
    }

    public Optional<WorkTaskPart> addTask(WorkTask task){
        Map.Entry<LocalDateTime, WorkTaskPart> localDateTimeWorkTaskPartEntry = taskParts.lastEntry();
        LocalDateTime finishOfLastTask = localDateTimeWorkTaskPartEntry.getKey().plusMinutes(localDateTimeWorkTaskPartEntry.getValue().getDuration().toMinutes());
//        if(startTime.plusMinutes(duration.toMinutes()))
    }

    private Optional<WorkTaskPart> splitTask(WorkTask task) {
    }

    private boolean canFit(Integer timeInMinutes) {
        Map.Entry<LocalDateTime, WorkTaskPart> localDateTimeWorkTaskPartEntry = taskParts.lastEntry();
        
    }
}
