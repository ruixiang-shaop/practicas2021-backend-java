package com.metaenlace.gestionCitasMedicas.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.metaenlace.gestionCitasMedicas.entity.Cita;

public interface ICitaRepository extends CrudRepository<Cita, Long> {

  List<Cita> findByMotivoCita(String motivoCita);

  Cita findById(long id);
  
}
