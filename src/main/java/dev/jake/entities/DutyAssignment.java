package dev.jake.entities;

import dev.jake.util.DetailType;

import java.time.LocalDate;

/**
 * The DutyAssignment object represents a given duty that will need to be filled via polling the roster.
 */
public class DutyAssignment {
    private static int counter = 1;
    private final int id;
    private final DetailType detailType;
    private Soldier soldier;
    private LocalDate date;
    private String location;

    public DutyAssignment(LocalDate date, DetailType detailType) {
        this.soldier = null; // initially not filled
        this.date = date;
        this.detailType = detailType;
        this.id = counter++;
    }


    @Override
    public String toString() {
        String s = soldier == null ? "TBD" : soldier.toString();
        return String.format("%s on %s filled by %s | id: %s", detailType.toString(), date, s, id);
    }

    public int getId() {
        return id;
    }

    public void assignSoldierToDuty(Soldier soldier) {
        this.soldier = soldier;

    }

    public Soldier getAssignedSoldier() {
        return soldier;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public DetailType getDetailType() {
        return detailType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
