package Entidades;

import TiposDeDatos.*;
import javax.swing.*;

import Colisionador.Colisionador;

import IA.IA;
import InterfazGrafica.Mostrador;
import InterfazGrafica.PantallaJuego;

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
	
	protected Entidad(Icon icon) {
		cuerpo = new CuerpoRigido(icon.getIconWidth(),icon.getIconHeight());
		mostrador = new Mostrador(icon);
	}
	
	public abstract void onRefresh();

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
		PantallaJuego.getInstance().removeMostrable(this.getMostrable());
	}
	
	public void refresh() {
		int w,h,x,y;
		w = mostrador.getWidth();
		h = mostrador.getHeight();
		x = (int)cuerpo.getPosicion().getX();
		y = (int)cuerpo.getPosicion().getY();
		mostrador.setBounds(x,y,w,h);
		onRefresh();
	}

	public abstract void aceptar(Colisionador c);

	public abstract void colisionasteCon(Entidad another);
	
	public abstract void disparar();
	
	public abstract String getName();
	
}
