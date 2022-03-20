import java.util.*;

class MoveElementToEnd {
	// O(n)::O(1)
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    int left = 0, right = array.size() - 1;
		while (left < right) {
			while (left < right && array.get(right) == toMove) {
				right--;
			}
			
			if (array.get(left) == toMove) {
				swap(array, left, right);
			}
			left++;
 		}
    return array;
  }
	
	static void swap(List<Integer> array, Integer a, Integer b) {
		Integer temp = array.get(a);
		array.set(a, array.get(b));
		array.set(b, temp);
	}
}
