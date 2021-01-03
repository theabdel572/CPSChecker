package theabdel572.CPSChecker;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel{
	JButton click = new JButton("       CLICK HERE!!!       ");
	String i = "0";
	int CPS = Integer.parseInt(i);
	String x = String.valueOf(CPS);
	public void paintComponent(Graphics g) {
		g.drawString(i, 135, 135);
	}
	public Panel() {
		add(click);
		Listener onClick = new Listener();
		click.addActionListener(onClick);
	}
	private class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			CPS++;
			System.out.println(CPS);
		}
	}
}
