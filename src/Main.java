/*
 * Main.java
 * 
 * Version: 1.0.0
 * 
 */

/**
 * 
 * @author Simone Cappabianca - Mat: 5423306
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world!!!");
		int dim = 10;
		int [] anArrayOfInts = new int[dim];
		byte[] anArrayOfBytes = new byte[dim];
		short[] anArrayOfShorts = new short[dim];
		long[] anArrayOfLongs = new long[dim];
		float[] anArrayOfFloats = new float[dim];
		double[] anArrayOfDoubles = new double[dim];
		boolean[] anArrayOfBooleans = new boolean[dim];
		char[] anArrayOfChars = new char[dim];
		String[] anArrayOfStrings = new String[dim];
		//for (int i=0; i<dim; i++) {
		//	System.out.println(" - " + anArrayOfShorts[i]);
		//}
		System.out.println("Empty field in array of int: " + anArrayOfInts[0]);
		System.out.println("Empty field in array of byte: " + anArrayOfBytes[0]);
		System.out.println("Empty field in array of short: " + anArrayOfShorts[0]);
		System.out.println("Empty field in array of long: " + anArrayOfLongs[0]);
		System.out.println("Empty field in array of float: " + anArrayOfFloats[0]);
		System.out.println("Empty field in array of double: " + anArrayOfDoubles[0]);
		System.out.println("Empty field in array of boolean: " + anArrayOfBooleans[0]);
		System.out.println("Empty field in array of char: " + anArrayOfChars[0]);
		System.out.println("Empty field in array of String: " + anArrayOfStrings[0]);
	}
}
