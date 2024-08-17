import java.util.Stack;

public class DuplicateParanthesis {
    public static boolean isDuplicate(String str) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0;i<str.length();i++) {
            int ch = str.charAt(i);
            if(ch != ')') {
                s.push(ch);
            } else {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count ++;
                }

                if(count < 1) {
                    return true;
                } else {
                    s.pop();
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "((a+b))";
        System.out.println(isDuplicate(str));        
    }
}
