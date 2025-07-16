package dev.jake;

import dev.jake.entities.DutyAssignment;
import dev.jake.entities.DutyRoster;
import dev.jake.entities.Soldier;
import dev.jake.util.DetailType;
import dev.jake.util.Rank;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }
}