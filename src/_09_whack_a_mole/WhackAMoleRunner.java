package _09_whack_a_mole;

import java.util.Random;

public class WhackAMoleRunner {
	public static void main(String[] args) {
		WhackAMole w = new WhackAMole();
		Random r = new Random();
		int random = r.nextInt(24);
		w.drawButtons(random);
	}
}
