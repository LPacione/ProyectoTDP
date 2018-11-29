package Entidades;

import java.util.Random;

import Colisionador.Colisionador;
import InterfazGrafica.Mostrador;
import Level.Nivel;
import Refactoring.IA;
import TiposDeDatos.CuerpoRigido;
import TiposDeDatos.Grafico;


public abstract class Entidad implements Refrescable {
//ObjectStructure-Element
	
	
	/*
	 * Hacer el patron State en entidad para generalizar la IA
	 * meter el onRefresh en entidad
	 * generalizar mas todo
	 * los puntajes y demas cosas buscar de meterlas en entidad
	 * que cada entidad cambie de IA sin que nadie se entere, solo ellos.
	 */
	
	public CuerpoRigido cuerpo;
	protected Mostrador mostrador;
	protected IA ia;
	protected int valor;
	protected float vida;
	protected Colisionador col;
	protected Grafico grafico;
	
	protected Entidad() {
		iniciarGraficamente();
	}
	
	protected abstract void iniciarGraficamente();
	

	public Mostrador getMostrable() {
		return mostrador;
	}
	public CuerpoRigido getCuerpo(){
		return cuerpo;
	}
	public int getValor() {
		return valor;
	}
	public float getVida() {
		return vida;
	}
	public void setVida(float f) {
		vida=f;
	}
	
	public void eliminar() {
		Nivel.getInstancia().eliminarEntidad(this);
	}
	
	public void refresh() {
		int w,h,x,y;
		w = mostrador.getWidth();
		h = mostrador.getHeight();
		x = (int) grafico.getPosicion().getX();
		y = (int) grafico.getPosicion().getY();
		mostrador.setBounds(x,y,w,h);
		
		if (vida<=0 || grafico.getPosicion().estaFuera()) {
			Nivel.getInstancia().eliminarEntidad(this);
		}
		
		actualizarEntidad();
	}
	
	protected abstract void actualizarEntidad();

	public abstract void aceptar(Colisionador c);

	public abstract void colisionasteCon(Entidad another);
	
	public abstract String getName();
	
	protected void mover() {
		ia.mover(this);
	}
	
	public Grafico getGrafico() {
		return grafico;
	}
	
	public boolean colisiona(Entidad e) {
		return e.getGrafico().colisiona(this.getGrafico());
	}
	
	public void colisionar(Entidad e) {
		e.colisionasteCon(this);
	}
	
	protected void dropearPowerUp() {}
	
}
