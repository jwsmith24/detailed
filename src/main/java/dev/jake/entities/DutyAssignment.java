package dev.jake.entities;

import dev.jake.util.DetailType;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * The DutyAssignment object represents a given duty that will need to be filled via polling the roster.
 */
@Entity
public class DutyAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private DetailType detailType;

    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "soldier_id")
    private Soldier soldier;

    public DutyAssignment() {}

    public DutyAssignment(LocalDate date, DetailType detailType) {
        this.date = date;
        this.detailType = detailType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setDetailType(DetailType detailType) {
        this.detailType = detailType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Soldier getSoldier() {
        return soldier;
    }

    public void setSoldier(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public String toString() {
        String s = soldier == null ? "TBD" : soldier.toString();
        return String.format("%s on %s filled by %s | id: %s", detailType.toString(), date, s, id);
    }
}
