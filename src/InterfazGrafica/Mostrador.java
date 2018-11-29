package InterfazGrafica;

import javax.swing.Icon;
import javax.swing.JLabel;

public class Mostrador extends JLabel{
	
	public Mostrador(Icon icon) {
		super(icon);
		setBounds(-900,-900,icon.getIconWidth(),icon.getIconHeight());
	}
		
	public void setBounds(int x, int y, int w, int h){
		super.setBounds(x,y,w,h);
	}
	
}
