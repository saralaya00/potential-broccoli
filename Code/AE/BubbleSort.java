import java.util.*;

class BubbleSort {

  // Best case O(n)::O(1), already sorted has a single pass
  // Worst case O(n^2)::O(1), reverse sorted has to go through all elements
  // Average case O(n^2)::O(1)
  public static int[] bubbleSort(int[] array) {
    boolean isSorted = false;
    int n = array.length;
    int lastSortedCount = 0;

    while (!isSorted) {
      isSorted = true;
      // n - 1, because checks with i and i + 1.
      // lastSortedCount since we dont have to check the last 'c' sorted items from the right everytime.
      for (int i = 0; i < (n - 1) - lastSortedCount; i++) {
        if (array[i] > array[i + 1]) {
          swap(i, i + 1, array);
          isSorted = false;
        }
      }
      lastSortedCount++;
      System.out.println(Arrays.toString(array));
    }
    return array;
  }

  public static void swap(int i, int j, int[] array) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
