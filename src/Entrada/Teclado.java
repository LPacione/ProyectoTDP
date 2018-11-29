package Entrada;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public  class Teclado implements KeyListener{
	
	private boolean izquierda;
	private boolean derecha;
	private boolean espacio;
	
	private boolean lapso;
	private int contador;
	private final int contadorMax = 15;
	
	private static Teclado instan;
	
	public static Teclado getInstancia(){
		if(instan==null){
			instan = new Teclado();
		}
		return instan;
	}
	
	private Teclado() {
		izquierda = false;
		derecha=false;
		espacio= false;
		
		contador = 0;
		lapso = false;
	}
	
	public boolean izquierda() {
		return izquierda;
	}

	
	public boolean derecha() {
		return derecha;
	}
	
	public boolean espacio() {
		return espacio;
	}

	public void keyPressed(KeyEvent k) {
		if (k.getKeyCode()==KeyEvent.VK_SPACE && lapso) {
			espacio = true;
			lapso = false;
		}
		if (k.getKeyCode()==KeyEvent.VK_D) {
			derecha = true;
		}
		if (k.getKeyCode()==KeyEvent.VK_A) {
			izquierda = true;
		}
		
	}


	public void keyReleased(KeyEvent k) {
		if (k.getKeyCode()==KeyEvent.VK_SPACE) {
			espacio = false;
		}
		if (k.getKeyCode()==KeyEvent.VK_D) {
			derecha = false;
		}
		if (k.getKeyCode()==KeyEvent.VK_A) {
			izquierda = false;
		}
		
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	public void actualizarTeclado() {
		if (lapso) {
			contador = 0;
		}
		contador++;
		if (contador == contadorMax && !lapso) {
			lapso = true;
			contador  = 0;
		}
		espacio = false;
	}

}