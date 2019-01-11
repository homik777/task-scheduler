package com.mrhamster.controller;

import com.mrhamster.model.Priority;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class TaskControllerImplTest {

    @Mock
    private Appender mockAppender;

    private List<LogEvent> capturedLogEvents = new ArrayList<>();



    private Logger logger;
    private TaskControllerImpl taskController;

    @BeforeEach
    void setUp() {
        taskController = new TaskControllerImpl();
        taskController.createTask("Delete me using name", Duration.ofMinutes(10));
        taskController.createTask("Delete me using id", Duration.ofMinutes(10)); // id: 1

        Mockito.when(mockAppender.getName()).thenReturn("MockAppender");
        Mockito.when(mockAppender.isStarted()).thenReturn(true);
        Mockito.lenient().when(mockAppender.isStopped()).thenReturn(false);
        Mockito.doAnswer( x -> {
            LogEvent ev = x.getArgument(0);
            capturedLogEvents.add(ev.toImmutable());
            return 1;
        }).when(mockAppender).append(Mockito.any());

        logger = (Logger) LogManager.getLogger(TaskControllerImpl.class);
        logger.addAppender(mockAppender);
        logger.setLevel(Level.ALL);

    }

    @AfterEach
    void tearDown() {
        logger.removeAppender(mockAppender);
        capturedLogEvents.clear();
    }


    @Test
    void createTask() {
        taskController.createTask("Test task creation.", Duration.ofMinutes(60));
        Assertions.assertEquals(3, taskController.getTasks().size());
        verifyLogMessage("Task [Test task creation.] was created successfully.");
    }

    @Test
    void createTaskWithPriority() {
        taskController.createTask("Test task creation.", Duration.ofMinutes(60), Priority.CRITICAL);
        Assertions.assertEquals(3, taskController.getTasks().size());
        verifyLogMessage("Task [Test task creation.] was created successfully.");
    }

    @Test
    void deleteTaskWithName() {
        Assertions.assertEquals(2, taskController.getTasks().size());
        taskController.deleteTask("Delete me using name");
        Assertions.assertEquals(1, taskController.getTasks().size());
        verifyLogMessage("Task [name:Delete me using name] was deleted successfully.");
    }

    @Test
    void deleteTaskWithId() {
        Assertions.assertEquals(2, taskController.getTasks().size());
        taskController.deleteTask(1);
        Assertions.assertEquals(1, taskController.getTasks().size());
        verifyLogMessage("Task [id:1] was deleted successfully.");
    }


    private void verifyLogMessage(String message){
        Assertions.assertEquals(1, capturedLogEvents.size(), "Captured events");

        for(LogEvent logEvent : capturedLogEvents){
            Assertions.assertEquals(message, logEvent.getMessage().getFormattedMessage());
        }
    }
}