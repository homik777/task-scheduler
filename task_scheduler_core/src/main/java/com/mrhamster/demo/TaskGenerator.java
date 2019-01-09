package com.mrhamster.demo;

import com.mrhamster.model.Priority;
import com.mrhamster.model.WorkTask;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskGenerator {
    private static Random random = new Random();
    private Integer maxTaskDurationInMinutes = 300;
    private Integer noOfTasks = 10;
    private boolean randomPriorities = true;

    public List<WorkTask> generateWorkTasks(){
        return IntStream.range(0, noOfTasks).boxed().map(r -> new WorkTask("Do task nr. " + r, generateDurationTime(), generatePriority())).collect(Collectors.toList());
    }

    private Integer generateDurationTime() {
        return random.nextInt(maxTaskDurationInMinutes);
    }

    private Priority generatePriority() {
        if(randomPriorities){
            List<Priority> priorities = Arrays.asList(Priority.values());
            return priorities.get(random.nextInt(priorities.size()));
        }else{
            return Priority.MEDIUM;
        }
    }

    public void setMaxTaskDurationInMinutes(Integer maxTaskDurationInMinutes) {
        this.maxTaskDurationInMinutes = maxTaskDurationInMinutes;
    }

    public void setNoOfTasks(Integer noOfTasks) {
        this.noOfTasks = noOfTasks;
    }

    public void setRandomPriorities(boolean randomPriorities) {
        this.randomPriorities = randomPriorities;
    }
}
