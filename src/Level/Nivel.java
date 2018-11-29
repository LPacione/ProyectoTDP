package Level;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import Datos.GameData;
import Entidades.Barricada;
import Entidades.Enemigo;
import Entidades.EnemigoArmado;
import Entidades.EnemigoKami;
import Entidades.Entidad;
import Entidades.Obstaculo;
import Entidades.Player;
import TiposDeDatos.Posicion;

public class Nivel {

	private int cantEnems;
	private int cantEnemsK;
	private int cantObs;
	private int cantEnemsA;
	private int numeroNivel;
	protected Collection<Entidad> demasEntidades;
	private Collection<Entidad> coleccionAEliminar;
	private Collection<Entidad> coleccionAAgregar;
	private Player player;
	private final int ultimoNivel = 6;


	private static Nivel instan;
	public static Nivel getInstancia(){
		if(instan==null){
			instan = new Nivel(1);
		}
		return instan;
	}

	private Nivel(int i) {
		demasEntidades = new ArrayList<>();
		player = new Player();

		coleccionAEliminar = new LinkedList<>();
		coleccionAAgregar= new LinkedList<>();
		demasEntidades.add(player);

		crear(i);
	}

	public int getUltimoNivel() {
		return ultimoNivel;
	}

	public Player getPlayer() {
		return player;
	}

	public void subirNivel() {
		numeroNivel++;
		for(Entidad e: demasEntidades) {
			if(e!=player) {
				eliminarEntidad(e);
			}
		}
		actualizarColeccion();
		crear(numeroNivel);
	}


	public void actualizarColeccion() {
		actualizarEliminados();
		for(Entidad e: coleccionAEliminar) {
			demasEntidades.remove(e);
		}
		coleccionAEliminar.removeAll(coleccionAEliminar);
		for(Entidad e: coleccionAAgregar) {
			demasEntidades.add(e);
		}
		coleccionAAgregar.removeAll(coleccionAAgregar);
	}

	private void actualizarEliminados() {
		for(Entidad e: demasEntidades) {
			if(e.getVida()<=0) {
				coleccionAEliminar.add(e);
			}
		}
	}

	private void crear(int j) {
		int ancho = GameData.WindowSize.width;

		if(j<=5) {
			numeroNivel=j;
			cantEnems = 3*j;
			cantEnemsK=3*j;
			cantObs = 2*j;
			cantEnemsA= 2*j;
		}

		//ENEMIGOS 1
		int cantXNivel= cantEnems/3;
		int n=0;
		int nivelAltura=1;
		for(int i=1; i<=cantEnems ; i++) {
			Enemigo enem = new Enemigo();
			demasEntidades.add(enem);
			Posicion pos = new Posicion(ancho*i/(cantEnems+1),100*nivelAltura);
			enem.getGrafico().setPosicion(pos.getX(),pos.getY());
			n++;
			if(n==cantXNivel) {
				n=0;
				nivelAltura++;
			}
		}

		//ENEMIGOS KAMI
		for(int i=1; i<=cantEnemsK;i++) {
			EnemigoKami enemK = new EnemigoKami();
			demasEntidades.add(enemK);
			Posicion pos = new Posicion(ancho*i/(cantEnemsK+1),350);
			enemK.getGrafico().setPosicion(pos.getX(),pos.getY());
		}
		//ENEMIGOS ARMADOS
		for(int i=1; i<=cantEnemsA; i++) {
			EnemigoArmado enemA= new EnemigoArmado();
			demasEntidades.add(enemA);
			Posicion pos = new Posicion(200*i,50);
			enemA.getGrafico().setPosicion(pos.getX(),pos.getY());
		}
		//OBSTACULOS
		for(int i=1; i<=cantObs; i++) {
			Obstaculo obs = new Obstaculo();
			demasEntidades.add(obs);
			Posicion pos = new Posicion(ancho*i/(cantObs+1),200);
			obs.getGrafico().setPosicion(pos.getX(),pos.getY());
		}
		//BARRICADA
		for(int i=1; i<=cantObs; i++) {
			Barricada bar = new Barricada();
			demasEntidades.add(bar);
			//					Coords c = new Coords(ancho*i/(cantObs+1),200);
			//					obs.getCuerpo().setPosicion(c);
			Posicion pos = new Posicion((ancho*i/(cantObs+1)),150);
			bar.getGrafico().setPosicion(pos.getX(),pos.getY());
		}
	}

	public int getNumeroNivel() {
		return numeroNivel;
	}

	public void sumarPuntaje (Entidad e) {
		player.sumarPuntaje(e);
	}

	public int getPuntaje() {
		return player.getPuntaje();
	}

	public Collection<Entidad> getEntidades(){
		return demasEntidades;
	}

	public int getCantidadEntidades() {
		return demasEntidades.size();
	}

	public void agregarEntidad(Entidad e) {
		coleccionAAgregar.add(e);
	}

	public void eliminarEntidad(Entidad e) {
		coleccionAEliminar.add(e);	
	}

}
