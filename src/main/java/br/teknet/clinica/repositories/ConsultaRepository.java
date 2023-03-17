package br.teknet.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.teknet.clinica.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    
}
