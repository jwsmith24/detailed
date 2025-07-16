package dev.jake.entities;

import dev.jake.util.DetailType;
import dev.jake.util.Rank;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Soldier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Rank rank;

    private LocalDate leaveStartDate;
    private LocalDate leaveEndDate;
    private int daysOfApprovedAbsences;

    @OneToMany(mappedBy = "soldier", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<DutyAssignment> upcomingDuties = new ArrayList<>();

    public Soldier() {} // you're welcome jpa

    public Soldier(String name, Rank rank) {
        this.name = name;
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<DutyAssignment> getUpcomingDuties() {
        return upcomingDuties;
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

    public int getDaysOfApprovedAbsences() {
        return daysOfApprovedAbsences;
    }

    public void setDaysOfApprovedAbsences(int daysOfApprovedAbsences) {
        this.daysOfApprovedAbsences = daysOfApprovedAbsences;
    }

    @Override
    public String toString() {
        return String.format("%s %s", rank, name);
    }

}
