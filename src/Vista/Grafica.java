package Vista;

import javax.swing.*;
import java.awt.*;

public class Grafica extends JPanel{
	
	public Grafica() {
		
	}
	
	public Dimension getPreferrdSize() {
        return new Dimension(200, 200);
    }

	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(10, 10, 150, 40);
    }
}
