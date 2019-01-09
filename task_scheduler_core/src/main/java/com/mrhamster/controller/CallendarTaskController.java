package com.mrhamster.controller;

import com.mrhamster.model.CalendarTask;

import java.util.Optional;

public class CallendarTaskController {
    public static Optional<CalendarTask> splitTask(CalendarTask task, Integer splitTimeInMinutes){
        if(splitTimeInMinutes > task.getDurationTimeInMinutes()){
            return Optional.empty();
        }else{
            Integer durationOfTaskPart = task.getDurationTimeInMinutes() - splitTimeInMinutes;
            task.setDurationTimeInMinutes(task.getDurationTimeInMinutes() - durationOfTaskPart);
            task.setSplitted(true);
            CalendarTask taskPart = new CalendarTask(durationOfTaskPart, task.getScheduledTask(), task.getPartId() + 1);
            return Optional.of(taskPart);
        }
    }
}
