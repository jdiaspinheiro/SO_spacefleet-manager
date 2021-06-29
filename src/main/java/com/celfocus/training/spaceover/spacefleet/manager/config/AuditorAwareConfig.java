package com.celfocus.training.spaceover.spacefleet.manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import java.util.Optional;

@Configuration
//@EnableJpaAuditing
@EnableMongoAuditing
public class AuditorAwareConfig implements AuditorAware<String> {

    @Bean
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable("SpaceOver");
    }
}
