package dev.jake.entities;

import dev.jake.util.Rank;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Soldier {
    private String name;
    private Rank rank;
    private LocalDate lastWeekdayDuty;
    private LocalDate lastWeekendOrHolidayDuty;
    private int daysOfApprovedAbsence;

    public Soldier(String name, Rank rank) {
        this.name = name;
        this.rank = rank;
    }

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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setDaysOfApprovedAbsence(int daysOfApprovedAbsence) {
        this.daysOfApprovedAbsence = daysOfApprovedAbsence;
    }

    public LocalDate getLastWeekdayDuty() {
        return lastWeekdayDuty;
    }

    public void setLastWeekdayDuty(LocalDate lastWeekdayDuty) {
        this.lastWeekdayDuty = lastWeekdayDuty;
    }

    public LocalDate getLastWeekendOrHolidayDuty() {
        return lastWeekendOrHolidayDuty;
    }

    public void setLastWeekendOrHolidayDuty(LocalDate lastWeekendOrHolidayDuty) {
        this.lastWeekendOrHolidayDuty = lastWeekendOrHolidayDuty;
    }

    public int getDaysOfApprovedAbsence() {
        return daysOfApprovedAbsence;
    }
}
