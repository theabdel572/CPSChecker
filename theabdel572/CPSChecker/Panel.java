package theabdel572.CPSChecker;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Panel extends JPanel{
	private byte mode = 0;
	private Font font = new Font("CPSFont", 1, 16);
	private JButton click = new JButton("       CLICK HERE!!!       ");
	private JButton reset = new JButton("RESET");
	private JButton oneSecondMode = new JButton("Clicks in 1s");
	private JButton normalMode = new JButton("Normal Mode");
	private JButton twitter = new JButton("Twitter");
	private JButton discord = new JButton("Discord");
	private String i = "0";
	private int CPS = Integer.parseInt(i);
	public void paintComponent(Graphics g) {
		g.drawString("Made by theabdel572.", 5, 250);
		g.fillRect(70, 100, 150, 25);
	}
	public Panel() {
		add(click);
		add(reset);
		add(oneSecondMode);
		add(normalMode);
		add(twitter);
		add(discord);
		Listener onClick = new Listener();
		click.addActionListener(onClick);
		reset.addActionListener(onClick);
		oneSecondMode.addActionListener(onClick);
		normalMode.addActionListener(onClick);
		twitter.addActionListener(onClick);
		discord.addActionListener(onClick);
	}
	private class Listener implements ActionListener{
		Timer timerSecond = new Timer(1000, this);
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(click)) {
				if(mode == 0) {
					Graphics g = getGraphics();
					CPS++;
					g.fillRect(70, 100, 150, 25);
					g.setColor(Color.white);
					String x = String.valueOf(CPS);
					g.setFont(font);
					if(CPS <= 9) {
						g.drawString(x, 137, 118);
					}else if(CPS <= 99) {
						g.drawString(x, 133, 118);
					}else if(CPS <= 999) {
						g.drawString(x, 130, 118);
					}else if(CPS <= 9999) {
						g.drawString(x, 127, 118);
					}else{
						g.drawString(x, 120, 118);
					}
				}else {
					if(timerSecond.isRunning()) {
						Graphics g = getGraphics();
						CPS++;
						g.fillRect(70, 100, 150, 25);
						g.setColor(Color.white);
						String x = String.valueOf(CPS);
						g.setFont(font);
						g.drawString(x, 137, 118);
					}else {
						if(CPS != 0) {
							Graphics g = getGraphics();
							String x = String.valueOf(CPS);
							String check = "You got "+x+" CPS!";
							g.fillRect(87, 70, 120, 25);
							g.setFont(font);
							g.setColor(Color.white);
							g.drawString(check, 90, 90);
						}
						CPS = 0;
						timerSecond.setRepeats(false);
						timerSecond.start();
					}
				}
			}else if(e.getSource().equals(reset)){
				Graphics g = getGraphics();
				CPS = 0;
				g.fillRect(70, 100, 150, 25);
				g.setColor(Color.white);
				String x = String.valueOf(CPS);
				g.setFont(font);
				g.drawString(x, 137, 118);
			}else if(e.getSource().equals(oneSecondMode) && mode == 0) {
				mode = 1;
				CPS = 0;
				Graphics g = getGraphics();
				g.fillRect(70, 100, 150, 25);
				g.setColor(Color.white);
				String x = String.valueOf(CPS);
				g.setFont(font);
				g.drawString(x, 137, 118);
			}else if(e.getSource().equals(normalMode) && mode == 1) {
				mode = 0;
				CPS = 0;
				Graphics g = getGraphics();
				g.fillRect(70, 100, 150, 25);
				g.setColor(Color.white);
				String x = String.valueOf(CPS);
				g.setFont(font);
				g.drawString(x, 137, 118);
				g.setColor(getBackground());
				g.fillRect(87, 70, 120, 25);
			}else if(e.getSource().equals(twitter)) {
				try {
					Desktop.getDesktop().browse(new URI("https://twitter.com/T572yt"));
				}catch(Exception exc){
					JOptionPane.showMessageDialog(null, "No se ha podido acceder a la pagina web.");
				}
			}else if(e.getSource().equals(discord)) {
				try {
					Desktop.getDesktop().browse(new URI("https://discord.gg/q3srmG3"));
				}catch(Exception exc){
					JOptionPane.showMessageDialog(null, "No se ha podido acceder a la pagina web.");
				}
			}
		}
	}
}
