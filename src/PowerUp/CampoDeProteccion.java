package PowerUp;

import Datos.IconsManager;
import EstadosJugador.Escudo;
import InterfazGrafica.Mostrador;
import TiposDeDatos.Grafico;

public class CampoDeProteccion extends PowerUp{

	protected float velocidad= 1f;
	protected int vida;
	
	public CampoDeProteccion() {
		super();
		valor=-10;
	}
	
	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.campoDeProteccion);
		
		mostrador = new Mostrador(grafico.getIcon());
	}
	public void activar() {
		p.setEstado(new Escudo(p));
	}
	
	public void actualizarEntidad() {}
	
	public String getName() {
		return "PowerUp Escudo";
	}
}
