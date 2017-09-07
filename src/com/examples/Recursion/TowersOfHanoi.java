package com.examples.Recursion;

public class TowersOfHanoi {

	public static void main(String[] args) {
		
		// moveDisks(number of disks, initialTower, finalTower)
		String steps = moveDisks(3, 1, 3);
		for (String step : steps.split(";")) {
			System.out.println(step);
		}
	}

	private static String moveDisks(int disks, int initialTower, int finalTower) {
		if (disks == 1) {
			// First step (looking backwards) is to move the top disk from initial tower to the final tower
			return initialTower + " -> " + finalTower + ";";
		}
		String step1, step2, step3;
		int helperTower = 6 - (initialTower + finalTower);
		// Second, move all remaining disks (except the last) to the middle tower
		step1 = moveDisks(disks - 1, initialTower, helperTower);
		// Third move the bottommost disk from the initial tower to the final tower
		step2 = initialTower + " -> " + finalTower + ";";
		// Four, move all disks gathered on the middle tower to the final tower
		step3 = moveDisks(disks - 1, helperTower, finalTower);
		
		return step1 + step2 + step3;
	}

	
}
