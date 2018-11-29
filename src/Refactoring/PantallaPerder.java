package Refactoring;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Datos.GameData;
import Datos.IconsManager;

public class PantallaPerder extends Pantalla {
	
	private int contador;
	private final int contadorMax = 200;

	public PantallaPerder(ControladorPantallas cp) {
		super(cp);
		
		contador = 0;
	}
	
	
	public void run() {
		refresh();
	}
	
	public void inicializar() {
		frame = new JFrame(GameData.NombreDelJuego);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(GameData.WindowSize);
		frame.setContentPane(new JLabel(IconsManager.fondoL));
		container = frame.getContentPane();
		container.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}

	public void refresh() {
		frame.repaint();
		contador++;
		if (contador == contadorMax) {
			cambiarPantalla(new PantallaInicio(cp));
		}
	}


}
