import java.util.*;

class ReverseLinkedList {
	// O(n)::O(1)
  public static LinkedList reverseLinkedList(LinkedList head) {
		LinkedList second = head.next, first = head;
		
		while (second != null) {
			LinkedList third = second.next;
			second.next = first;
			if (first.next == head.next) {
					first.next = null;
			} 

			first = second;
			second = third;
		}
    return first;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
