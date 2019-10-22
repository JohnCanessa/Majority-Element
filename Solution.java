import java.util.Scanner;

/*
 * 
 */
public class Solution {

	/*
	 * Find the majority element (if any) in the specified array.
	 * This code runs in O(n^2) time.
	 */
	static int findMajorityElement(int[] arr) {
		
		// **** traverse the array looking for the majority value ****
		for (int x : arr) {
			if (validate(arr, x))
				return x;
		}
		
		// **** majority not found ****
		return -1;
	}
	
	/*
	 * Validate if m is the majority element in the specified array.
	 * This method runs in O(n) time.
	 */
	static Boolean validate(int[] arr, int m) {
		
		// **** initialize the count ****
		int count = 0;

		// **** traverse the array counting the number of times m is present ****
		for (int i : arr) {
			if (i == m)
				count++;
		}

		// **** return true if m is the majority element ****
		return (count > (arr.length / 2) ? true : false);
	}
	
	/*
	 * Find the majority element (if any) in the specified array.
	 * This code runs in O(n) time.
	 */
	static int findMajorityElementA(int[] arr) {
		
		// **** get candidate in O(n) time ****
		int candidate = getCandidate(arr);
		
		// ???? ????
		System.out.println("findMajorityElementA <<< candidate: " + candidate);
		
		// **** validate the value in O(n) time ****
		return validate(arr, candidate) ? candidate : -1;
	}
	
	/*
	 * Get a majority candidate from the specified array.
	 * This method runs in O(n) time.
	 */
	static int getCandidate(int[] arr) {
		
		int candidate = 0;
		int count 	  = 0;
		
		// **** traverse the array ****
		for (int n : arr) {
			
			// **** set a new candidate (if needed) ****
			if (count == 0) {
				candidate = n;
			}
						
			// **** update the count based on the this array value ****
			if (n == candidate)
				count++;
			else
				count--;			
		}
		
		// **** return a candidate ****
		return candidate;
	}

	/*
	 * Test scaffolding.
	 */
	public static void main(String[] args) {
		
		// **** open the scanner ****
		Scanner sc = new Scanner(System.in);
		
		// **** read the number of elements in the array ****
		int n = sc.nextInt();
		
		// ???? ????
		System.out.println("main <<< n: " + n);
		
		// **** read and populate the array ****
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		// **** close the scanner ****
		sc.close();
		
		// ???? ????
		System.out.print("main <<< arr: [");
		for (int i = 0; i < arr.length; i++) {
			if ((i + 1) < arr.length)
				System.out.print(arr[i] + ", ");
			else
				System.out.print(arr[i]);
		}
		System.out.println("]");

		// **** brute force attempt: O(n^2) ****
		System.out.println("main <<<  findMajorityElement: " + findMajorityElement(arr));
		
		// **** faster attempt: O(n) ****
		System.out.println("main <<< findMajorityElementA: " + findMajorityElementA(arr));
	}

}
