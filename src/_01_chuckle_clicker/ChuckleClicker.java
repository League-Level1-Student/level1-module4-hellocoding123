package _01_chuckle_clicker;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements MouseListener {

	public static void main (String[] args) {
		
		ChuckleClicker clicker = new ChuckleClicker();
		clicker.makeButtons();
		
	}

	private void makeButtons() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "MakeButtonsnsnsnnsnns");
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton joke = new JButton();
		JButton punchline = new JButton();
		panel.add(joke);
		panel.add(punchline);
		frame.add(panel);
		joke.setText("Joke");
		punchline.setText("Punchline");
		frame.pack();
		frame.setVisible(true);
		joke.addMouseListener(this);
		punchline.addMouseListener(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
