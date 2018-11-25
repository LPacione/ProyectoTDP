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

public abstract class AbsNivel {//implementar runnable

	protected Pantalla pantalla;

	protected Player player;
	protected Mostrador vida;
	protected Collection<Entidad> demasEntidades;

	private Queue<Entidad> toRemoveEnt;
	private Queue<Entidad> toAddEnt;

	private Discreta eliminaEnemigosConEnter;




	//-------------------------------- METODOS

	public abstract void crear();
	public abstract void iniciar();
	public abstract boolean gane();
	public abstract boolean limpiar();

	protected AbsNivel(){
		demasEntidades = new ArrayList<>();
		player = Player.getInstance();
		pantalla = PantallaJuego.getInstance();
		vida= new Mostrador(IconsManager.v1);
		vida.setBounds(700, 500, 100, 100);
		toRemoveEnt = new LinkedList<>();
		toAddEnt= new LinkedList<>();
		eliminaEnemigosConEnter = new Discreta(this::eliminaTodosLosEnemies, Discreta.enter);	
	}

	public void eliminaTodosLosEnemies(){
	//	System.out.println("Entro a eliminar todas las enemies");
		toRemoveEnt.addAll(demasEntidades);
	}


	public void agregarTodo() {
		pantalla.addMostrable(player.getMostrable());
		demasEntidades.forEach(e -> pantalla.addMostrable(e.getMostrable()));		
		demasEntidades.forEach(ElConocedor.instancia()::add);
		ElConocedor.instancia().add(player);	
		refrescarTodo();
	}

	public void refrescarTodo() {
		player.refresh();
		demasEntidades.forEach(e->e.refresh());	
		ElConocedor.instancia().refresh();
		while(!toRemoveEnt.isEmpty()){
			Entidad e = toRemoveEnt.remove();
			player.sumarPuntaje(e);
			demasEntidades.remove(e);
			PantallaJuego.getInstance().removeMostrable(e.getMostrable());
		}
		while(!toAddEnt.isEmpty()){
			Entidad e = toAddEnt.remove();
			demasEntidades.add(e);
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
