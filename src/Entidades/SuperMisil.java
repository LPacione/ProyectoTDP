package Entidades;

import Colisionador.CPowerUp;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import TiposDeDatos.Grafico;

public class SuperMisil extends PowerUp{

	protected float velocidad = 1f;
	protected CPowerUp col;
	
	protected SuperMisil() {
		super();
		valor=-20;
	}

	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.superMisil);
		
		mostrador = new Mostrador(grafico.getIcon());
	}


	public void activar() {
		p.setSuperMisil();
	}

	protected void actualizarEntidad() {}

}
