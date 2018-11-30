package PowerUp;

import Datos.IconsManager;
import EstadosJugador.DisparoDoble;
import InterfazGrafica.Mostrador;
import TiposDeDatos.Grafico;

public class TiroDoble extends PowerUp{

	protected float velocidad= 1f;
	protected int vida;
	
	public TiroDoble() {
		super();
		valor=10;
	}
	
	protected void iniciarGraficamente() {
		grafico = new Grafico(IconsManager.bombaTemporal);
		mostrador = new Mostrador(grafico.getIcon());
	}

	public void activar() {
		p.setEstado(new DisparoDoble(p));
	}


	public String getName() {
		return "PowerUp TiroDoble";
	}
}
