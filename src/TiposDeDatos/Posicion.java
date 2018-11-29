package TiposDeDatos;

public class Posicion {
	private float x;
	private float y;
	
	public Posicion() {
		x=0;
		y=0;
	}
	 public Posicion(float x, float y) {
		 this.x=x;
		 this.y=y;
	 }
	
	public void setPos(float x, float y) {
		this.x=x;
		this.y=y;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public boolean estaFuera() {
		boolean fuera = false;
		if (x>850 || x < -50 || y > 650 || y < -50) {
			fuera = true;
		}
		return fuera;
	}
}
