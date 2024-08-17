import java.util.Stack;

public class DuplicateParanthesis {

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);

            // Closing
            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }

                if (count < 1) {
                    return true; // Duplicate exists
                } else {
                    s.pop(); // Opening pair
                }

            } else {
                // openinig and pushing element into the stack
                s.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // String str1 = "((a+b))";
        String str2 = "(a-b)";

        System.out.println(isDuplicate(str2));
    }
}
