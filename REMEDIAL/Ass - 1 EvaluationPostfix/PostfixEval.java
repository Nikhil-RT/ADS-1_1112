import java.util.Stack;

    class PostfixEval {

        static int calc(String s) {

            int n = s.length();

            Stack<Integer> a = new Stack<>();
            for (int i = 0; i < n; i++) {

                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    a.push(c - '0');
                }

                else {

                    int val1 = a.pop();
                    int val2 = a.pop();

                    if (c == '+') {
                        a.push(val2 + val1);
                    }
                    else if (c == '-') {
                        a.push(val2 - val1);
                    }
                    else if (c == '*') {
                        a.push(val2 * val1);
                    }
                    else if (c == '/') {
                        a.push(val2 / val1);
                    }
                }
            }
            return a.pop();
        }
    public static void main(String[] args) {
        String s = "1234*+-";
        System.out.println(": " + calc(s));
    }
}