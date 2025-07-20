package dev.jake.repos;

import dev.jake.entities.DutyAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DutyAssignmentRepository extends JpaRepository<DutyAssignment, Long> {
}
