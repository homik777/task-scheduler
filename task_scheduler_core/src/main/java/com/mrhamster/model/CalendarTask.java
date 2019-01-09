package com.mrhamster.model;

public class CalendarTask {
    private WorkTask scheduledTask;
    private Integer durationTimeInMinutes;
    private Integer partId = 1;
    private boolean splitted = false;

    public CalendarTask(WorkTask task) {
        this.scheduledTask = task;
        this.durationTimeInMinutes = task.getEstimatedTimeInMinutes();
    }

    public CalendarTask(Integer durationTimeInMinutes, WorkTask task, Integer partId) {
        this.scheduledTask = task;
        this.durationTimeInMinutes = durationTimeInMinutes;
        this.partId = partId;
        this.splitted = true;
    }

    public void setDurationTimeInMinutes(Integer durationTimeInMinutes) {
        this.durationTimeInMinutes = durationTimeInMinutes;
    }

    public void setSplitted(boolean splitted) {
        this.splitted = splitted;
    }

    public WorkTask getScheduledTask() {
        return scheduledTask;
    }

    public Integer getDurationTimeInMinutes() {
        return durationTimeInMinutes;
    }

    public Integer getPartId() {
        return partId;
    }
}
