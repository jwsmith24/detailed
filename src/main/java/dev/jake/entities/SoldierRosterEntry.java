package dev.jake.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SoldierRosterEntry {
    private Soldier soldier;
    private LocalDate lastWeekdayDuty;
    private LocalDate lastWeekendOrHolidayDuty;


    public int getDaysSinceLastWeekdayDuty() {
        if (lastWeekdayDuty == null) return Integer.MAX_VALUE;

        LocalDate adjustedDays = lastWeekdayDuty.plusDays(soldier.getDaysOfApprovedAbsences());
        return (int) ChronoUnit.DAYS.between(adjustedDays, LocalDate.now());

    }

    public int getDaysSinceLastWeekendOrHolidayDuty() {
        if (lastWeekendOrHolidayDuty == null) return Integer.MAX_VALUE;
        LocalDate adjustedDate = lastWeekendOrHolidayDuty.plusDays(soldier.getDaysOfApprovedAbsences());
        return (int) ChronoUnit.DAYS.between(adjustedDate, LocalDate.now());
    }


}


