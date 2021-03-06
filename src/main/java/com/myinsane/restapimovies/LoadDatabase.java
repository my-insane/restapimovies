package com.myinsane.restapimovies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(MoviesRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Movies(
                    "Example movie",
                    2018,
                    "Somebody",
                    "02:30:00",
                    8)));
            log.info("Preloading " + repository.save(new Movies(
                    "Example movie2",
                    2019,
                    "Somebody",
                    "02:30:00",
                    8)));
        };
    }

}
