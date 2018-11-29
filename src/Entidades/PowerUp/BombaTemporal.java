package Entidades.PowerUp;

import Colisionador.CPowerUp;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import TiposDeDatos.Grafico;

public class BombaTemporal extends PowerUp{

	protected float velocidad= 1f;
	protected CPowerUp col;
	
	public BombaTemporal() {
		super();
		valor=-10;
	}
	
	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.bombaTemporal);
		
		mostrador = new Mostrador(grafico.getIcon());
	}

	public void activar() {
		// TODO Auto-generated method stub
		
	}

	public void actualizarEntidad() {}

}
