package Entidades;

import javax.swing.Icon;
import Colisionador.*;
import IA.*;

import Colisionador.Colisionador;

public class CampoDeProteccion extends PowerUp{

	protected float velocidad= 1f;
	protected CCampoDeProteccion col;
	
	protected CampoDeProteccion(Icon icon) {
		super(icon);
		valor=-10;
		ia= new PowerUpIA();
	//	col= new CCampoDeProteccion();
	}

	public void activar() {
		
	}
	
	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this).multK(velocidad));
	}

	public int getDano() {
		return 0;
	}

	public void aceptar(Colisionador c) {
		
	}

	public void colisionasteCon(Entidad another) {
		
	}

	public void disparar() {
		
	}


	
}
