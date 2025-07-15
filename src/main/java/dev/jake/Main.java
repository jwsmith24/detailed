package dev.jake;

import dev.jake.entities.DutyRoster;
import dev.jake.util.DetailType;

public class Main {
    public static void main(String[] args) {

        DutyRoster staffDuty = new DutyRoster(DetailType.SD);
        DutyRoster cq = new DutyRoster(DetailType.CQ);

    }
}