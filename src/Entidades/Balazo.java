package Entidades;

public abstract class Balazo extends Entidad{


	protected float velocidad;
	protected int dano;
	
	
	public Balazo(int dano) {
		super();
		this.dano = dano;
	}

	public abstract int getDano();

}
