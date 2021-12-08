import java.util.Random; //import random and scanner classes
import java.util.Scanner;

public class finalProject {
	public static void main (String [] args){ 
		Scanner in = new Scanner(System.in); //scanner object
		Random rand = new Random(); //random object
		int[][] a = new int[2][2]; //2d array a
		for (int i = 0; i < 2; i++) { //initializing array a with random numbers
			for (int j = 0; j < 2; j++) {
				a[i][j] = rand.nextInt(10);
			}
		}
		System.out.println("Random Matrix:"); //printing array
		for (int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++)
		    {
		        System.out.print(a[i][j] + " ");
		    }
			System.out.println();
		}
		System.out.println("Enter the amount of times you want to multiply the square matrix:"); //asking user for input
		int n = in.nextInt(); //storing input
		multiply(a, n); //calling multiply method
	}
	
	public static void multiply (int[][] matrix, int amount) {
		int[][] result = new int [2][2]; //result array used to store final result 
		int[][] matrixP = new int [2][2]; //matrixP array used to store intermediate results
		for (int i = 0; i < 2; i++) { //initializing matrixP with inputed array in parameter
			for (int j = 0; j < 2; j++) {
				matrixP[i][j] = matrix[i][j];
			}
		}
		if (amount == 1) { //handle the case if user only wants to do a power of 1
			for (int i = 0; i < 2; i++) { //set result equal to parameter array
				for (int j = 0; j < 2; j++) {
					result[i][j] = matrix[i][j]; 
				}
			}
		}
		else {	
			for (int i = 1; i < amount; i++) { //repeat based on user input for power
				for (int y = 0; y < 2; y++) { // multiply array
					for (int x = 0; x < 2; x++) {
						result[x][y] = (matrix[x][0] * matrixP[0][y]) + (matrix[x][1]*matrixP[1][y]);
					}
				}
				if (i + 1 != amount) { //store intermediate result in case multiplication process needs to occur again
					for (int y = 0; y < 2; y++) { 
						for (int x = 0; x < 2; x++) {
							matrixP[y][x] = result[y][x];
						}
					}
				}
			}
		}
		for (int i = 0; i < 2; i++) { //print results
			for(int j = 0; j<2 ; j++){
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}	
	}
}
