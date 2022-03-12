package com.edix.eventos.spring.boot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.eventos.spring.boot.modelo.dao.EventoDao;
import com.edix.eventos.spring.boot.modelo.dao.ReservaDao;
import com.edix.eventos.spring.boot.modelo.entitybeans.Evento;
import com.edix.eventos.spring.boot.modelo.entitybeans.Reserva;

/**
 * 
 * @author mcarm
 *
 */
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/rest/eventos")
public class EventoRestController {
	
	@Autowired
	private EventoDao edao;
	
	@Autowired
	private ReservaDao rdao;
	/**
	 * -------------------------------MÉTODOS CRUD---------------------------------------------------------------------
	 */
	
	/**
	 * 
	 * @return una lista con todos los eventos
	 */
	
	@GetMapping("/todos")
	public List<Evento> procTodos(){
		
		return edao.findAll();
	}
	
	/**
	 * 
	 * @param idEvento
	 * @return un evento el que coincide con el id que le paso por parámetro
	 */
	
	@GetMapping("/verUno/{idEvento}")
	public Evento procTodas(@PathVariable("idEvento") int idEvento){
		
		return edao.verUno(idEvento);
	}
	
	/**
	 * 
	 * @param evento
	 * @return un mensaje alta realizada o no realizada
	 */
	@PostMapping("/alta")
	public String procAlta(@RequestBody Evento evento) {
		
		return (edao.insertar(evento) == 1)?"Alta realizada":"Alta NOOO realizada";
	}
	
	/**
	 * 
	 * @param evento
	 * @return mensaje si se ha modificado o no
	 */
	
	@PutMapping("/modificar")
	public String procModi(@RequestBody Evento evento) {
		
		return (edao.modificar(evento) == 1)?"Modificación realizada":"Modificación NOOO realizada";
	}
	
	@DeleteMapping("/eliminar/{idEvento}")
	public String procModi(@PathVariable("idEvento") int idEvento) {
		
		return (edao.eliminar(idEvento) == 1)?"Eliminación realizada":"Eliminación NOOO realizada";
	}
	
	
	//-----------para ver las plazas libres que quedan en un evento
	/**
	 * ----------Búsquedas especiales---------------
	 * 
	 * @param idEvento
	 * @return un string con las plazas que quedan libres y la descripción del evento.
	 */
	
	@GetMapping("/plazasQuedan/{id}")
    public String plazasQuedan(@PathVariable("id") int idEvento) {
		
		return rdao.plazasQuedan(idEvento);

    }
	/**
	 * 
	 * @param subcadena
	 * @return una lista con eventos que contienen la subcadena
	 */
	
	@GetMapping ("/buscarEventos/{subcadena}")
	public List<Evento> buscarEventoPorCadena(@PathVariable ("subcadena") String subcadena) {
		
		return edao.findBySubcadena(subcadena);
		
	}
	
	/**
	 * 
	 * @return lista destacados
	 */
	
	@GetMapping ("/destacados")
	public List<Evento> buscarEventosDestacados() {
		
		return edao.muestraDestacados();
		
	}
	
	/**
	 * 
	 * @return lista activos
	 */
	
	@GetMapping ("/activos")
	public List<Evento> buscarEventosActivos() {
		
		return (edao.muestraActivos());
		
	}
	

}
