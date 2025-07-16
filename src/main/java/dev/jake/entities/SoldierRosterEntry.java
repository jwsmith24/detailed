package dev.jake.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * A roster entry object represents a Soldier on a unique DA6.
 */
@Entity
public class SoldierRosterEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Soldier soldier;

    private LocalDate lastWeekdayDuty;
    private LocalDate lastWeekendOrHolidayDuty;


    public Long getId() {
        return id;
    }

    public Soldier getSoldier() {
        return soldier;
    }

    public LocalDate getLastWeekdayDuty() {
        return lastWeekdayDuty;
    }

    public LocalDate getLastWeekendOrHolidayDuty() {
        return lastWeekendOrHolidayDuty;
    }

    protected SoldierRosterEntry() {}

    //todo toString, equals, override
}


