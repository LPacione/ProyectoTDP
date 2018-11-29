package TiposDeDatos;

import javax.swing.Icon;


public class Grafico {
	
	private float alto;
	private float ancho;
	private Hitbox hitbox;
	private Posicion posicion;
	private Icon icon;
	
	public Grafico(Icon icon) {
		
		posicion = new Posicion();
		this.icon = icon;
		alto = icon.getIconHeight();
		ancho = icon.getIconWidth();
		
		float xMax = posicion.getX()+ancho;
		float xMin = posicion.getX();
		float yMax = posicion.getY()+alto;
		float yMin = posicion.getY();
		
		hitbox = new Hitbox(xMax,xMin,yMax,yMin);
	}
	
	public Icon getIcon() {
		return icon;
	}
	
	public float getAlto() {
		return alto;
	}
	
	public float getAncho() {
		return ancho;
	}
	
	public boolean colisiona(Grafico g) {
		actualizarHitbox();
		g.actualizarHitbox();
		return hitbox.colisiona(g.getHitbox());
	}
	
	private void actualizarHitbox() {
		hitbox.actualizar(posicion.getX(),posicion.getY(),alto,ancho);
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	public void setPosicion(float x,float y) {
		posicion.setPos(x, y);
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}
}
