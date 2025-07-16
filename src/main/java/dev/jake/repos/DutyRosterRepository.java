package dev.jake.repos;

import dev.jake.entities.DutyRoster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DutyRosterRepository extends JpaRepository<DutyRoster, Long> {
}
