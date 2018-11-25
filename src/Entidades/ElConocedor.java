package Entidades;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import Level.LevelDirector;
import TiposDeDatos.Coords;
public class ElConocedor implements Refrescable{
//Clase maestra que conoce todas las entidades y las colisiones que ocurren (Cliente)
//Esta clase detecta y elimina las entidades que son disparadas
	
	//Singleton
	private static ElConocedor instance;
	public static ElConocedor instancia() {
		if(instance==null) {
			instance = new ElConocedor();
		}
		return instance;
	}

	private Collection<Entidad> entidades;
	private Queue<Entidad> removeQueue; //TODO HACER OTRO PARA ADD
	private Queue<Entidad> addQueue;
	
	
	private ElConocedor() {
		entidades = new HashSet<>();
		removeQueue = new LinkedList<>();
		addQueue = new LinkedList<>();
	}	
	
	public void add(Entidad entidad) {
		entidades.add(entidad);
		addQueue.add(entidad);
	}
	
	public void refresh(){
		for(Entidad e : entidades) {
			if(e.getVida()<=0) {
				removeQueue.add(e);
				LevelDirector.instancia().currentLevel().removeEntity(e);
			}
			for(Entidad e1:entidades) {
				if(e!=e1 && e.getCuerpo().CollidesWith(e1.getCuerpo())) {
					e.colisionasteCon(e1);
				}
			}
		}
		while(!removeQueue.isEmpty()) {
			entidades.remove(removeQueue.remove());
		}
	}
}
