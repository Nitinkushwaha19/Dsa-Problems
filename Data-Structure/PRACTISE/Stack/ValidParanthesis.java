import java.util.Stack;

public class ValidParanthesis {
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                // closing brackets
                if(s.isEmpty()) {
                    return false;
                }
                
                if ((ch == ')' && s.peek() == '(')
                        || (ch == '}' && s.peek() == '{')
                        || (ch == ']' && s.peek() == '[')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }

        return s.isEmpty();
    }

    public static void main(String[] args) {
        String str = "()}[]";
        System.out.println(isValid(str));
    }
}
