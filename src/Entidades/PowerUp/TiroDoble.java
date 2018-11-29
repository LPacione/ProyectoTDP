package Entidades.PowerUp;

import Colisionador.CPowerUp;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import TiposDeDatos.Grafico;

public class TiroDoble extends PowerUp{

	protected float velocidad= 1f;
	protected CPowerUp col;
	
	public TiroDoble() {
		super();
		valor=-10;
	}
	
	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.bombaTemporal);
		
		mostrador = new Mostrador(grafico.getIcon());
	}

	public void activar() {
		System.out.println("Se activo el pw");
		p.setTiroDoble();
	}

	public void actualizarEntidad() {}

	public String getName() {
		return "PowerUp TiroDoble";
	}
}
