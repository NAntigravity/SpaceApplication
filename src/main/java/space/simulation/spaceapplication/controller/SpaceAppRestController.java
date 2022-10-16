package space.simulation.spaceapplication.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import space.simulation.spaceapplication.game.ControlClass;

@RestController
public class SpaceAppRestController {
    public static ControlClass game;

    @GetMapping("/spaceAPI")
    public ResponseEntity<String> formationInfoAboutWorld() throws JsonProcessingException {
        game = new ControlClass();
        ObjectMapper serialization = new ObjectMapper();
        String json = serialization.writeValueAsString(game.getInfoAboutMap());
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(json);

    }
}