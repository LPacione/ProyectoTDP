package PowerUp;

import Datos.IconsManager;
import EstadosJugador.DisparoTriple;
import InterfazGrafica.Mostrador;
import TiposDeDatos.Grafico;

public class TiroTriple extends PowerUp{


	protected float velocidad= 1f;
	protected int vida;

	
	public TiroTriple() {
		super();
		valor=20;
	}
	

	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.tiroTriple);
		
		mostrador = new Mostrador(grafico.getIcon());
	}
	
	public void activar() {
		p.setEstado(new DisparoTriple(p));
	}
	

	public String getName() {
		return "PowerUp TiroTriple";
	}

	
}
