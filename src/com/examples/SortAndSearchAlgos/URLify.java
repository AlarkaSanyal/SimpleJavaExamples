package com.examples.SortAndSearchAlgos;

public class URLify {

	public static void main(String[] args) {
		String a = "Hello World Cat    ";
		int trueLength = findTrueLength(a.toCharArray());
		if (trueLength > 0) {
			System.out.println("Replaced String = " + replacedString(a.toCharArray(), trueLength));
		} else {
			System.out.println("Empty string");
		}		
	}

	private static int findTrueLength(char[] cs) {
		for (int i = cs.length - 1; i >= 0; i--) {
			if (cs[i] != ' ') {
				return i + 1;
			}
 		}
		return -1;
	}
	
	private static String replacedString(char[] cs, int trueLength) {
		int spaceCount = 0;
		int index;
		int i = 0;
		
		// Count the number of spaces
		for (i = 0; i < trueLength; i++) {
			if (cs[i] == ' ') {
				spaceCount++;
			}
		}
		
		// Set the index for the final string
		index = trueLength + (spaceCount * 2);
		
		for (i = trueLength - 1; i >= 0; i--) {
			if (cs[i] == ' ') {
				cs[index - 1] = '0';
				cs[index - 2] = '2';
				cs[index - 3] = '%';
				index = index - 3;
			} else {
				cs[index - 1] = cs[i];
				index--;
			}
		}
		
		return new String(cs);
	}
}
