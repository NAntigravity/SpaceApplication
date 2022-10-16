package space.simulation.spaceapplication.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import space.simulation.spaceapplication.dto.GameObjectDTO;
import space.simulation.spaceapplication.game.ControlClass;
import space.simulation.spaceapplication.game.config.SpaceAppConfig;

@RestController
public class SpaceAppRestController {
    AnnotationConfigApplicationContext context;
    ControlClass game;

    public SpaceAppRestController() {
        context = new AnnotationConfigApplicationContext(SpaceAppConfig.class);
        game = context.getBean(ControlClass.class);
    }

    private String Info() throws JsonProcessingException {
        ObjectMapper serialization = new ObjectMapper();
        var map = game.getInfoAboutMap();
        var entities = game.getEntities();
        return serialization.writeValueAsString(new GameObjectDTO(map, entities));
    }

    @GetMapping("/spaceAPI")
    public ResponseEntity<String> formationInfoAboutWorld() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(Info());
    }
}