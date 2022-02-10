import java.util.*;

// O(n)::O(1)
class LongestPeak {
  public static int longestPeak(int[] array) {
    int longestPeak = 0, n = array.length;
		for (int i = 1; i < n; i++) {
			int currentPeak = 0;
			int leftPtr = i, rightPtr = i;

			while (leftPtr > 0 && array[leftPtr - 1] < array[leftPtr]) {
				leftPtr--;
			}

			while (rightPtr < n - 1 && array[rightPtr] > array[rightPtr + 1]) {
				rightPtr++;
			}

			currentPeak = (rightPtr == i || leftPtr == i) ? 0 : rightPtr - leftPtr + 1;
			if (longestPeak < currentPeak) {
				longestPeak = currentPeak;
				i = rightPtr;
			}
		}
    return longestPeak;
  }
}
