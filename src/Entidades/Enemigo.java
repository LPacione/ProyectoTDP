package Entidades;

import Colisionador.CEnemigo;
import Colisionador.Colisionador;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import Refactoring.IAMareado;
import TiposDeDatos.Grafico;


public class Enemigo extends Entidad {
//Concrete Element
	
	private boolean cambieDeIA = false;
	protected float damage;

	public Enemigo() {
		super();
		ia = new IAMareado();
		valor = 10;
		damage = 50;
		vida = 100;
		col = new CEnemigo(damage);
	}

	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.enemigo);
		
		mostrador = new Mostrador(grafico.getIcon());
	}

	public void aceptar(Colisionador c) {
		c.afectarEnemigo(this);
	}


	public void colisionasteCon(Entidad another) {
		another.aceptar(col);
		
	}
	
	public String getName() {
		return "Dummy";
	}

	public void actualizarEntidad() {
		mover();
	}
	
}
