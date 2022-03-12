package com.edix.eventos.spring.boot.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edix.eventos.spring.boot.modelo.entitybeans.Evento;
import com.edix.eventos.spring.boot.modelo.repository.EventoRepository;



@Repository
public class EventoDaoImpl implements EventoDao{
	
	private List<Evento> lista;
	
	/**
	 * Inyección de los métodos del repository
	 */
	@Autowired
	private EventoRepository erepo;
	/**
	 * --------------CRUD------------------------------------------
	 */
	@Override
	public List<Evento> findAll() {
	
		return erepo.findAll();
	}
	

	@Override
	public List<Evento> muestraActivos() {

		List<Evento> listaActivos = new ArrayList<Evento>();
		List<Evento>listarEventos=erepo.findAll();
		for(Evento ele: listarEventos) {
			if(ele.getDestacado().equalsIgnoreCase("s"))
				listaActivos.add(ele);
		}
		return listaActivos;
		
	}
	

	@Override
	public List<Evento> muestraDestacados() {
		

		List<Evento> listaDestacados = new ArrayList<Evento>();
		List<Evento>listarEventos=erepo.findAll();
		for(Evento ele: listarEventos) {
			if(ele.getDestacado().equalsIgnoreCase("s"))
				listaDestacados.add(ele);
		}
		return listaDestacados;
	}

	
	

	@Override
	public Evento verUno(int idEvento) {
		
		return erepo.findById(idEvento).orElse(null);
	}

	@Override
	public int insertar(Evento evento) {
		if(verUno(evento.getIdEvento()) == null) {
			erepo.save(evento);
			return 1;
		}else
			return 0;
		
		
	}

	@Override
	public int modificar(Evento evento) {
		if(verUno(evento.getIdEvento()) != null) {
			erepo.save(evento);
			return 1;
		}else
			return 0;
	}

	@Override
	public int eliminar(int idEvento) {
		if(verUno(idEvento) != null) {
			erepo.deleteById(idEvento);
			return 1;
		}else
			return 0;
	}

	/**
	 * Métdod para buscar evento que contiene la subcadena pasada por parámetro
	 */
	@Override
	public List<Evento> findBySubcadena(String subcadena) {
		
		List<Evento> listaSubcadena = new ArrayList<Evento>();
		List<Evento>listaEventos=erepo.findAll();
		for(Evento ele: listaSubcadena) {
			if(ele.getNombre().contains(subcadena)||ele.getDescripcion().contains(subcadena))
				listaSubcadena.add(ele);
		}
		return listaSubcadena;
	}

}
