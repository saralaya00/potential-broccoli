import java.util.*;

class ArrayOfProducts {
  // O(n)::O(n)
  public int[] arrayOfProducts(int[] array) {
		int leftProduct = 1, rightProduct = 1;
		int[] output = new int[array.length];
		
		// Divide the array into to two chunks
		// Left side contains trailing product going lower to higher
		// Right side contains trailing product going higher to lower
		for (int i = 0; i < array.length; i++) {
			output[i] = leftProduct;
			leftProduct *= array[i];
		}
		
		// Multiply left product with current right to get the total product 
		for (int i = array.length - 1; i >= 0; i--) {
			output[i] *= rightProduct;	
			rightProduct *= array[i];
		}

    return output;
  }
}
