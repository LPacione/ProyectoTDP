package Level;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import Datos.GameData;
import Entidades.Barricada;
import Entidades.Enemigo;
import Entidades.EnemigoArmado;
import Entidades.EnemigoArmadoEspecial;
import Entidades.EnemigoKami;
import Entidades.EnemigoKami2;
import Entidades.Entidad;
import Entidades.Obstaculo;
import Entidades.Player;
import TiposDeDatos.Posicion;

public class Nivel {

	private int cantEnems;
	private int cantEnemsK;
	private int cantEnemsK2;
	private int cantObs;
	private int cantBarr;
	private int cantEnemsA;
	private int cantEnemsAE;
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

		numeroNivel=j;

		if(j==1) {
			cantEnemsK=2;
			cantEnemsA=2;
			cantEnemsK2=2;
			crearNivel1();
		}
		if(j==2) crearNivel2();
		if(j==3) crearNivel3();
		if(j==4) crearNivel4();
		if(j==5) crearNivel5();

	}

	private void crearNivel1() {

		//ENEMIGOS KAMI
		for(int i=1; i<=cantEnemsK;i++) {
			EnemigoKami enemK = new EnemigoKami();
			demasEntidades.add(enemK);
			Posicion pos = new Posicion(200*i,350);
			enemK.getGrafico().setPosicion(pos.getX(),pos.getY());
		}

		//ENEMIGOS KAMI2
		for(int i=1; i<=cantEnemsK;i++) {
			EnemigoKami2 enemK2 = new EnemigoKami2();
			demasEntidades.add(enemK2);
			Posicion pos = new Posicion(200*i,350);
			enemK2.getGrafico().setPosicion(pos.getX(),pos.getY());
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
			Posicion pos = new Posicion(300*i,200);
			obs.getGrafico().setPosicion(pos.getX(),pos.getY());
		}


	}

	private void crearNivel2() {

		//ENEMIGO
		for(int i=1; i<=cantEnems;i++) {
			Enemigo enem = new Enemigo();
			demasEntidades.add(enem);
			Posicion pos = new Posicion(200*i,350);
			enem.getGrafico().setPosicion(pos.getX(),pos.getY());
		}

		//ENEMIGOS KAMI2
		for(int i=1; i<=cantEnemsK;i++) {
			EnemigoKami2 enemK2 = new EnemigoKami2();
			demasEntidades.add(enemK2);
			Posicion pos = new Posicion(200*i,350);
			enemK2.getGrafico().setPosicion(pos.getX(),pos.getY());
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
			Posicion pos = new Posicion(300*i,200);
			obs.getGrafico().setPosicion(pos.getX(),pos.getY());
		}



	}

	private void crearNivel3() {

		//ENEMIGOS KAMI
		for(int i=1; i<=cantEnemsK;i++) {
			EnemigoKami enemK = new EnemigoKami();
			demasEntidades.add(enemK);
			Posicion pos = new Posicion(200*i,350);
			enemK.getGrafico().setPosicion(pos.getX(),pos.getY());
		}

		//ENEMIGOS KAMI2
		for(int i=1; i<=cantEnemsK;i++) {
			EnemigoKami2 enemK2 = new EnemigoKami2();
			demasEntidades.add(enemK2);
			Posicion pos = new Posicion(200*i,350);
			enemK2.getGrafico().setPosicion(pos.getX(),pos.getY());
		}

		//ENEMIGOS ARMADO ESPECIAL
		for(int i=1; i<=cantEnemsA; i++) {
			EnemigoArmadoEspecial enemA= new EnemigoArmadoEspecial();
			demasEntidades.add(enemA);
			Posicion pos = new Posicion(200*i,50);
			enemA.getGrafico().setPosicion(pos.getX(),pos.getY());
		}

		//OBSTACULOS
		for(int i=1; i<=cantObs; i++) {
			Obstaculo obs = new Obstaculo();
			demasEntidades.add(obs);
			Posicion pos = new Posicion(300*i,200);
			obs.getGrafico().setPosicion(pos.getX(),pos.getY());
		}

	}

	private void crearNivel4() {

		//ENEMIGO
		for(int i=1; i<=cantEnems;i++) {
			Enemigo enem = new Enemigo();
			demasEntidades.add(enem);
			Posicion pos = new Posicion(200*i,350);
			enem.getGrafico().setPosicion(pos.getX(),pos.getY());
		}


		//ENEMIGOS ARMADOS
		for(int i=1; i<=cantEnemsA; i++) {
			EnemigoArmado enemA= new EnemigoArmado();
			demasEntidades.add(enemA);
			Posicion pos = new Posicion(200*i,50);
			enemA.getGrafico().setPosicion(pos.getX(),pos.getY());
		}

		//ENEMIGOS ARMADO ESPECIAL
		for(int i=1; i<=cantEnemsA; i++) {
			EnemigoArmadoEspecial enemA= new EnemigoArmadoEspecial();
			demasEntidades.add(enemA);
			Posicion pos = new Posicion(200*i,50);
			enemA.getGrafico().setPosicion(pos.getX(),pos.getY());
		}

		//OBSTACULOS
		for(int i=1; i<=cantObs; i++) {
			Obstaculo obs = new Obstaculo();
			demasEntidades.add(obs);
			Posicion pos = new Posicion(300*i,200);
			obs.getGrafico().setPosicion(pos.getX(),pos.getY());
		}

	}

	private void crearNivel5() {

		//ENEMIGO
		for(int i=1; i<=cantEnems;i++) {
			Enemigo enem = new Enemigo();
			demasEntidades.add(enem);
			Posicion pos = new Posicion(200*i,350);
			enem.getGrafico().setPosicion(pos.getX(),pos.getY());
		}


		//ENEMIGOS ARMADOS
		for(int i=1; i<=cantEnemsA; i++) {
			EnemigoArmado enemA= new EnemigoArmado();
			demasEntidades.add(enemA);
			Posicion pos = new Posicion(200*i,50);
			enemA.getGrafico().setPosicion(pos.getX(),pos.getY());
		}

		//ENEMIGOS ARMADO ESPECIAL
		for(int i=1; i<=cantEnemsA; i++) {
			EnemigoArmadoEspecial enemA= new EnemigoArmadoEspecial();
			demasEntidades.add(enemA);
			Posicion pos = new Posicion(200*i,50);
			enemA.getGrafico().setPosicion(pos.getX(),pos.getY());
		}

		//ENEMIGOS KAMI
		for(int i=1; i<=cantEnemsK;i++) {
			EnemigoKami enemK = new EnemigoKami();
			demasEntidades.add(enemK);
			Posicion pos = new Posicion(200*i,350);
			enemK.getGrafico().setPosicion(pos.getX(),pos.getY());
		}

		//ENEMIGOS KAMI2
		for(int i=1; i<=cantEnemsK;i++) {
			EnemigoKami2 enemK2 = new EnemigoKami2();
			demasEntidades.add(enemK2);
			Posicion pos = new Posicion(200*i,350);
			enemK2.getGrafico().setPosicion(pos.getX(),pos.getY());
		}

		//OBSTACULOS
		for(int i=1; i<=cantObs; i++) {
			Obstaculo obs = new Obstaculo();
			demasEntidades.add(obs);
			Posicion pos = new Posicion(300*i,200);
			obs.getGrafico().setPosicion(pos.getX(),pos.getY());
		}	
	
	
		//BARRICADA
		for(int i=1; i<=cantObs; i++) {
			Barricada bar = new Barricada();
			demasEntidades.add(bar);
			Posicion pos = new Posicion(250*i,150);
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
