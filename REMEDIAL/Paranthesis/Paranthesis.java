import java.util.Stack;

class Paranthesis {

    public static String Solution(String str) {
        Stack<Character> s = new Stack<>();

        if (str.length() == 0) {
            return "String is Empty";
        }
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (ch == '{' || ch == '[' || ch == '(') {
                    s.push(ch);
                }
                else if (ch == '}') {
                    if (s.pop() != '{') {
                        return "Not-Matching";
                    }
                }
                else if (ch == ']') {
                    if (s.pop() != '[') {
                        return "Not-Matching";
                    }
                }
                else if (ch == ')') {
                    if (s.pop() != '(') {
                        return "Not-Matching";
                    }
                }
                
            }
            return "Matching";  
    }

    public static void main(String[] args) {
        String str = "[(])";
        System.out.println(Solution(str));
    }
}
