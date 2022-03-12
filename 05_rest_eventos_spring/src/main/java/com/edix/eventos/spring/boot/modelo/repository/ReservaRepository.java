package com.edix.eventos.spring.boot.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.eventos.spring.boot.modelo.entitybeans.Reserva;


public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
	
	@Query("select sum(r.cantidad) from Reserva r where r.evento.idEvento=?1")
	
	public int plazasQuedan(int idEvento);

}
