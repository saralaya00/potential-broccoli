/* package codechef; // don't place package name! */

// https://www.codechef.com/problems/XOREQUAL
// https://iq.opengenus.org/binary-exponentiation/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
/*
 XOREQUAL.main(new String[]{})
*/
class XOREQUAL
{
    static long max = 1000000007;

    // log power transformer
	public static void main (String[] args) throws java.lang.Exception
	{
	    int tests = 4;
	    int[] n = new int[]{1,2,3,4};
	    
	    int count = 0;
	    for (int t = 0; t < tests; t++) {
	        System.out.println(log_power_xor(2, n[t] - 1));
	    }
	}
	
	// a pow b
	static long log_power_xor(long a, long b) {
	    if (b == 0) {
	        return 1;
	    }
	    
	    long recursive = log_power_xor(a, b/2);
	    if (b % 2 == 0) {
	        return (recursive  * recursive) % max;
	    }

        return (recursive * recursive * a) % max;
	}
	
	/* Naive Sol
	public static void main (String[] args) throws java.lang.Exception
	{
	    int t = 2;
	    int n = new int[]{1,2};
	    int count = 0;
	    for (int test = 0; test < t; test++) {
    		for (int i = 0; i < Math.pow(2,a[test]); i++) {
    		    int x = i;
    		    if (x^(x+1) == (x+2)^(x+3)) {
    		        count++;
    		    }
    		}
	    }
	}*/
}
