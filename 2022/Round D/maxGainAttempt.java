import java.util.*;


public class Solution {
	private int[] arr1;
	private int[] arr2;
	
	public Solution(){
		
	}
	
	/**
	*	Removes old element in array and returns new array with left over numbers
	*/
	public int[] updateArray(int positionToBeElminiated, int[] arr) {
		int[] updatedArr = new int[arr.length - 1];
		
		int currentPosInNewArr = 0;
		
		for (int i = 0; i < arr.length; i++) {
			//Checks eleminated slot against current slot
			if(i == positionToBeElminiated) {
				continue;
			} else {
				updatedArr[currentPosInNewArr] = arr[i];
				currentPosInNewArr++;
			}
		}
		
		for (int i = 0; i < updatedArr.length; i++) {
				System.out.println("Element #" + i + ": " + updatedArr[i]);
		}
		
		System.out.println(" ");
		
		return updatedArr;
	}
	
	
	/**
	*	Determines which is the best option to take from the four survey options
	*/
	public int chooseQuestion(int[] arr1, int[] arr2) {
		//First array first and last element, with the full array
		//Note: in each array [{The array itself}, {The value}, {The position to elemate}]
		int[] choice1 = {arr1[0], 0};
		int[] choice2 = {arr1[arr1.length-1], arr1.length-1};
		
		//Second array first and last element
		int[] choice3 = {arr2[0], 0};
		int[] choice4 = {arr2[arr2.length-1], arr2.length-1};
		
		System.out.println("Choices: " + choice1[0] + ", " + choice2[0] + ", " + choice3[0] + ", " + choice4[0]);
		
		
		//Logic to determine which is the highest
		if (choice1[0] > choice2[0] && choice1[0] > choice3[0] && choice1[0] > choice4[0]) {
			//Removes item, returns value
			arr1 = updateArray(choice1[1], arr1);
			
			return choice1[0];
		} else if(choice2[0] > choice1[0] && choice2[0] > choice3[0] && choice2[0] > choice4[0]) {
			//Removes item, returns value
			arr1 = updateArray(choice2[1], arr1);
			
			return choice2[0];
			
		} else if (choice3[0] > choice1[0] && choice3[0] > choice2[0] && choice3[0] > choice4[0]) {
			//Removes item, returns value
			arr2 = updateArray(choice3[1], arr2);
			
			return choice3[0];
			
		} else {
			//Removes item, returns value
			arr2 = updateArray(choice4[1], arr2);
			
			return choice4[0];
			
		}
	}
	
	
	
	/**
	*	Runs each case
	*/
	public void runCase(Scanner in, int currentTestCase) {

		int arr1Size = in.nextInt();
    
         arr1 = new int[arr1Size];
        
        //Accumulator
        int addedInts = 0;
        
        //Fills array
        while(addedInts < arr1.length) {
            arr1[addedInts] = in.nextInt();
            addedInts++;
        }

		for (int i = 0; i < arr1.length; i++) {
				System.out.println("Element #" + i + ": " + arr1[i]);
		}
		
		System.out.println(" ");


        //Array 2 processing
        int arr2Size = in.nextInt();
    
        arr2 = new int[arr2Size];
        
        //Accumulator
        addedInts = 0;
        
        //Fills array
        while(addedInts < arr2.length) {
            arr2[addedInts] = in.nextInt();
            addedInts++;
        }
		
		for (int i = 0; i < arr2.length; i++) {
				System.out.println("Element #" + i + ": " + arr2[i]);
		}
		
		System.out.println(" ");
        
        //Num of items allowed to be done
        int maxItems = in.nextInt();
		
		//Num of points awarded
		int totalPts = 0;
		
		
		//Loop to cycle and rack up points
		while(maxItems != 0) {
			totalPts += chooseQuestion(arr1, arr2);
			maxItems--;
		}
		
		System.out.println("Case #" + currentTestCase + ": " + totalPts);
	}
	
	
	
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
		
		Solution temp = new Solution();
    
        int numOfTests = in.nextInt();
		
		int i = 1;
		
		//Runs all cases
		do {
			temp.runCase(in, i);
			i++;
		} while(i <= numOfTests);
		
	}
}
