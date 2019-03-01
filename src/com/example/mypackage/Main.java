package com.example.mypackage;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

    // Zadanie:
    // Kolkokrat denne sa stretnu hodinove a minutove rucicky na hodinach? (22)

    public static void main(String[] args) {

        LocalTime time = LocalTime.of(0, 0);

        final int MINUTES_PER_DAY = 60 * 24;
        final int CLOCK_SEGMENTS = 60;
        final int MINUTES_IN_HOUR = 60;
        final double HOUR_HAND_SHIFT_PER_HOUR = CLOCK_SEGMENTS / 12.0;
        final double HOUR_HAND_SHIFT_PER_MINUTE = HOUR_HAND_SHIFT_PER_HOUR / MINUTES_IN_HOUR;
        final int MINUTE_HAND_SHIFT_PER_MINUTE = CLOCK_SEGMENTS / MINUTES_IN_HOUR;
        final double MEETING_TRESHOLD = (MINUTE_HAND_SHIFT_PER_MINUTE-HOUR_HAND_SHIFT_PER_MINUTE)/2;
        double hourHandPosition = 0.0;
        int meetingsCount = 0;

        for (int i = 0; i < MINUTES_PER_DAY; i++) {
            if (time.getHour() == 12 && time.getMinute() == 0) {
                hourHandPosition = 0.0;
            }
            double delta = (MINUTE_HAND_SHIFT_PER_MINUTE * time.getMinute()) - hourHandPosition;

            if (delta > MEETING_TRESHOLD*(-1) && delta <= MEETING_TRESHOLD) {
                System.out.println(++meetingsCount + ". " + time);
            }
            hourHandPosition += HOUR_HAND_SHIFT_PER_MINUTE;
            time = time.plusMinutes(1);
        }
        System.out.println("Clock hands meets in total " + meetingsCount + " times a day.");
    }
}
