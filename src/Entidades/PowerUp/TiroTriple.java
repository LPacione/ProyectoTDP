package Entidades.PowerUp;

import Colisionador.CPowerUp;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import TiposDeDatos.Grafico;

public class TiroTriple extends PowerUp{


	protected float velocidad = 1f;
	protected CPowerUp col;

	
	public TiroTriple() {
		super();
		valor=20;
	}
	

	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.tiroTriple);
		
		mostrador = new Mostrador(grafico.getIcon());
	}
	
	public void activar() {
		System.out.println("Se activo el pw");
		p.setTiroTriple();
	}
	
	public void actualizarEntidad() {
	}

	public String getName() {
		return "PowerUp TiroTriple";
	}
	
}
