package Entidades;

import Colisionador.CPowerUp;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import TiposDeDatos.CuerpoRigido;
import TiposDeDatos.Grafico;

public class TiroTriple extends PowerUp{


	protected float velocidad = 1f;
	protected CPowerUp col;

	
	protected TiroTriple() {
		super();
		valor=20;
	}
	

	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.tiroTriple);
		
		mostrador = new Mostrador(grafico.getIcon());
	}
	
	public void activar() {
		// TODO Auto-generated method stub
		
	}
	
	public void actualizarEntidad() {
	}

}
