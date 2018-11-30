package IA;

import Entidades.Entidad;

public class IACongelado extends IA {
	private int duracion;
	
	public IACongelado() {
		duracion=500;
	}
	
	public void mover(Entidad e) {
		if(duracion>0)
			duracion--;
		else
			e.resetearEntidad();
	}

}
