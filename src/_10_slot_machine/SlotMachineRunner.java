package _10_slot_machine;

import java.net.MalformedURLException;

public class SlotMachineRunner {

	public static void main(String[] args) {
		
		SlotMachine s = new SlotMachine();
		try {
			s.run();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
