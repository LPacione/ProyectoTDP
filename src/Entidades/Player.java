package Entidades;

import Colisionador.CJugador;
import Colisionador.Colisionador;
import Datos.IconsManager;
import Entrada.Teclado;
import InterfazGrafica.Mostrador;
import Level.Nivel;
import Refactoring.IAPlayer;
import TiposDeDatos.Grafico;

public class Player extends Entidad {
	//Visitable

	private int puntaje;
	private int danoBala;

	public Player() {
		super();
		puntaje = 0;
		ia = new IAPlayer();
		vida = 100;
		col  = new CJugador();
		danoBala=20;
		
	}
	
	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.player);
		
		mostrador = new Mostrador(grafico.getIcon());
		
		grafico.setPosicion(400, 500);
	}
	
	private void disparar() {
		if(Teclado.getInstancia().espacio()) {
			Nivel n = Nivel.getInstancia();
			Balazo b = new BalazoPlayer(danoBala);
			int xBala =(int) grafico.getPosicion().getX();
			int yBala =(int) grafico.getPosicion().getY();
			b.getGrafico().setPosicion(xBala,yBala);
			n.agregarEntidad(b);
		}
	}

	public void actualizarEntidad() {
		mover();
		disparar();
	}

	public void sumarPuntaje(Entidad e) {
		puntaje+=e.getValor();
		System.out.println(puntaje);
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
	
	public void setTiroTriple() {
	}

	public void setSuperMisil() {
		danoBala=50;
	}
	
	public String getName() {
		return "Player";
	}
}
