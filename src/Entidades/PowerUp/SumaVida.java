package Entidades.PowerUp;

import Colisionador.CPowerUp;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import TiposDeDatos.Grafico;

public class SumaVida extends PowerUp{


	protected float velocidad = 1f;
	protected CPowerUp col;
	
	public SumaVida()  {
		super();
	}
	

	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.sumaVida);
		
		mostrador = new Mostrador(grafico.getIcon());
	}
	
	public void activar() {
		p.setVida(p.getVida()+50);
	}
	
	public void actualizarEntidad() {
		mover();
	}
	

}
