package com.mrhamster.demo;

import com.mrhamster.TaskScheduler;
import com.mrhamster.model.WorkTask;

import java.util.ArrayList;
import java.util.List;

public class TaskSchedulerDemoRunner {

    public static void main(String args[]){

    }

    private void run(){
        TaskGenerator taskGenerator = new TaskGenerator();
        List<WorkTask> tasksToSchedule = taskGenerator.generateWorkTasks();
        TaskScheduler taskScheduler = new TaskScheduler();

        for(WorkTask task: tasksToSchedule){
            taskScheduler.registerTask(task);
        }


    }
}
