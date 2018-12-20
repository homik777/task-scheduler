package com.mrhamster;

import java.time.Duration;

public class WorkTaskPart {
    private String name;
    private Duration duration;
    private Integer partId;

    public WorkTaskPart(String name, Duration duration, Integer partId) {
        this.name = name;
        this.duration = duration;
        this.partId = partId;
    }

    public String getName() {
        return name;
    }

    public Duration getDuration() {
        return duration;
    }

    public Integer getPartId() {
        return partId;
    }
}
