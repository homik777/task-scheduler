package com.mrhamster.controller;

import com.mrhamster.model.WorkTaskPart;

import java.time.Duration;
import java.util.Optional;

public class CallendarTaskController {
    public static Optional<WorkTaskPart> splitTask(WorkTaskPart task, Duration splitDuration){
        if(task.getDuration().compareTo(splitDuration) > 0){
            Duration durationOfTaskPart = task.getDuration().minus(splitDuration);
            task.setDuration(splitDuration);
            WorkTaskPart taskPart = new WorkTaskPart(durationOfTaskPart, task.getScheduledTask(), task.getPartId() + 1);
            return Optional.of(taskPart);
        }else{
            return Optional.empty();

        }
    }
}
