package Entidades;


import javax.swing.Icon;

import Colisionador.*;
import IA.IABalaEnemigo;
import IA.IABalaPlayer;
//import InterfazGrafica.Mostrador;
//import TiposDeDatos.Coords;
import TiposDeDatos.CuerpoRigido;

public class BalazoEnemigo extends Balazo{
//Concrete Element - Visitable

	protected float velocidad = 5f;
	protected int dano; 
	protected CDisparoEnemigo col;


	public BalazoEnemigo(Icon icon) {
		super(icon);
		ia = new IABalaEnemigo();
		dano= 5;
		vida = 100;
		col = new CDisparoEnemigo(dano);
	}

	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this).multK(velocidad));
		vida--;
	}

	public int getDano() {
		return dano;
	}
	
	public void setDano(int i) {
		dano=i;
	}
		
	public void aceptar(Colisionador c) {
		c.afectarDisparo(this);
	}

	@Override
	public void colisionasteCon(Entidad another) {
		another.aceptar(col);	
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}

}
