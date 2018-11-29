package Refactoring;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Datos.GameData;
import Datos.IconsManager;
import Level.Nivel;

public class PantallaPerder extends Pantalla {
	
	private int contador;
	private final int contadorMax = 200;
	private JLabel puntaje;
	private JLabel puntuacion;

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
		puntaje= new JLabel("Puntaje");
		puntaje.setBounds(0, 0, 100, 100);
		frame.add(puntaje);
		puntuacion= new JLabel();
		int p= Nivel.getInstancia().getPuntaje();
		String s= Integer.toString(p);
		puntuacion.setText(s);
		puntuacion.setBounds(60, 0, 100, 100);
		frame.add(puntuacion);
	}

	public void refresh() {
		frame.repaint();
		contador++;
		if (contador == contadorMax) {
			cambiarPantalla(new PantallaInicio(cp));
		}
	}


}
