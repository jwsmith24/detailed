package dev.jake.entities;

import dev.jake.util.DetailType;

import java.time.LocalDate;
import java.util.UUID;

/**
 * The DutyAssignment object represents a given duty that will need to be filled via polling the roster.
 *
 */
public class DutyAssignment {
    private final String id;
    private Soldier soldier;
    private final DetailType detailType;
    private LocalDate date;
    private String location;

    public DutyAssignment(LocalDate date, DetailType detailType) {
        this.soldier = null; // initially not filled
        this.date = date;
        this.detailType = detailType;
        this.id = UUID.randomUUID().toString();
    }


    @Override
    public String toString() {
        String s = soldier == null ? "TBD" : soldier.toString();
        return String.format("%s on %s filled by %s | id: %s", detailType.toString(), date, s, id);
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

    public DetailType getDetailType() {
        return detailType;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
