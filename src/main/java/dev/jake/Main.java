package dev.jake;

import dev.jake.entities.DutyAssignment;
import dev.jake.entities.DutyRoster;
import dev.jake.entities.Soldier;
import dev.jake.util.DetailType;
import dev.jake.util.Rank;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        DutyRoster staffDutyRunner = new DutyRoster(DetailType.SD_RUNNER);
        DutyRoster staffDutyOic = new DutyRoster(DetailType.SD_OIC);


        Soldier jake = new Soldier("Smith", Rank.SSG);
        Soldier aric = new Soldier("Andrews", Rank.SSG);
        Soldier dejuan = new Soldier("Gibson", Rank.SSG);


        staffDutyRunner.addDuty(LocalDate.of(2025, 7, 16));
        staffDutyRunner.addDuty(LocalDate.of(2025, 7, 17));
        staffDutyRunner.addDuty(LocalDate.of(2025, 7, 18));

        staffDutyRunner.getDutyAssignments().forEach((id, assignment) -> System.out.printf(assignment.toString() + "\n")) ;


        // check if jake is available for staff duty
        boolean isJakeAvailable = jake.isAvailable(LocalDate.parse("2025-07-16"));
        System.out.println(isJakeAvailable);

        if (isJakeAvailable) {
            DutyAssignment target = staffDutyRunner.getDutyAssignment(1);
            // update detail info on duty roster
            target.assignSoldierToDuty(jake);
            // update soldier tracker for upcoming duties
            jake.addAssignment(target);
        }

        boolean isJakeAvailableDayBefore = jake.isAvailable(LocalDate.parse("2025-07-15"));
        if (!isJakeAvailableDayBefore) {
            System.out.println("jake is not available for this duty on the day before a scheduled duty");
        }

        boolean isJakeAvailableDayAfter = jake.isAvailable(LocalDate.parse("2025-07-16"));
        if (!isJakeAvailableDayBefore) {
            System.out.println("jake is not available for this duty on the day after a scheduled duty");
        }



        staffDutyRunner.getDutyAssignments().forEach((id, assignment) -> System.out.printf(assignment.toString() + "\n")) ;







    }
}