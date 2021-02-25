package com.metaenlace.gestionCitasMedicas;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestionCitasMedicasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionCitasMedicasApplication.class, args);
	}
	
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
