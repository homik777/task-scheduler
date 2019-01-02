package com.mrhamster;

import com.mrhamster.model.WorkPeriod;
import com.mrhamster.model.WorkTask;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class TaskCalendar {

    private List<WorkTask> tasks = new ArrayList<>();
    private List<WorkPeriod> workPeriods = new ArrayList<>();

    public void addTask(WorkTask task){
        tasks.add(task);
    }

    public void addTask(WorkTask... tasks ){

    }








}
