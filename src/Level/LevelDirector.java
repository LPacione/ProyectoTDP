package Level;

import InterfazGrafica.Pantalla;
import InterfazGrafica.PantallaInicio;
import InterfazGrafica.PantallaJuego;
import Entidades.*;

public class LevelDirector implements Runnable{
	
	protected AbsNivel nivel;
	
	private static LevelDirector instan;
	public static LevelDirector instancia(){
		if(instan==null){
			instan = new LevelDirector(1);
		}
		return instan;
	}
	
	public AbsNivel currentLevel(){
		return nivel;
	}
	
	private LevelDirector(int i) {
		nivel= new CrearNivel(i);
	}
	
	public void run() {
		long time = System.nanoTime();
		long time2 = System.nanoTime();
		long tiempoDeFrame = 1_000_000_000L/60;
		while(true){
			time = System.nanoTime(); 
			nivel.refrescarTodo();
			time2 = System.nanoTime();
			esperar(tiempoDeFrame-(time2-time));
//			PantallaInicio.getInstance().refresh();
			PantallaJuego.getInstance().refresh();
			controlarNivel();
		}	
	}
	
	public void inicializarNivel(){
		nivel.crear();
		nivel.iniciar();
		nivel.agregarTodo();
	}
	
	private void controlarNivel() {
		//System.out.println("Cantidad de entidades: "+nivel.getCantidadEntidades());

		if(nivel.getCantidadEntidades()==0) {
			cambiarNivel();
		}
	}
	
	public void cambiarNivel() {
		nivel.eliminaTodosLosEnemies();
		nivel= new CrearNivel(nivel.getNumeroNivel()+1);			
		inicializarNivel();
}
	
	
	private void esperar(long l) {
		try{
			if(l>0)
			Thread.sleep(l/1000000);
		}
		catch (Exception e) {
			System.out.println("Error en el sleep");
		}
		
	}
	
}
