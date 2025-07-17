package dev.jake.entities;

import dev.jake.util.DetailType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A detail object represents a DA Form 6 for a specific duty with the exception that it is a
 * continuous, living document so that it's not required to make a new one for each month and
 * carry over Soldier data. Incoming and outgoing Soldiers can simply be added or removed from
 * the roster by the detail manager.
 *
 * <p>
 * A DutyRoster object contains a list of roster entries which consist of a Soldier's metadata plus their last
 * time pulling that specific duty.
 * </p>
 */

@Entity
public class DutyRoster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description; // include relevant info such as location, important POCs

    @Enumerated(EnumType.STRING)
    private DetailType type;

    // tracks each soldier eligible to pull the specific duty (cq, sd, etc.)
    @OneToMany
    private List<SoldierRosterEntry> rosterEntries;

    // tracks duties that will need to be filled
    @OneToMany
    private List<DutyAssignment> dutyAssignments;



    public DutyRoster(DetailType type) {
        this.type = type;
        this.rosterEntries = new ArrayList<>();
    }

    public DutyRoster(){}

    public List<DutyAssignment> getDutyAssignments() {
        return this.dutyAssignments;
    }

    // used to add a new duty that will need to be filled by someone on the roster
    public void addDuty(LocalDate date) {
        this.dutyAssignments.add(new DutyAssignment(date, this.type));
    }



}
