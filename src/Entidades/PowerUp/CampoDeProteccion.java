package Entidades.PowerUp;

import Colisionador.CPowerUp;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import TiposDeDatos.Grafico;

public class CampoDeProteccion extends PowerUp{

	protected float velocidad= 1f;
	protected CPowerUp col;
	
	public CampoDeProteccion() {
		super();
		valor=-10;
	}
	
	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.campoDeProteccion);
		
		mostrador = new Mostrador(grafico.getIcon());
	}
	public void activar() {
		System.out.println("Se activo el pw");
		p.setEscudo(true);
	}
	
	public void actualizarEntidad() {}
	
	public String getName() {
		return "PowerUp Escudo";
	}
}
