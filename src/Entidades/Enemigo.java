package Entidades;

import Colisionador.CEnemigo;
import Colisionador.Colisionador;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import Refactoring.IABuscador;
import Refactoring.IAMareado;
import TiposDeDatos.Grafico;


public class Enemigo extends Entidad {
//Concrete Element
	
	protected float damage;

	private boolean cambieDeIA = false;

	public Enemigo() {
		super();
		ia = new IABuscador();
		valor = 10;
		damage = 50;
		vida = 100;
		col = new CEnemigo(damage);
	}

	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.enemigo);
		
		mostrador = new Mostrador(grafico.getIcon());
	}
	
	protected void mover() {
		ia.mover(this);
		if(getVida()<=50 && !cambieDeIA) {
			cambieDeIA = true;
			ia = new IAMareado();
		}
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
