package Entidades;

import Colisionador.CPowerUp;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import TiposDeDatos.Grafico;

public class DetenerTiempo extends PowerUp{

	protected float velocidad= 1f;
	protected CPowerUp col;
	
	protected DetenerTiempo() {
		super();
		valor=-10;
	}
	
	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.detenerTiempo);
		
		mostrador = new Mostrador(grafico.getIcon());
	}

	public void activar() {
		// TODO Auto-generated method stub
		
	}
	
	public void actualizarEntidad() {}

}

