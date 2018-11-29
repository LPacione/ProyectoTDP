package Main;


import Refactoring.ControladorPantallas;
import Refactoring.PantallaInicio;

public class Launcher {

	public static void main(String[] x) {
		ControladorPantallas cp = new ControladorPantallas();
		cp.push(new PantallaInicio(cp));
	//	director.inicializarNivel();
		(new Thread(cp)).start();
	}
}
