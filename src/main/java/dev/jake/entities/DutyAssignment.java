package dev.jake.entities;

import dev.jake.util.DetailType;

import java.time.LocalDate;

public class DutyAssignment {
    private LocalDate date;
    private DetailType type;
    private String location;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public DetailType getType() {
        return type;
    }

    public void setType(DetailType type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
