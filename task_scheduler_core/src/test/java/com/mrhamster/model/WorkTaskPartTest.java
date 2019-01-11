package com.mrhamster.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WorkTaskPartTest {

    @Mock
    private WorkTask workTask;

    @BeforeEach
    void setUp() {
        Mockito.when(workTask.getDuration()).thenReturn(Duration.ofMinutes(60));
        Mockito.when(workTask.getName()).thenReturn("Mocked task");
        Mockito.when(workTask.getParts()).thenReturn(Collections.emptyList());
        Mockito.when(workTask.getParts().size()).thenReturn(1);
    }

    @Test
    void testToString() {
        WorkTaskPart taskPart = new WorkTaskPart(workTask);
        Assertions.assertEquals("Task: Mocked task (1/1) [60]",taskPart.toString());
    }
}