package Level;

import java.util.*;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animation.Pictures;
import Colisionador.*;
import Datos.IconsManager;
import Entidades.*;
import Entrada.Discreta;
import InterfazGrafica.*;

public abstract class AbsNivel {//Implementar runnable

	protected Pantalla pantalla;

	protected Player player;
	protected Mostrador vida;
	
	protected Collection<Entidad> demasEntidades;
	private Collection<Entidad> toRemoveEnt;
	private Collection<Entidad> toAddEnt;





	//-------------------------------- METODOS

	public abstract void crear();
	public abstract void iniciar();
	public abstract boolean gane();
	public abstract boolean limpiar();

	protected AbsNivel(){
		demasEntidades = new ArrayList<>();
		player = Player.getInstance();
		vida= new Mostrador(IconsManager.v1);
		vida.setBounds(700, 500, 100, 100);
		toRemoveEnt = new LinkedList<>();
		toAddEnt= new LinkedList<>();
		demasEntidades.add(player);
	}

	public void eliminaTodosLosEnemies(){
		toRemoveEnt.addAll(toRemoveEnt);
	}

	public void setPantalla(Pantalla p) {
		pantalla=p;
	}
	
	public void inicializar() {
		pantalla.run();
	}

	public void agregarTodo() {
		pantalla.addMostrable(player.getMostrable());
		demasEntidades.forEach(e -> pantalla.addMostrable(e.getMostrable()));
		refrescarTodo();
	}

	public void refrescarTodo() {
		player.refresh();
		demasEntidades.forEach(e->e.refresh());
		checkColisiones();
		for (Entidad e: toRemoveEnt) {
			demasEntidades.remove(e);
			PantallaJuego.getInstance().removeMostrable(e.getMostrable());
		}
		toRemoveEnt.removeAll(toRemoveEnt);
		for (Entidad e: toAddEnt) {
			demasEntidades.add(e);
		}
		toAddEnt.removeAll(toAddEnt);
	}	
	
	protected void checkColisiones() {
		for(Entidad e : demasEntidades) {
			if(e.getVida()<=0) {
				toRemoveEnt.add(e);
				player.sumarPuntaje(e);
				System.out.println("Puntaje: "+player.getPuntaje());
			}
			if(e.getCuerpo().getPosicion().getX()>600 && e.getCuerpo().getPosicion().getY()>800) {
				toRemoveEnt.add(e);			
			}
			for(Entidad e1: demasEntidades) {
				if(e!=e1 && e.getCuerpo().CollidesWith(e1.getCuerpo())) {
					e.colisionasteCon(e1);
				}
			}
		}
	}


	protected void controlarVida() {
		if(player.getVida() >83.4) {
			vida.setIcon(IconsManager.v1);
			PantallaJuego.getInstance().addMostrable(vida);
		}
		else 
			if(player.getVida() > 66.8) {
				vida.setIcon(IconsManager.v2);
				PantallaJuego.getInstance().addMostrable(vida);
			}
			else 
				if(player.getVida() >50.2){
					vida.setIcon(IconsManager.v3);
					PantallaJuego.getInstance().addMostrable(vida);
				}
				else
					if(player.getVida() > 33.6){
						vida.setIcon(IconsManager.v4);
						PantallaJuego.getInstance().addMostrable(vida);
					}
					else
						if(player.getVida() > 17){
							vida.setIcon(IconsManager.v5);
							PantallaJuego.getInstance().addMostrable(vida);
						}
						else {
							vida.setIcon(IconsManager.v6);
							PantallaJuego.getInstance().addMostrable(vida);
						}
	}

	public abstract int getNumeroNivel();

	public Collection<Entidad> getEntidades(){
		return demasEntidades;
	}

	public int getCantidadEntidades() {
		return demasEntidades.size();
	}
	public void addEntity(Entidad e) {
		toAddEnt.add(e);
		PantallaJuego.getInstance().addMostrable(e.getMostrable());
	}

	public void removeEntity(Entidad e) {
		toRemoveEnt.remove(e);		
		PantallaJuego.getInstance().removeMostrable(e.getMostrable()); 
		demasEntidades.remove(e);
	}

}
