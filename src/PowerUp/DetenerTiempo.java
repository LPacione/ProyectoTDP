package PowerUp;

import Datos.IconsManager;
import Entidades.Entidad;
import InterfazGrafica.Mostrador;
import Level.Nivel;
import TiposDeDatos.Grafico;

public class DetenerTiempo extends PowerUp{

	protected float velocidad= 1f;
	protected int vida;
	
	public DetenerTiempo() {
		super();
		valor=10;
	}
	
	protected void iniciarGraficamente() {
		grafico = new Grafico(IconsManager.detenerTiempo);
		mostrador = new Mostrador(grafico.getIcon());
	}

	public void activar() {
		Nivel n = Nivel.getInstancia();
		for(Entidad e : n.getEntidades()) {
			if(e!=p && e.getName()!="Bala enemigo" && e.getName()!="Bala player" && e.getName()!="Bala bomba") {
				e.pausarEntidad();
			}
		}
	}
	
	public String getName() {
		return "PowerUp DetenerTiempo";
	}

}

