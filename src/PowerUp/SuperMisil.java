package PowerUp;

import Datos.IconsManager;
import EstadosJugador.EstadoSuperMisil;
import InterfazGrafica.Mostrador;
import TiposDeDatos.Grafico;

public class SuperMisil extends PowerUp{

	protected float velocidad= 1f;
	protected int vida;
	
	public SuperMisil() {
		super();
		valor=20;
	}

	protected void iniciarGraficamente() {
		grafico = new Grafico(IconsManager.superMisil);
		mostrador = new Mostrador(grafico.getIcon());
	}


	public void activar() {
		p.setEstado(new EstadoSuperMisil(p));
	}
	public String getName() {
		return "PowerUp SuperMisil";
	}

}
