package Refactoring;

import java.util.Stack;

public class ControladorPantallas implements Runnable{

	private Stack<Pantalla> pantallas;
	
	public ControladorPantallas() {
		pantallas= new Stack<Pantalla>();
	}
	
	public void push(Pantalla p) {
		pantallas.push(p);
	}
	
	public void pop() {
		pantallas.pop();
	}
	
	public void set(Pantalla p) {
		pantallas.pop();
		pantallas.push(p);
	}

	public void run() {
		while (true) {
			pantallas.get(0).run();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
