package com.metaenlace.gestionCitasMedicas.utils;

import org.modelmapper.ModelMapper;

import com.metaenlace.gestionCitasMedicas.dto.CitaDTO;
import com.metaenlace.gestionCitasMedicas.dto.DiagnosticoDTO;
import com.metaenlace.gestionCitasMedicas.dto.MedicoRegistroDTO;
import com.metaenlace.gestionCitasMedicas.dto.PacienteRegistroDTO;
import com.metaenlace.gestionCitasMedicas.dto.medico.MedicoDTO;
import com.metaenlace.gestionCitasMedicas.dto.paciente.PacienteDTO;
import com.metaenlace.gestionCitasMedicas.entity.Cita;
import com.metaenlace.gestionCitasMedicas.entity.Diagnostico;
import com.metaenlace.gestionCitasMedicas.entity.Medico;
import com.metaenlace.gestionCitasMedicas.entity.Paciente;

public class DtoMapper {
	
	private static ModelMapper modelMapper = new ModelMapper();
	
    public static CitaDTO citaToDto(Cita cita) {
    	CitaDTO postDto = modelMapper.map(cita, CitaDTO.class);
        return postDto;
    }
    
    public static Cita dtoToCita(CitaDTO citaDTO) {
    	Cita cita = modelMapper.map(citaDTO, Cita.class);
        return cita;
    }
    
    public static DiagnosticoDTO diagnosticoToDto(Diagnostico diag) {
    	DiagnosticoDTO postDto = modelMapper.map(diag, DiagnosticoDTO.class);
        return postDto;
    }
    
    public static Diagnostico dtoToDiagnostico(DiagnosticoDTO diagDTO) {
    	Diagnostico diag = modelMapper.map(diagDTO, Diagnostico.class);
        return diag;
    }
    
    public static MedicoDTO medicoToDto(Medico med) {
    	MedicoDTO postDto = modelMapper.map(med, MedicoDTO.class);
        return postDto;
    }
    
    public static Medico dtoToMedico(MedicoDTO medDTO) {
    	Medico med = modelMapper.map(medDTO, Medico.class);
        return med;
    }
    
    public static Medico medRegDtoToMedico(MedicoRegistroDTO medRegDTO) {
    	Medico med = modelMapper.map(medRegDTO, Medico.class);
        return med;
    }
    
    public static PacienteDTO pacienteToDto(Paciente pac) {
    	PacienteDTO postDto = modelMapper.map(pac, PacienteDTO.class);
        return postDto;
    }
    
    public static Paciente dtoToPaciente(PacienteDTO pacDTO) {
    	Paciente pac = modelMapper.map(pacDTO, Paciente.class);
        return pac;
    }
    
    public static Paciente pacRegDtoToPaciente(PacienteRegistroDTO pacRegDTO) {
    	Paciente pac = modelMapper.map(pacRegDTO, Paciente.class);
        return pac;
    }
}
