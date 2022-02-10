import java.util.*;

class InsertionSort {

  // Best case O(n)::O(1), already sorted
  // Worst case O(n^2)::O(1), reverse sorted
  // Average case O(n^2)::O(1)
  public static int[] insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int j = i;
      while (j > 0 && array[j - 1] > array[j]) {
        swap(j - 1, j, array);
        j--;
      }
    }
    return array;
  }

  public static void swap(int i, int j, int[] array) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
