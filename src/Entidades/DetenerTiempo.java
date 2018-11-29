package Entidades;

import Colisionador.CPowerUp;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import Level.Nivel;
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
		Nivel n = Nivel.getInstancia();
		for(Entidad e : n.getEntidades()) {
			if(e!=p) {
				e.pausarEntidad();
				//falta el volverlos a la normalidad
			}
		}
	}
	
	public void actualizarEntidad() {
		if(contador == tiempoMax) {
			Nivel n = Nivel.getInstancia();
			for(Entidad e : n.getEntidades()) {
				if(e!=p) {
					e.resetearEntidad();
				}
			}
		}
	}

}

