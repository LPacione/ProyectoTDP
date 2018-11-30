package Entidades;

import Colisionador.CDisparoPlayer;
import Colisionador.Colisionador;
import Datos.IconsManager;
import IA.IADisparoPlayer;
import InterfazGrafica.Mostrador;
import TiposDeDatos.Grafico;

public class Bomba extends Balazo{

	
	protected float velocidad = 5f;
	protected CDisparoPlayer col;

	
	public Bomba(int dano) {
		super(dano);
		ia = new IADisparoPlayer();
		vida = 200;
		col = new CDisparoPlayer(dano);
	}
	
	protected void iniciarGraficamente() {
		grafico = new Grafico(IconsManager.bomba);
		mostrador = new Mostrador(grafico.getIcon());
	}
	public int getDano() {
		return dano;
	}
		
	public void aceptar(Colisionador c) {
		c.afectarDisparoPlayer(this);
	}

	public void colisionasteCon(Entidad another) {
		another.aceptar(col);	
	}
	
	public String getName() {
		return "Bala bomba";
	}

	public void actualizarEntidad() {
		mover();
	}


}
