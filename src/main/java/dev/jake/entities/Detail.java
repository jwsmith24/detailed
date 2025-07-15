package dev.jake.entities;

import dev.jake.util.DetailType;
import java.util.ArrayList;
import java.util.List;

/**
 * A detail object represents a DA Form 6 for a specific duty with the exception that it is a
 * continuous, living document so that it's not required to make a new one for each month and
 * carry over Soldier data. Incoming and outgoing Soldiers can simply be added or removed from
 * the roster by the detail manager.
 */
public class Detail {
    private final DetailType type;
    private String description; // include relevant info such as location, important POCs
    private final List<Soldier> roster;

    public Detail (DetailType type){
        this.type = type;
        this.roster = new ArrayList<Soldier>();
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

    public List<Soldier> getRoster() {
        return roster;
    }
}
