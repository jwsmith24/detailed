package dev.jake.services;

import dev.jake.entities.DutyAssignment;
import dev.jake.entities.Soldier;
import dev.jake.repos.SoldierRepository;
import dev.jake.util.DetailType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@Service
public class SoldierService {

    private final SoldierRepository soldierRepository;

    private final Map<Long, Map<DetailType, Integer>> detailTrackers = new HashMap<>();


    public SoldierService(SoldierRepository soldierRepository) {
        this.soldierRepository = soldierRepository;

    }

    //todo: change to build soldier with inputs
    public void addNewSoldier(Soldier soldier) {
        soldierRepository.save(soldier);
    }




    public boolean isAvailable(Soldier soldier, LocalDate date) {
        LocalDate start = soldier.getLeaveStartDate();
        LocalDate end = soldier.getLeaveEndDate();

        if (start != null && end != null && !date.isBefore(start) && !date.isAfter(end)) {
            return false;
        }

        for (DutyAssignment assignment : soldier.getAssignedDuties()) {
            LocalDate existingDate = assignment.getDate();
            if (existingDate.equals(date) ||
                    existingDate.equals(date.minusDays(1)) ||
                    existingDate.equals(date.plusDays(1))) {
                return false;
            }
        }

        return true;
    }

    public void assignDuty(Soldier soldier, DutyAssignment assignment) {
        soldier.getAssignedDuties().add(assignment);
        detailTrackers
                .computeIfAbsent(soldier.getId(), id -> new HashMap<>())
                .merge(assignment.getDetailType(), 1, Integer::sum);

        System.out.printf("%s assigned to %s on %s\n", assignment.getDetailType(), soldier, assignment.getDate());
    }

    public void removeDuty(Soldier soldier, DutyAssignment assignment) {
        if (!soldier.getAssignedDuties().remove(assignment)) {
            System.out.println("Could not remove assignment");
            return;
        }

        detailTrackers.computeIfPresent(soldier.getId(), (id, map) -> {
            DetailType type = assignment.getDetailType();
            int count = map.getOrDefault(type, 0) - 1;
            if (count <= 0) {
                map.remove(type);
            } else {
                map.put(type, count);
            }
            return map;
        });
    }

    public void setLeaveDays(Soldier soldier, LocalDate start, LocalDate end) {
        if (start == null || end == null || start.isAfter(end)) {
            throw new IllegalArgumentException("Invalid leave dates");
        }

        soldier.setLeaveStartDate(start);
        soldier.setLeaveEndDate(end);
        soldier.setDaysOfApprovedAbsences((int) ChronoUnit.DAYS.between(start, end) + 1);
    }

    public void clearLeave(Soldier soldier) {
        soldier.setLeaveStartDate(null);
        soldier.setLeaveEndDate(null);
        soldier.setDaysOfApprovedAbsences(0);
    }

    public Map<DetailType, Integer> getDetailTracker(Soldier soldier) {
        return Map.copyOf(detailTrackers.getOrDefault(soldier.getId(), Map.of()));
    }
}
