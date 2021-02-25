package com.metaenlace.gestionCitasMedicas;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.metaenlace.gestionCitasMedicas.entity.Cita;
import com.metaenlace.gestionCitasMedicas.entity.Diagnostico;
import com.metaenlace.gestionCitasMedicas.entity.Medico;
import com.metaenlace.gestionCitasMedicas.entity.Paciente;
import com.metaenlace.gestionCitasMedicas.repository.ICitaRepository;
import com.metaenlace.gestionCitasMedicas.repository.IDiagnosticoRepository;
import com.metaenlace.gestionCitasMedicas.repository.IMedicoRepository;
import com.metaenlace.gestionCitasMedicas.repository.IPacienteRepository;
import com.metaenlace.gestionCitasMedicas.repository.IUsuarioRepository;

//@SpringBootApplication
public class GestionCitasMedicasInitDB {

	public static void main(String[] args) {
		SpringApplication.run(GestionCitasMedicasInitDB.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(IUsuarioRepository usuarioRepository, IPacienteRepository pacienteRepository,
			IMedicoRepository medicoRepository, ICitaRepository citaRepository, IDiagnosticoRepository diagnosticoRepository) {
		return (args) -> {
			
			Paciente pac1 = new Paciente("Antonio", "Hernandez", "ah1", "1234", "001", "x001", "654654654", "calle a");
			Paciente pac2 = new Paciente("Antonio", "Perez", "ap1", "abcd", "002", "x002", "651651651", "calle b");
			Medico med1 = new Medico("Pedro", "Ros", "pr1", "666", "123456789");
			Medico med2 = new Medico("Jose", "Fernandez", "jf1", "1234", "987654321");
			
			pac1.addMedico(med1);
			pac1.addMedico(med2);
			pac2.addMedico(med1);

			med1.addPaciente(pac1);
			med2.addPaciente(pac1);
			med2.addPaciente(pac2);
			
			pac1 = pacienteRepository.save(pac1);
			pac2 = pacienteRepository.save(pac2);
			med1 = medicoRepository.save(med1);
			med2 = medicoRepository.save(med2);
			
			// crear citas y diagnosticos
			Cita c1 = new Cita(new Date(), "fiebre", pac1, med1, null);
			Cita c2 = new Cita(new Date(), "tos", pac1, med2, null);
			Cita c3 = new Cita(new Date(), "dolor de cabeza", pac2, med2, null);
			
			Diagnostico d1 = new Diagnostico("posible gripe", "gripe", c1);
			Diagnostico d2 = new Diagnostico("tos leve", "resfriado", c2);
			Diagnostico d3 = new Diagnostico("cefalea", "cefalea", c3);
			
			c1.setDiagnostico(d1);
			c2.setDiagnostico(d2);
			c3.setDiagnostico(d3);
			pac1.addCita(c1);
			pac1.addCita(c2);
			pac2.addCita(c3);
			med1.addCita(c1);
			med2.addCita(c2);
			med2.addCita(c3);
			
			citaRepository.save(c1);
			citaRepository.save(c2);
			citaRepository.save(c3);
			diagnosticoRepository.save(d1);
			diagnosticoRepository.save(d2);
			diagnosticoRepository.save(d3);
		};
	}
}
