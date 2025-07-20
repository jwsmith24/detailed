package dev.jake.entities;

import dev.jake.util.DetailType;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * The DutyAssignment object represents a given duty that will need to be filled via polling the roster.
 * It captures all the necessary information about the specific duty and will be tracked
 */
@Entity
public class DutyAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private DetailType detailType;



    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "soldier_id")
    private Soldier soldier;

    public DutyAssignment() {}


    public Long getId() {
        return id;
    }


    public LocalDate getDate() {
        return date;
    }

    public DetailType getDetailType() {
        return detailType;
    }

    public Soldier getSoldier() {
        return soldier;
    }

    public String getDescription() {return description;}



    @Override
    public String toString() {
        String s = soldier == null ? "TBD" : soldier.toString();
        return String.format("%s on %s filled by %s | id: %s", detailType.toString(), date, s, id);
    }
}
