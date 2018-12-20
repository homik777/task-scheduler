package com.mrhamster.utils;

import com.sun.istack.internal.NotNull;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class DateUtils {

    public static LocalDate calculateNextWorkDayDateFor(@NotNull LocalDateTime lastDateTime) {
        return calculateNextWorkDayDateFor(lastDateTime, false, false);
    }

    public static LocalDate calculateNextWorkDayDateFor(@NotNull LocalDateTime lastDateTime, boolean isWorkingSaturday, boolean isWorkingSunday) {
        DayOfWeek nextDay = lastDateTime.getDayOfWeek().plus(1);
        if (isNotWeekend(nextDay) || DayOfWeek.SATURDAY.equals(nextDay) && isWorkingSaturday || DayOfWeek.SUNDAY.equals(nextDay) && isWorkingSunday) {
            return lastDateTime.toLocalDate().with(TemporalAdjusters.next(nextDay));
        } else {
            if (DayOfWeek.SUNDAY.equals(nextDay.plus(1)) && isWorkingSunday) {
                return lastDateTime.toLocalDate().with(TemporalAdjusters.next(nextDay.plus(1)));
            } else {
                return lastDateTime.toLocalDate().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            }
        }
    }

    private static boolean isNotWeekend(DayOfWeek nextDay) {
        return !DayOfWeek.SATURDAY.equals(nextDay) && !DayOfWeek.SUNDAY.equals(nextDay);
    }
}
