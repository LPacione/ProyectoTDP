package Main;

import InterfazGrafica.Pantalla;
import Level.LevelDirector;

public class Launcher {

	public static void main(String[] x) {
		Pantalla.getInstance();
		LevelDirector director = LevelDirector.instancia();
		director.inicializarNivel();	
		director.iniciarMotor();
	}
}