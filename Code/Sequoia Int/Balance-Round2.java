Check for Balanced Brackets in an expression (well-formedness)

Given an expression string exp, write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.

Example: 

Input: exp = “[()]{}{[()()]()}” 
Output: Balanced

Input: exp = “[(])” , "[()]"
Output: Not Balanced 

temp 


String exp = arg[0];
String[] open = new String[] { "(", "{", "["};
String[] closed = new String[] { ")", "}", "]"};
List<Integer> temp = new Stack();

for (String item: exp) {
    if (open.contains(item)) {
        temp.push(item);
        continue;
    }

    if (closed.equals(item)) {
        if (temp.peek() == item)
            temp.pop(item);
        contine;
    }
}

return temp.size() == 0;





// Sol
import java.util.Stack;

public class Main
{
    public static void main(String[] args) {
        String exp = "[]()"; //"[]()[[({})]]()"; // "[[]((){[]})]";

        final String open = "({[";
        final String closed = ")}]";

        Stack<String> temp = new Stack();
        
        for (int i = 0; i < exp.length(); i++) {
            final String item = "" + exp.charAt(i);

            if (open.contains(item)) {
                temp.push(item);
                continue;
            }
        
            else if (closed.contains(item) && temp.size() != 0) {
                final int indexOfClosed = closed.indexOf(item);
                final String relativeBracket = "" + open.charAt(indexOfClosed);
                if (temp.peek().equals(relativeBracket)) {
                    temp.pop();
                    continue; 
                }
            }
 
            else {
                System.out.println("Unbalanced");
                return;    
            }
        }
        System.out.println(temp.size() == 0 ? "Balanced" : "Unbalanced");
    }
}
