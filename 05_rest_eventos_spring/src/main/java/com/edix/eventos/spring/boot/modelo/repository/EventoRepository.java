package com.edix.eventos.spring.boot.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.eventos.spring.boot.modelo.entitybeans.Evento;



public interface EventoRepository extends JpaRepository<Evento, Integer>{

}
