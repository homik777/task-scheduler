package com.mrhamster.model;

import com.mrhamster.utils.IdGenerator;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class WorkTask {
    private Integer id = IdGenerator.generateId(WorkTask.class);
    private Priority priority = Priority.MEDIUM;
    private LocalDateTime creationTime = LocalDateTime.now();
    private String name;
    private Duration duration;
    private PriorityQueue<WorkTaskPart> taskParts = new PriorityQueue<>(Comparator.comparing(WorkTaskPart::getPartId, Comparator.naturalOrder()));

    public WorkTask(String name, Duration duration) {
        this.name = name;
        this.duration = duration;
    }

    public WorkTask(String name, Duration duration, Priority priority) {
        this(name, duration);
        this.priority = priority;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Duration getDuration() {
        return duration;
    }

    public Priority getPriority() {
        return priority;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public Collection<WorkTaskPart> getParts() {
        return Collections.unmodifiableCollection(taskParts);
    }
}
