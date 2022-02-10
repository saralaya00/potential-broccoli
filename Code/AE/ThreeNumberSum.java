import java.util.*;

class ThreeNumberSum {
	// O(n^2)::O(n)
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		List<Integer[]> listOfTriplets = new ArrayList<Integer[]>();
		Arrays.sort(array);
		int n = array.length;
		
		for (int i = 0; i < n; i++) {
			final int first = array[i];
			int leftPtr = i + 1;
			int rightPtr = n - 1;
			
			while (leftPtr < rightPtr) {
				int second = array[leftPtr];
				int third = array[rightPtr];
				int currentSum = first + second + third;
				if (currentSum == targetSum) {
					listOfTriplets.add(new Integer[] {first, second, third});
					leftPtr++;
					rightPtr--;
				}
				else if (currentSum < targetSum) {
					leftPtr++;
				}
				
				else rightPtr--;
			}
		}
    return listOfTriplets;
  }
}
