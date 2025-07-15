package dev.jake.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RosterEntry {
    Soldier soldier;
    LocalDate lastWeekdayDuty;
    LocalDate lastWeekendOrHolidayDuty;
    int dutyCount;

    public int getDaysSinceLastWeekdayDuty() {
        if (lastWeekdayDuty == null) return Integer.MAX_VALUE;

        LocalDate adjustedDays = lastWeekdayDuty.plusDays(daysOfApprovedAbsence);
        return (int) ChronoUnit.DAYS.between(adjustedDays, LocalDate.now());

    }

    public int getDaysSinceLastWeekendOrHolidayDuty() {
        if (lastWeekendOrHolidayDuty == null) return Integer.MAX_VALUE;
        LocalDate adjustedDate = lastWeekendOrHolidayDuty.plusDays(daysOfApprovedAbsence);
        return (int) ChronoUnit.DAYS.between(adjustedDate, LocalDate.now());
    }
}


