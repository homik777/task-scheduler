package com.mrhamster.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class DateUtils {

    public static LocalDate calculateNextWorkDayDateFor(LocalDateTime lastDateTime){
        return calculateNextWorkDayDateFor(lastDateTime, false, false);
    }

    public static LocalDate calculateNextWorkDayDateFor(LocalDateTime lastDateTime, boolean isWorkingSaturday, boolean isWorkingSunday) {
        LocalDate newWorkDay;
        DayOfWeek nextDay = lastDateTime.getDayOfWeek().plus(1);
        if (isNotWeekend(nextDay) || (DayOfWeek.SATURDAY.equals(nextDay) && isWorkingSaturday) || DayOfWeek.SUNDAY.equals(nextDay) && isWorkingSunday) {
            newWorkDay = lastDateTime.toLocalDate().with(TemporalAdjusters.next(nextDay));
        } else {
            newWorkDay = lastDateTime.toLocalDate().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        }
        return newWorkDay;
    }

    private static boolean isNotWeekend(DayOfWeek nextDay) {
        return !DayOfWeek.SATURDAY.equals(nextDay) && !DayOfWeek.SUNDAY.equals(nextDay);
    }
}
