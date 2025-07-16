package dev.jake.services;

import dev.jake.entities.Soldier;
import dev.jake.repos.SoldierRosterEntryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class SoldierRosterEntryService {


    private final SoldierRosterEntryRepository rosterEntryRepository;


    public SoldierRosterEntryService(SoldierRosterEntryRepository rosterEntryRepository) {
        this.rosterEntryRepository = rosterEntryRepository;
    }

    // todo: find days since last duty performed (weekday and weekend)
    // potentially implement as SQL query



}
