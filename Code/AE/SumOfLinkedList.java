import java.util.*;

class SumOfLinkedList {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }
  
  // O(max(m,n))::O(max(m,n))
  public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
    LinkedList outputStart, outputHead, llOneHead, llTwoHead;
		outputStart = null;
		outputHead = null;
		llOneHead = linkedListOne;
		llTwoHead = linkedListTwo;
		
		int carry = 0;
		
		while (llOneHead != null || llTwoHead != null || carry != 0) {
			int llOneVal = llOneHead == null ? 0 : llOneHead.value;
			int llTwoVal = llTwoHead == null ? 0 : llTwoHead.value;
			
			int sum = llOneVal + llTwoVal + carry;
			int value = sum % 10;
			carry = sum / 10;
			
			LinkedList node = new LinkedList(value);
			
			llOneHead = llOneHead == null ? null : llOneHead.next;
			llTwoHead = llTwoHead == null ? null : llTwoHead.next;
			
			if (outputStart == null) {
				outputStart = node;
				outputHead = node;
				continue;
			}
			outputHead.next = node;
			outputHead = node;
		}
    return outputStart;
  }
}
