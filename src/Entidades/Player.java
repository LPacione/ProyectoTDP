package Entidades;

import Colisionador.CJugador;
import Colisionador.Colisionador;
import Datos.IconsManager;
import Entrada.Teclado;
import EstadosJugador.EstadoComun;
import EstadosJugador.State;
import IA.IAPlayer;
import InterfazGrafica.Mostrador;
import Level.Nivel;
import TiposDeDatos.Grafico;

public class Player extends Entidad {
	//Visitable
	private int puntaje;
	private int danoBala;
	private State state;

	public Player() {
		super();
		puntaje = 0;
		ia = new IAPlayer();
		vida = 100;
		col  = new CJugador();
		danoBala=30;
		state = new EstadoComun(this);
	}
	
	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.player);
		
		mostrador = new Mostrador(grafico.getIcon());
		
		grafico.setPosicion(400, 500);
	}

	public void actualizarEntidad() {
		mover();
		state.disparar();
	}

	public void sumarPuntaje(Entidad e) {
		puntaje+=e.getValor();
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void aceptar(Colisionador c) {
		c.afectarJugador(this);
	}

	public void colisionasteCon(Entidad another) {
		another.aceptar(col);		
	}
	
	public void setEstado(State s) {
		state = s;
	}
	public State getEstado() {
		return state;
	}
	
	public String getName() {
		return "Player";
	}
	
	
	public void disparar() {
		if(Teclado.getInstancia().espacio()) {
			Nivel n = Nivel.getInstancia();
			Balazo b = new BalazoPlayer(danoBala);
			int xBala =(int) grafico.getPosicion().getX();
			int yBala =(int) grafico.getPosicion().getY();
			b.getGrafico().setPosicion(xBala,yBala);
			n.agregarEntidad(b);
		}
	}
	
	public void crearDisparoDoble() {
		if(Teclado.getInstancia().espacio()) {
			Nivel n = Nivel.getInstancia();
			Balazo b1 = new BalazoPlayer(danoBala);
			Balazo b2 = new BalazoPlayer(danoBala);
			int xBala =(int) grafico.getPosicion().getX();
			int yBala =(int) grafico.getPosicion().getY();
			b1.getGrafico().setPosicion(xBala,yBala);
			b2.getGrafico().setPosicion(xBala+10,yBala);
			n.agregarEntidad(b1);
			n.agregarEntidad(b2);
		}
	}
	public void crearDisparoTriple() {
		if(Teclado.getInstancia().espacio()) {
			Nivel n = Nivel.getInstancia();
			Balazo b1 = new BalazoPlayer(danoBala);
			Balazo b2 = new BalazoPlayer(danoBala);
			Balazo b3 = new BalazoPlayer(danoBala);
			int xBala =(int) grafico.getPosicion().getX();
			int yBala =(int) grafico.getPosicion().getY();
			b1.getGrafico().setPosicion(xBala,yBala);
			b2.getGrafico().setPosicion(xBala+10,yBala);
			b3.getGrafico().setPosicion(xBala+20,yBala);
			n.agregarEntidad(b1);
			n.agregarEntidad(b2);
			n.agregarEntidad(b3);
		}
	}
	
	public void disparoSuperMisil() {
		if(Teclado.getInstancia().espacio()) {
			Nivel n = Nivel.getInstancia();
			Bomba b = new Bomba(danoBala*100);
			int xBala =(int) grafico.getPosicion().getX();
			int yBala =(int) grafico.getPosicion().getY();
			b.getGrafico().setPosicion(xBala,yBala);
			n.agregarEntidad(b);
		}
	}
}
