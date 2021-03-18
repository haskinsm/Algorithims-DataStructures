import java.util.Stack;

public class balancedBracketString {
    public static boolean isBalanced(String in)
    {
        Stack<Character> st = new Stack<Character>();

        for(char chr : in.toCharArray())
        {
            switch(chr) {

                case '{':
                case '(':
                case '[':
                    st.push(chr);
                    break;

                case ']':
                    if(st.isEmpty() || st.pop() != '[') 
                        return false;
                    break;
                case ')':
                    if(st.isEmpty() || st.pop() != '(')
                        return false;
                    break;
                case '}':
                    if(st.isEmpty() || st.pop() != '{')
                        return false;
                    break;
            }
           
        }
        return st.isEmpty();
    }
    public static void main(String args[]) {
    	
        System.out.println( isBalanced("()()") );
        System.out.println( isBalanced("()())"));
        System.out.println( isBalanced("({)}"));
        System.out.println( isBalanced("([] [] () {})"));
    }
}
