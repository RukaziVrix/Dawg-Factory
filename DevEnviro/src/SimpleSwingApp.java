import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class SimpleSwingApp {

	public static void main(String[] args) throws Exception {
		SimpleSwingApp app = new SimpleSwingApp();
		app.start();
	}

	private void start() {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel p = new JPanel();
		p.setLayout(null);

		JButton button = new JButton("Click me!");
		button.setBounds(20, 50, 200, 50);
		p.add(button);

		JLabel label = new JLabel("I'm a label!");
		label.setBackground(Color.red);
		label.setOpaque(true);
		label.setBounds(50, 200, 100, 30);
		p.add(label);

		f.add(p);

		f.setSize(800, 500);
		f.setVisible(true);
	}

}