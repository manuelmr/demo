package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

	}

	@Bean
	CommandLineRunner runner(MusicoRepository musicoRepository){
	    return args -> {
            List<Musico> banda = new ArrayList<>();
            banda.add(new Musico("Yosi", "Voz"));
            banda.add(new Musico("Alberto", "Guitarra"));
            banda.add(new Musico("Fernando", "Guitarra"));
            banda.add(new Musico("Charli", "Bajo"));
            banda.add(new Musico("Tino", "Batería"));

            banda.forEach(musico -> musicoRepository.save(musico));

            musicoRepository.findAll().forEach(musico -> musico.getInstrumento());

            System.out.println(musicoRepository.findAllByNombre("Yosi"));

        };
    }

    /**
     * Health check personalizado para ver en /health
     * @return
     */
    @Bean
    HealthIndicator gritoYosi(){
	    return () -> {
            return Health.status("¿Hay alguien ahí?").withDetail("respuesta", "Siii").build();
	    };
    }
}
