package com.mrhamster.utils;

import java.time.Duration;
import java.time.LocalTime;

public class WorkTimeDefaults {
    public static final LocalTime DEFAULT_BREAK_START_TIME = LocalTime.of(12, 0);
    public static final LocalTime DEFAULT_BREAK_END_TIME = LocalTime.of(12, 30);
    public static final Duration DEFAULT_BREAK_DURATION = Duration.between(DEFAULT_BREAK_START_TIME, DEFAULT_BREAK_END_TIME);
    public static final LocalTime DEFAULT_WORK_START_TIME = LocalTime.of(8, 0);
    public static final LocalTime DEFAULT_WORK_STOP_TIME = LocalTime.of(16, 0);
}
