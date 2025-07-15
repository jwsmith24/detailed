package dev.jake.entities;

import dev.jake.util.DetailType;
import dev.jake.util.Rank;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Soldier {
    private final List<DutyAssignment> upcomingDuties;
    private final Map<DetailType, Integer> detailTracker;
    private String name;
    private Rank rank;
    private LocalDate leaveStartDate;
    private LocalDate leaveEndDate;
    private int daysOfApprovedAbsences;


    public Soldier(String name, Rank rank) {
        this.name = name;
        this.rank = rank;
        this.leaveStartDate = null;
        this.leaveEndDate = null;
        this.upcomingDuties = new ArrayList<>();
        this.detailTracker = new HashMap<>();
    }

    @Override
    public String toString() {
        return String.format("%s %s", rank, name);
    }

    public boolean isAvailable(LocalDate detailDate) {
        // check Soldier's leave days
        if ((leaveStartDate != null && !detailDate.isBefore(leaveStartDate)) &&
                (leaveEndDate != null && !detailDate.isAfter(leaveEndDate))) {
            return false;
        }

        // check if they're already scheduled for something else on that day and also day before or day after
        for (DutyAssignment detail : upcomingDuties) {
            LocalDate dateOfExistingDuty = detail.getDate();
            if (dateOfExistingDuty.equals(detailDate) |
                    dateOfExistingDuty.equals(detailDate.minusDays(1)) |
                    dateOfExistingDuty.equals(detailDate.plusDays(1))) {
                return false;
            }
        }

        return true;
    }

    public void addAssignment(DutyAssignment detail) {
        upcomingDuties.add(detail);
        detailTracker.put(detail.getDetailType(), detailTracker.getOrDefault(detail.getDetailType(), 0) + 1);
    }

    public void removeAssignment(DutyAssignment detail) {
        upcomingDuties.remove(detail);

        // update duty count
        DetailType type = detail.getDetailType();
        int count = detailTracker.getOrDefault(type, 0) - 1;

        if (count <= 0) {
            detailTracker.remove(type);
        } else {
            detailTracker.put(type, count);
        }


    }


    public void setLeaveDays(LocalDate leaveStartDate, LocalDate leaveEndDate) {
        this.leaveStartDate = leaveStartDate;
        this.leaveEndDate = leaveEndDate;
        this.daysOfApprovedAbsences = (int) ChronoUnit.DAYS.between(leaveStartDate, leaveEndDate);
    }


    public void clearLeaveDays() {
        this.leaveStartDate = null;
        this.leaveEndDate = null;
    }

    public int getDaysOfApprovedAbsences() {
        return daysOfApprovedAbsences;
    }

    public void setDaysOfApprovedAbsences(int daysOfApprovedAbsences) {
        this.daysOfApprovedAbsences = daysOfApprovedAbsences;
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

    public LocalDate getLeaveStartDate() {
        return leaveStartDate;
    }

    public void setLeaveStartDate(LocalDate leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public LocalDate getLeaveEndDate() {
        return leaveEndDate;
    }

    public void setLeaveEndDate(LocalDate leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public List<DutyAssignment> getUpcomingDuties() {
        return upcomingDuties;
    }
}
