package com.edix.eventos.spring.boot.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edix.eventos.spring.boot.modelo.entitybeans.Evento;
import com.edix.eventos.spring.boot.modelo.entitybeans.Reserva;
import com.edix.eventos.spring.boot.modelo.repository.EventoRepository;
import com.edix.eventos.spring.boot.modelo.repository.ReservaRepository;

@Repository
public class ReservaDaoImpl implements ReservaDao{
	
	private List<Reserva> lista;
	
	
	@Autowired
	private ReservaRepository rrepo;
	
	@Autowired
	private EventoRepository erepo;

	

	@Override
	public String plazasQuedan(int idEvento) {
		int plazasReserva =rrepo.plazasQuedan(idEvento);
		int libres= erepo.getById(idEvento).getAforoMaximo()-plazasReserva;
		return "Plazas en evento : " + erepo.getById(idEvento).getDescripcion() + ". En este evento quedan libres: " + libres + " plazas.";
	}



	@Override
	public List<Reserva> findByEvento(int idEvento) {
		List<Reserva>aux = new ArrayList<Reserva>();
		for (Reserva ele:lista) {
			if (ele.getEvento().getIdEvento()==(idEvento))
				aux.add(ele);
		}
		return aux;
	}


}
