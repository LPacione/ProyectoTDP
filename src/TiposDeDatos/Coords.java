package TiposDeDatos;

public class Coords {

	public static final Coords ORIGEN = new Coords(0,0);

	public static final Coords izquierda = new Coords(-1,0);
	public static final Coords derecha = new Coords(1,0);
	public static final Coords abajo = new Coords(0,1);
	public static final Coords arriba = new Coords(0,-1);
	
	private final float x;
	private final float y;

	public Coords(float x1, float y1) {
		x=x1;
		y=y1;
	}

	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}

	public Coords sumar(Coords v) {
		return new Coords (x+v.getX(), y+v.getY());
	}
	
	public Coords multK(float k) {
		return new Coords(x*k,y*k);
	}
	
	public Coords aumentarX(int i) {
		return new Coords(x+i,y);
	}
	
	public Coords aumentarY(int i) {
		return new Coords(x,y+i);
	}
	
	public boolean aLaIzquierda(Coords otra) {
		return otra.x < x;
	}
	public boolean abajo(Coords otra) {
		return otra.y > y;
	}

	public float sqrdistancia(Coords otra) {
		return (otra.x-x)*(otra.x-x)+(otra.y-y)*(otra.y-y);
	}
	
	public boolean estaFuera() {
		boolean fuera = false;
		if (x>850 || x < -50 || y > 650 || y < -50) {
			fuera = true;
		}
		return fuera;
	}
	
}
