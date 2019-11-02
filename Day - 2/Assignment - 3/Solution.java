import java.util.Stack;

class Solution {
	public static String isMatching(String str){
		// fill you code Here
		Stack<Character> stack  = new Stack<Character>();
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if(c == '[' || c == '(' || c == '{' ) {     
					stack.push(c);
				} else if(c == ']') {

					if(stack.isEmpty() || stack.pop() != '[') {
						return "NO";
					}

				} else if(c == ')') {
					if(stack.isEmpty() || stack.pop() != '(') {
						return "NO";
					}           
				} else if(c == '}') {
					if(stack.isEmpty() || stack.pop() != '{') {
						return "NO";
					}
				}
			}
			if(!stack.isEmpty()){
			 return "NO";
			}
			return "YES";
		}
}		