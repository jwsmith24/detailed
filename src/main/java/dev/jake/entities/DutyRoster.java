package dev.jake.entities;

import dev.jake.util.DetailType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A detail object represents a DA Form 6 for a specific duty with the exception that it is a
 * continuous, living document so that it's not required to make a new one for each month and
 * carry over Soldier data. Incoming and outgoing Soldiers can simply be added or removed from
 * the roster by the detail manager.
 *
 *  <p>
 *     A DutyRoster object contains a list of roster entries which consist of a Soldier's metadata plus their last
 *  time pulling that specific duty.
 * </p>
 *
 */
public class DutyRoster {
    private final DetailType type;
    private String description; // include relevant info such as location, important POCs

    // tracks each soldier eligible to pull the specific duty (cq, sd, etc.)
    private final List<SoldierRosterEntry> rosterEntries;
    // tracks duties that need to be filled
    // todo: change to map <id, dutyAssignment> so that we can easily assign soldiers
    private final List<DutyAssignment> dutyAssignments;

    public DutyRoster(DetailType type){
        this.type = type;
        this.rosterEntries = new ArrayList<>();
        this.dutyAssignments = new ArrayList<>();
    }

    public void addDuty(LocalDate date) {
        DutyAssignment newDuty = new DutyAssignment(date, type);
        this.dutyAssignments.add(newDuty);

    }





    public List<DutyAssignment> getDutyAssignments() {
        return dutyAssignments;
    }
    public DetailType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SoldierRosterEntry> getRoster() {
        return rosterEntries;
    }
}
