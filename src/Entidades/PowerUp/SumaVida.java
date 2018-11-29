package Entidades.PowerUp;

import Colisionador.CPowerUp;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import Level.Nivel;
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
		System.out.println("Se activo el pw");
		Nivel.getInstancia().getPlayer().setVida(Nivel.getInstancia().getPlayer().getVida()+50);	
	}
	
	public void actualizarEntidad() {
		mover();
	}
	
	public String getName() {
		return "PowerUp SumaVida";
	}

}
