package com.metaenlace.gestionCitasMedicas.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.metaenlace.gestionCitasMedicas.entity.Diagnostico;

public interface IDiagnosticoRepository extends CrudRepository<Diagnostico, Long> {

  List<Diagnostico> findByEnfermedad(String enfermedad);

  Diagnostico findById(long id);
  
}