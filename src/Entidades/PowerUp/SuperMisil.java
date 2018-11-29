package Entidades.PowerUp;

import Colisionador.CPowerUp;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import TiposDeDatos.Grafico;

public class SuperMisil extends PowerUpTemporal{

	protected float velocidad = 1f;
	protected CPowerUp col;
	
	public SuperMisil() {
		super();
		valor=-20;
	}

	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.superMisil);
		
		mostrador = new Mostrador(grafico.getIcon());
	}


	public void activar() {
		System.out.println("Se activo el pw");
		p.setSuperMisil();
	}

	protected void actualizarEntidad() {}
	
	public String getName() {
		return "PowerUp SuperMisil";
	}

}
