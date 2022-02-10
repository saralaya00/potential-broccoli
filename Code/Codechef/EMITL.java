/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.codechef.com/problems/EMITL
/*
 EMITL.main(new String[]{})
*/
class EMITL
{
    public static void main (String[] args) throws java.lang.Exception
	{
        Scanner sc = new Scanner(System.in);
		int numOfTests = sc.nextInt();
		while (numOfTests-- > 0){
		    String str = sc.next();
            System.out.println(testString(str));
        }
	}

    // For local tests
	// public static void main (String[] args) throws java.lang.Exception
	// {
	//     final String[] tests = new String[]{
    //         "LTIMEAZAZAITLME", 
    //         "LLLTTTIIIMMMEEEAHA", 
    //         "LTIMEM"
    //     };
	    
	//     for (int t = 0; t < tests.length; t++) {
	//         System.out.println(testString(tests[t]));
	//     }
	// }
 
    static String testString(String test) {
        String str =  test.length() == 9 ? "LTIMEMITL" : "LTIMEEMITL";  // required String can be shorter if size is 9

        if (test.length() < str.length())
            return "NO";

        for (int i = 0; i < test.length(); i++) {
            String character = "" + test.charAt(i);
            if (str.indexOf(character) != -1) {
                str = str.replaceFirst(character, "");
            }

            if (str.length() == 0)
                break;
        }
        
        return str.length() == 0 ? "YES" : "NO";
    }
}
