package dev.jake.services;

import dev.jake.entities.DutyAssignment;
import dev.jake.repos.DutyRosterRepository;
import dev.jake.util.DetailType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

@Service
public class DutyRosterService {

    private final DutyRosterRepository dutyRosterRepository;

    // tracks duties that need to be filled
    private Map<Long, DutyAssignment> dutyAssignments;

    public DutyRosterService(DutyRosterRepository dutyRosterRepository) {
        this.dutyRosterRepository = dutyRosterRepository;
    }

    public void addDuty(LocalDate date, DetailType type) {
        DutyAssignment newDuty = new DutyAssignment(date, type);
        this.dutyAssignments.put(newDuty.getId(), newDuty);

    }


    public Map<Long, DutyAssignment> getDutyAssignments() {
        return Map.copyOf(dutyAssignments);
    }
}
