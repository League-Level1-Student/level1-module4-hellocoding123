package _09_whack_a_mole;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements MouseListener {
	
	JFrame frame;
	JPanel panel;
	JButton mole;
	int score = 0;
	int misses;
	Date date = new Date();
	Random r = new Random();
	
	public void drawButtons(int random) {
		
		panel = new JPanel();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int i=0; i < 24; i++) {
			
			JButton button;
			
			
			if(i == random) {
				 mole = new JButton("mole!");
				 mole.addMouseListener(this);
				 panel.add(mole);
			}
			else {
				 button = new JButton();
				 button.addMouseListener(this);
				 panel.add(button);
			}
			
			frame.add(panel);
		}
		
		frame.pack();
		frame.setSize(275, 300);
		frame.setVisible(true);
	}
	
	 static void speak(String words) {
	        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
	            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
	                    + words + "');\"";
	            try {
	                Runtime.getRuntime().exec( cmd ).waitFor();
	            } catch( Exception e ) {
	                e.printStackTrace();
	            }
	        } else {
	            try {
	                Runtime.getRuntime().exec( "say " + words ).waitFor();
	            } catch( Exception e ) {
	                e.printStackTrace();
	            }
	        }
	    }
	 
	 private void endGame(Date timeAtStart, int molesWhacked) { 
		 	System.out.println(molesWhacked);
		    Date timeAtEnd = new Date();
		    JOptionPane.showMessageDialog(null, "Your whack rate is "
		            + String.format("%.2f", (molesWhacked/((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00)))
		                  + " moles per second.");
	}
	
	public WhackAMole() {
		
		
		
		
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
		
		if(e.getSource() != mole) {
			int random = r.nextInt(5);
			
			if (random==1) {
				speak("you missed");
			}
			else if(random==2) {
				speak("oops");
			}
			else if(random==3) {
				speak("wrong button");
			}
			else if(random==4) {
				speak("oopsie daisy");	
			}
			else {
				speak("nope");
			}
			misses++;
			
			if(misses == 5) {
				speak("you lost");
				endGame(date, score);
				misses = 0;
				score = 0;
			}
		}
		
		if(e.getSource() == mole) {
			score++;
			System.out.println(score);
			
			if(score == 10) {
				endGame(date, score);
				score = 0;
				misses = 0;
			}
		}
		
		frame.dispose();
		int random = r.nextInt(24);
		this.drawButtons(random);
		
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
