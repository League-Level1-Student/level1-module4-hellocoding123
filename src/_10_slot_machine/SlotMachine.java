package _10_slot_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	
	JFrame frame; 
	JPanel panel; 
	JButton button;
	JLabel slot1;
	JLabel slot2;
	JLabel slot3;		
	String seven = "7.png";
	String bar = "bar.png";
	String cherry = "cherry.png";
	
	public SlotMachine() {
		
		frame = new JFrame();
		panel = new JPanel();
		button = new JButton("Spin");
		
		button.addActionListener(this);
		
	}
	
	public void run() throws MalformedURLException {
		
		slot1 = createLabelImage(seven);
		slot2 = createLabelImage(bar);
		slot3 = createLabelImage(cherry);
		
		panel.add(slot1);
		panel.add(slot2);
		panel.add(slot3);
		
		frame.add(panel);
		panel.add(button);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(1515,575);
	    
		//frame.pack();
	}
	
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
	
	}
	
	public String randomSlotImage() {
		
		Random r = new Random();
		int random = r.nextInt(3);
		
		if(random == 0) {
			return seven;
		}
		
		if(random == 1) {
			return bar;
		}
		
		if(random == 2) {
			return cherry;
		}
		
		return null;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		panel.remove(slot1);
		panel.remove(slot2);
		panel.remove(slot3);
		panel.remove(button);
		
			String r1 = randomSlotImage();
			String r2 = randomSlotImage();
			String r3 = randomSlotImage();
	
		try {
			
			
			slot1 = createLabelImage(r1);
			
			slot2 = createLabelImage(r2);
		
			slot3 = createLabelImage(r3);
			
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		panel.add(slot1);
		panel.add(slot2);
		panel.add(slot3);
		panel.add(button);
		
		frame.pack();
		frame.setSize(1515,575);
		
		if(r1.equals(r2) && r2.equals(r3)) {
			JOptionPane.showMessageDialog(null, "YOU WON THE JACKPOT!!!");
		}
		
	}
    

	
}
