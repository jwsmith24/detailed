package dev.jake.repos;

import dev.jake.entities.Soldier;
import dev.jake.entities.SoldierRosterEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface SoldierRosterEntryRepository extends JpaRepository<SoldierRosterEntry, Long> {


}
