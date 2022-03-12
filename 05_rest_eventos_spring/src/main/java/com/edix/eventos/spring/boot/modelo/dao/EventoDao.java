package com.edix.eventos.spring.boot.modelo.dao;

import java.util.List;

import com.edix.eventos.spring.boot.modelo.entitybeans.Evento;



public interface EventoDao {
	
	List<Evento> findAll();
	List<Evento> muestraActivos();
	List<Evento> muestraDestacados();
	List<Evento> findBySubcadena(String subcadena);
	Evento verUno(int idEvento);
	int insertar(Evento evento);
	int modificar(Evento evento);
	int eliminar(int idEvento);
	

}
