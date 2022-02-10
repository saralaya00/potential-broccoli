import java.util.*;

class SelectionSort {

  // Best case O(n^2)::O(1), already sorted but still we have to go through all elements
  // Worst case O(n^2)::O(1), reverse sorted but it doesn't matter
  // Average case O(n^2)::O(1)
  public static int[] selectionSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int min = i;
      // j = i + 1, because we can ignore previous min selected items which are now sorted
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[min]) {
          min = j;
        }
      }
      swap(i, min, array);
    }
    return array;
  }

  public static void swap(int i, int j, int[] array) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
