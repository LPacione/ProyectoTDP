package Entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animation.Pictures;
import Colisionador.CEnemigoKami;
import Colisionador.Colisionador;
import IA.FollowIA;

public class EnemigoKami extends Enemigo{
//Visitable
	
	public static Icon ic2 = new ImageIcon(Pictures.enemigo2);
	private float velocidad = 2f;
	protected int dano;
	int i = 0;
	
	public EnemigoKami(Icon icon) {
		super(icon);
		ia = new FollowIA();
		valor=15;
		dano=50;
		vida = 200;
		col = new CEnemigoKami(dano);
	}

	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this).multK(velocidad));
	}
	
	public int getDano() {
		return dano;
	}
	
	public void aceptar(Colisionador c) {
		c.afectarEnemigoKami(this);
	}
}