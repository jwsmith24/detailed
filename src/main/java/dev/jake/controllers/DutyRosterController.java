package dev.jake.controllers;

import dev.jake.entities.DutyAssignment;
import dev.jake.entities.DutyRoster;
import dev.jake.services.DutyRosterService;
import dev.jake.util.DetailType;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rosters")
public class DutyRosterController {

    private final DutyRosterService dutyRosterService;


    public DutyRosterController(DutyRosterService dutyRosterService) {
        this.dutyRosterService = dutyRosterService;
    }


    @PostMapping
    public ResponseEntity<String> createNewRoster(@RequestParam String type) {

        try {
            DetailType parsedType = DetailType.valueOf(type.toUpperCase()); // accepts cq or CQ
            dutyRosterService.createNewDutyRoster(parsedType);
            return ResponseEntity.ok("Roster created for: " + parsedType);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid detail type: " + type); // frontend
            // should only offer supported choices as options but bonus safety
        }

    }

    @PostMapping("/{rosterId}")
    public ResponseEntity<DutyRoster> addNewDutyToRoster(@PathVariable Long rosterId,
                                                     @RequestBody DutyAssignment assignment) {
        return dutyRosterService.addDutyToRoster(rosterId, assignment);
    }

    @GetMapping
    public ResponseEntity<List<DutyRoster>> getAllRosters() {
        List<DutyRoster> rosters = dutyRosterService.getAllRosters();
        // check for empty list
        if (rosters == null || rosters.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204: no content
        }

        return ResponseEntity.ok(rosters);
    }

    @GetMapping("/{rosterId}")
    public ResponseEntity<DutyRoster> getRosterById(@PathVariable Long rosterId) {

        Optional<DutyRoster> targetRoster = dutyRosterService.getRosterById(rosterId);

        return targetRoster.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

}
