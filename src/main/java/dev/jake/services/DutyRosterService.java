package dev.jake.services;

import dev.jake.entities.DutyAssignment;
import dev.jake.entities.DutyRoster;
import dev.jake.repos.DutyRosterRepository;
import dev.jake.util.DetailType;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

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

    public List<DutyRoster> getAllRosters() {
        return dutyRosterRepository.findAll();
    }

    public Optional<DutyRoster> getRosterById(Long id) {
        return dutyRosterRepository.findById(id);

    }



    public Optional<DutyRoster> addDutyToRoster(Long rosterId, LocalDate date, DetailType type) {
        try {
            // look up roster by id
            Optional<DutyRoster> targetRoster = dutyRosterRepository.findById(rosterId);
            targetRoster.get().addDuty();

        }




    }


}
