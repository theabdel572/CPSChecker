package theabdel572.CPSChecker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel{
	Font font = new Font("CPSFont", 1, 16);
	JButton click = new JButton("       CLICK HERE!!!       ");
	String i = "0";
	int CPS = Integer.parseInt(i);
	public void paintComponent(Graphics g) {
		g.setFont(font);
		g.drawRect(70, 100, 150, 25);
		g.setColor(Color.white);
		g.drawString(i, 75, 118);
	}
	public Panel() {
		add(click);
		Listener onClick = new Listener();
		click.addActionListener(onClick);
	}
	private class Listener implements ActionListener{
		
		
		public void actionPerformed(ActionEvent e) {
			Graphics g = getGraphics();
			CPS++;
			g.fillRect(70, 100, 150, 25);
			String x = String.valueOf(CPS);
			g.setColor(Color.white);
			g.setFont(font);
			g.drawString(x, 75, 118);
		}
	}
}
