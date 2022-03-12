package com.edix.eventos.spring.boot.modelo.dao;

import java.util.List;


import com.edix.eventos.spring.boot.modelo.entitybeans.Reserva;

public interface ReservaDao {
	
	public String plazasQuedan(int idEvento);
	List<Reserva> findByEvento (int idEvento);

}
