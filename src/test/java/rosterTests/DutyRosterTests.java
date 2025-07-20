package rosterTests;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;


import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = dev.jake.Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = Replace.ANY)
class DutyRosterTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldReturnDutyRosterWithId() {
        ResponseEntity<String> response = restTemplate.getForEntity("/rosters/99", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());

        System.out.print(documentContext);
        Number id = documentContext.read("$.roster_id");

        assertThat(id)
                .isNotNull()
                .isEqualTo(99);

    }

    @Test
    void shouldReturnAllDutiesFromRoster() {
        ResponseEntity<String> response = restTemplate.getForEntity("/rosters", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext context = JsonPath.parse(response.getBody());
        int dutyCount = context.read("$.length()");
        assertThat(dutyCount).isEqualTo(2);

        JSONArray rosterIds = context.read("$..roster_id");
        assertThat(rosterIds).containsExactlyInAnyOrder(99, 100);
    }

    @Test
    void shouldAddNewDutyToRoster() {
        // todo
    }


}
