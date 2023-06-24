package _06_calculator;

public class CalculatorRunner {
	
	public static void main (String[] args) {
		
		Calculator calculator = new Calculator();
		calculator.run();
		System.out.println(calculator.add(1, 1));
	}
}
