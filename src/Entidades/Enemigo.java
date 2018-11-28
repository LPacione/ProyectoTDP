package Entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import Animation.Pictures;
import Colisionador.*;
import IA.*;


public class Enemigo extends Entidad {
//Concrete Element
	
	public static Icon ic1 = new ImageIcon(Pictures.enemigo1);
	private boolean cambieDeIA = false;

	public Enemigo(Icon icon) {
		super(icon);
		ia = new DummyIA();
		valor = 10;
		vida = 100;
		col = new CEnemigo();
	}

	
	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this));
		if(getVida()<=50 && !cambieDeIA) {
			cambieDeIA = true;
			ia = new FollowIA();
		}
	}
	
	public void setVida(int v) {
		vida=v;
	}

	public void aceptar(Colisionador c) {
		c.afectarEnemigo(this);
	}
	
	public void disparar() {}
	

	@Override
	public void colisionasteCon(Entidad another) {
		another.aceptar(col);
		
	}
	
	public String getName() {
		return "Dummy";
	}
	
}
