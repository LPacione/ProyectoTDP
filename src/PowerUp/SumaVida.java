package PowerUp;

import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import Level.Nivel;
import TiposDeDatos.Grafico;

public class SumaVida extends PowerUp{


	protected float velocidad= 1f;
	protected int vida;

	public SumaVida()  {
		super();
	}


	protected void iniciarGraficamente() {
		grafico = new Grafico(IconsManager.sumaVida);	
		mostrador = new Mostrador(grafico.getIcon());
	}

	public void activar() {
		Nivel.getInstancia().getPlayer().setVida(Nivel.getInstancia().getPlayer().getVida()+50);	
	}


	public String getName() {
		return "PowerUp SumaVida";
	}

}
