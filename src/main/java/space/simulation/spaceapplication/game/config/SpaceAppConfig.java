package space.simulation.spaceapplication.game.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import space.simulation.spaceapplication.game.ControlClass;

@Configuration
public class SpaceAppConfig {
    @Bean
    @Scope("singleton")
    public ControlClass getControlClass() {
        return ControlClass.getInstance();
    }
}
