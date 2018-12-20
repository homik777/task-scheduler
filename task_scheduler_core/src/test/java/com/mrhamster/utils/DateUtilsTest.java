package com.mrhamster.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateWorkDateFromFridayForNotWorkingWeekend() {
        LocalDateTime friday = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        LocalDate localDate = DateUtils.calculateNextWorkDayDateFor(friday);
        assertEquals(DayOfWeek.MONDAY, localDate.getDayOfWeek());
    }

    @Test
    void calculateWorkDateFromFridayForWorkingWeekend() {
        LocalDateTime friday = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        LocalDate localDate = DateUtils.calculateNextWorkDayDateFor(friday, true, true);
        assertEquals(DayOfWeek.SATURDAY, localDate.getDayOfWeek());
    }

    @Test
    void calculateWorkDateFromFridayForWorkingSundayOnly() {
        LocalDateTime friday = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        LocalDate localDate = DateUtils.calculateNextWorkDayDateFor(friday, false, true);
        assertEquals(DayOfWeek.SUNDAY, localDate.getDayOfWeek());
    }

    @Test
    void calculateWorkDateFromFridayForWorkingSaturdayOnly() {
        LocalDateTime friday = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        LocalDate localDate = DateUtils.calculateNextWorkDayDateFor(friday, true, false);
        assertEquals(DayOfWeek.SATURDAY, localDate.getDayOfWeek());
    }

    @Test
    void calculateWorkDateFromSaturdayForWorkingWeekend() {
        LocalDateTime saturday = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        LocalDate localDate = DateUtils.calculateNextWorkDayDateFor(saturday, true, true);
        assertEquals(DayOfWeek.SUNDAY, localDate.getDayOfWeek());
    }

    @Test
    void calculateWorkDateFromSaturdayForWorkingSundayOnly() {
        LocalDateTime saturday = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        LocalDate localDate = DateUtils.calculateNextWorkDayDateFor(saturday, false, true);
        assertEquals(DayOfWeek.SUNDAY, localDate.getDayOfWeek());
    }


    @Test
    void calculateWorkDateFromSaturdayForNotWorkingSundayOnly() {
        LocalDateTime saturday = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        LocalDate localDate = DateUtils.calculateNextWorkDayDateFor(saturday, true, false);
        assertEquals(DayOfWeek.MONDAY, localDate.getDayOfWeek());
    }

    @Test
    void calculateWorkDateFromSaturdayForNotWorkingWeekend() {
        LocalDateTime saturday = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        LocalDate localDate = DateUtils.calculateNextWorkDayDateFor(saturday);
        assertEquals(DayOfWeek.MONDAY, localDate.getDayOfWeek());
    }

    @Test
    void calculateWorkDateFromMiddleOfTheWeekForNotWorkingWeekend() {
        LocalDateTime wednesday = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        LocalDate localDate = DateUtils.calculateNextWorkDayDateFor(wednesday);
        assertEquals(DayOfWeek.THURSDAY, localDate.getDayOfWeek());
    }

    @Test
    void calculateWorkDateFromMiddleOfTheWeekForWorkingWeekend() {
        LocalDateTime wednesday = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        LocalDate localDate = DateUtils.calculateNextWorkDayDateFor(wednesday, true, true);
        assertEquals(DayOfWeek.THURSDAY, localDate.getDayOfWeek());
    }
}