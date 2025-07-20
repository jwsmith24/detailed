package dev.jake.services;

import dev.jake.entities.DutyAssignment;
import dev.jake.entities.DutyRoster;
import dev.jake.repos.DutyRosterRepository;
import dev.jake.util.DetailType;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DutyRosterService {

    private final DutyRosterRepository dutyRosterRepository;

    public DutyRosterService(DutyRosterRepository dutyRosterRepository) {
        this.dutyRosterRepository = dutyRosterRepository;
    }



    public void createNewDutyRoster(DetailType detailType) {
        DutyRoster newRoster = new DutyRoster(detailType);
        dutyRosterRepository.save(newRoster);
    }

    public ResponseEntity<List<DutyRoster>> getAllRosters() {
        List<DutyRoster> dutyRosters = dutyRosterRepository.findAll();
        // check for empty list
        if (dutyRosters.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(dutyRosters);
    }



    public ResponseEntity<DutyRoster> getRosterById(Long id) {

        Optional<DutyRoster> roster = dutyRosterRepository.findById(id);

        return roster.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    public ResponseEntity<DutyRoster> addDutyToRoster(Long rosterId, DutyAssignment assignment) {

        // check if target duty roster exists
        Optional<DutyRoster> targetRoster = dutyRosterRepository.findById(rosterId);

        if (targetRoster.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        }

        // add new duty assignment to roster and return updated roster
        DutyRoster roster = targetRoster.get();
        roster.addDuty(assignment);
        return ResponseEntity.ok(roster);
    }


}
