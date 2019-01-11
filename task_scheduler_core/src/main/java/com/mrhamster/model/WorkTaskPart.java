package com.mrhamster.model;

import java.time.Duration;

public class WorkTaskPart {
    private WorkTask scheduledTask;
    private Duration duration;
    private Integer partId = 1;

    public WorkTaskPart(WorkTask task) {
        this.scheduledTask = task;
        this.duration = task.getDuration();
    }

    public WorkTaskPart(Duration duration, WorkTask task, Integer partId) {
        this.scheduledTask = task;
        this.duration = duration;
        this.partId = partId;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public WorkTask getScheduledTask() {
        return scheduledTask;
    }

    public Duration getDuration() {
        return duration;
    }

    public Integer getPartId() {
        return partId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Task: ");
        sb.append(this.scheduledTask.getName());
        sb.append(" (").append(this.partId).append("/").append(this.scheduledTask.getParts().size()).append(") ");
        sb.append("[").append(this.duration).append("]");
        return sb.toString();
    }
}
