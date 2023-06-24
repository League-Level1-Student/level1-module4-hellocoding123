package _06_calculator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	
	JFrame frame;
	JPanel panel;
	JButton addButton;
	JButton subButton;
	JButton mulButton;
	JButton divButton;
	JTextField text1;
	JTextField text2;
	JLabel label;
	
	public double add(double num1, double num2) {
		return num1 + num2;
	}
	
	public double subtract(double num1, double num2) {
		return num1 - num2;
	}
	
	public double multiply(double num1, double num2) {
		return num1 * num2;
	}
	
	public double divide(double num1, double num2) {
		return num1 / num2;
	}

	public void run() {
		// TODO Auto-generated method stub
		
		frame = new JFrame();
		panel = new JPanel();
		addButton = new JButton("add");
		subButton = new JButton("subtract");
		mulButton = new JButton("multiply");
		divButton = new JButton("divide");
		text1 = new JTextField();
		text2 = new JTextField(); 
		label = new JLabel();
		
		text1.setColumns(5);
		text2.setColumns(5);
		
		frame.setSize(200, 200);
		label.setFont(new Font("Arial", 1, 50));
		
		frame.add(panel);
		panel.add(addButton);
		panel.add(subButton);
		panel.add(mulButton);
		panel.add(divButton);
		panel.add(text1);
		panel.add(text2);
		panel.add(label);
		
		
		
		addButton.addActionListener(this);
		subButton.addActionListener(this);
		divButton.addActionListener(this);
		mulButton.addActionListener(this);
		
		frame.setVisible(true);
		//frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		
		if (e.getSource() == addButton) {
			double answer = add(Double.parseDouble(text1.getText()),Double.parseDouble(text2.getText()));
			label.setText(String.valueOf(answer));
			//frame.pack();
		}
		
		if (e.getSource() == subButton) {
			double answer = subtract(Double.parseDouble(text1.getText()),Double.parseDouble(text2.getText()));
			label.setText(String.valueOf(answer));
			//frame.pack();
		}
		
		if (e.getSource() == mulButton) {
			double answer = multiply(Double.parseDouble(text1.getText()),Double.parseDouble(text2.getText()));
			label.setText(String.valueOf(answer));
			//frame.pack();
		}
		
		if (e.getSource() == divButton) {
			double answer = divide(Double.parseDouble(text1.getText()),Double.parseDouble(text2.getText()));
			label.setText(String.valueOf(answer));
			//frame.pack();
		}
	}
}
