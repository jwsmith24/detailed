package dev.jake;

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
        Soldier andrews = new Soldier("Andrews", Rank.SSG);
        Soldier gibson = new Soldier("Gibson", Rank.SSG);

        System.out.printf("%s %s has %d days of approved absences.\n", jake.getRank(), jake.getName(), jake.getDaysOfApprovedAbsences());

        staffDutyRunner.addDuty(LocalDate.of(2025, 7, 16));
        staffDutyRunner.addDuty(LocalDate.of(2025, 7, 17));
        staffDutyRunner.addDuty(LocalDate.of(2025, 7, 18));

        staffDutyRunner.getDutyAssignments().forEach(System.out::println);







    }
}