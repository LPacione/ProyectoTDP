package Entidades;

import Colisionador.Colisionador;
import IA.*;
import InterfazGrafica.Mostrador;
import Level.Nivel;
import TiposDeDatos.CuerpoRigido;
import TiposDeDatos.Grafico;


public abstract class Entidad implements Refrescable {
//ObjectStructure-Element
	
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
	
	public void pausarEntidad() {
		ia = new IANula();
	}
	public void resetearEntidad() {}
	
	public void dropearPowerUp() {}
	
}
