import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValidParenthesis(String str) { // O(n)
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Opening
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                // closing
                if (s.isEmpty()) {
                    return false;
                }
                // comparision of brackets --- >
                if ((s.peek() == '(' && ch == ')')
                        || (s.peek() == '{' && ch == '}')
                        || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }

        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "(){}}{";
        System.out.println(isValidParenthesis(str));

    }
}
