package Entidades.PowerUp;

import Colisionador.CPowerUp;
import Datos.IconsManager;
import Entidades.Entidad;
import InterfazGrafica.Mostrador;
import Level.Nivel;
import TiposDeDatos.Grafico;

public class DetenerTiempo extends PowerUpTemporal{

	protected float velocidad= 1f;
	protected CPowerUp col;
	
	public DetenerTiempo() {
		super();
		valor=-10;
	}
	
	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.detenerTiempo);
		
		mostrador = new Mostrador(grafico.getIcon());
	}

	public void activar() {
		System.out.println("Se activo el pw");
		Nivel n = Nivel.getInstancia();
		for(Entidad e : n.getEntidades()) {
			if(e!=p) {
				e.pausarEntidad();
				//falta el volverlos a la normalidad
			}
		}
	}
	
	public void actualizarEntidad() {
	}
	public String getName() {
		return "PowerUp DetenerTiempo";
	}

}

