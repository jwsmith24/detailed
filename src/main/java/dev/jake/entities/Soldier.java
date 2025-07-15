package dev.jake.entities;

import dev.jake.util.Rank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Soldier {
    private String name;
    private Rank rank;

    private LocalDate leaveStartDate;
    private LocalDate leaveEndDate;

    private final List<DetailAssignment> upcomingDuties;


    public Soldier(String name, Rank rank) {
        this.name = name;
        this.rank = rank;
        this.leaveStartDate = null;
        this.leaveEndDate = null;
        this.upcomingDuties = new ArrayList<>();
    }

    public boolean isAvailable(LocalDate detailDate) {
        // check Soldier's leave days
        if ((leaveStartDate != null && !detailDate.isBefore(leaveStartDate)) &&
                (leaveEndDate != null && !detailDate.isAfter(leaveEndDate))) {
            return false;
        }

        // check if they're already scheduled for something else
        for (DetailAssignment detail : upcomingDuties) {
            if (detail.getDate().equals(detailDate)) {
                return false;
            }
        }

        return true;
    }

    public void addAssignment(DetailAssignment detail) {
        upcomingDuties.add(detail);
    }

    public void removeAssignment(DetailAssignment detail) {
        upcomingDuties.remove(detail);
    }

    public void setLeaveStartDate(LocalDate leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }
    public void setLeaveEndDate(LocalDate leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public void clearLeaveDays() {
        this.leaveStartDate = null;
        this.leaveEndDate = null;
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

    public LocalDate getLeaveEndDate() {
        return leaveEndDate;
    }

    public List<DetailAssignment> getUpcomingDuties() {
        return upcomingDuties;
    }
}
