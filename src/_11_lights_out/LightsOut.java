package _11_lights_out;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * Lights Out is a puzzle game with a grid of lights that are either on (light
 * gray) or off (white). Pressing any light will toggle it and its adjacent
 * lights. The goal of the game is to switch all the lights off.
 * 
 * Follow the instructions below to create your own version of Lights Out
 * 
 * 
 */
public class LightsOut implements MouseListener {

	JPanel gamePanel = new JPanel();
	JFrame frame = new JFrame();

	public LightsOut() {

		/** PART 1. CREATE YOUR LIGHT BOARD **/
		//1. Make your gamePanel a 5x5 grid with setLayout(new GridLayout(5, 5));
			gamePanel.setLayout(new GridLayout(5, 5));
		
			//2. Add 25 JLabels to your gamePanel (these are your lights)
			/*
			JLabel light1 = new JLabel();
			JLabel light2 = new JLabel();
			JLabel light3 = new JLabel();
			JLabel light4 = new JLabel();
			JLabel light5 = new JLabel();
			JLabel light6 = new JLabel();
			JLabel light7 = new JLabel();
			JLabel light8 = new JLabel();
			JLabel light9 = new JLabel();
			JLabel light10 = new JLabel();
			JLabel light11 = new JLabel();
			JLabel light12 = new JLabel();
			JLabel light13 = new JLabel();
			JLabel light14 = new JLabel();
			JLabel light15 = new JLabel();
			JLabel light16 = new JLabel();
			JLabel light17 = new JLabel();
			JLabel light18 = new JLabel();
			JLabel light19 = new JLabel();
			JLabel light20 = new JLabel();
			JLabel light21 = new JLabel();
			JLabel light22 = new JLabel();
			JLabel light23 = new JLabel();
			JLabel light24 = new JLabel();
			JLabel light25 = new JLabel();
			*/
			
			for(int i=0; i<25; i++) {
				
				JLabel light = new JLabel();
				gamePanel.add(light);
			//3. Use setText() to add a position number to each light (0-24).
				light.setText(String.valueOf(i + 1));
			
			//4. Set the background of each light to LIGHT_GRAY
				light.setBackground(Color.LIGHT_GRAY);
			// - you will also have to set the background to opaque.
			// - Use light.setOpaque(true);
				light.setOpaque(true);

			//5. Add a mouseListener to each light
				light.addMouseListener(this);
			}
		
		//6. Add your panel to a frame
			frame.add(gamePanel);
		//7. Set the size of the frame
			frame.setSize(400,400);
			frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		/** PART 2: TOGGLE NEIGHBORING LIGHTS **/
		// 1. Get the light that was clicked on `(JLabel) e.getSource`
		JLabel light = (JLabel) e.getSource();
		// 2. Get the number (position) of the light
		int pos = Integer.parseInt(light.getText())-1;
		// 3. Now use the makeMove method to code which lights turn on and off.
		makeMove(pos);
		// 4.Check if the player has won (e.g. all the lights are off)
		// ---- HINT: use `getLightAtPosition` to get the light at each position
		// ---------- use 'getBackground' to get the light color
		boolean won = true;
		for(int i = 0; i <25; i++) {
			
			JLabel light1 = getLightAtPosition(i);
			Color color = light1.getBackground();
			if(color == Color.LIGHT_GRAY) {
				won = false;
				System.out.println("gray");
				break;
			}
		}
		if(won) {
			JOptionPane.showMessageDialog(null, "You won!");
		}
		/** PART 3: RANDOMIZE YOUR BOARD **/
		// Now that your game works can you make the game start with some lights on?
		
	}

	void makeMove(int pos) {
		toggle((JLabel) gamePanel.getComponent(pos));
		if (pos >= 5) {
			toggle((JLabel) gamePanel.getComponent(pos - 5));
		}
		if ((pos + 1) % 5 != 0) {
			toggle((JLabel) gamePanel.getComponent(pos + 1));
		}
		if (pos % 5 != 0) {
			toggle((JLabel) gamePanel.getComponent(pos - 1));
		}
		if (pos + 5 <= 24) {
			toggle((JLabel) gamePanel.getComponent(pos + 5));
		}
	}

	JLabel getLightAtPosition(int lightPosition) {
		return (JLabel) gamePanel.getComponent(lightPosition);
	}

	void toggle(JLabel label) {
		if (label.getBackground() == Color.WHITE) {
			label.setBackground(Color.LIGHT_GRAY);

		} else {
			label.setBackground(Color.WHITE);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}
}
