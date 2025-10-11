public class SyntaxChecker {
    public static boolean isBalanced(String line){
        Stack<String> stack = new ArrayStack<>(line.length());
        for(int i = 0; i < line.length(); i++){
            char c = line.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(line.substring(i,i+1));
            }
            else if(c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty()){return false;}
                char p = stack.pop().charAt(0);
                if(!((c == ')' && p == '(') || (c == '}' && p == '{') || (c == ']' && p == '['))){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){return false;}
        return true;
    }

    public static void main(String[] args) {
        String line1 = "public static void main(String[] args) { ... }"; // Should be true
        String line2 = "int x = (5 + [a * 2]);"; // Should be true
        String line3 = "System.out.println('Hello');)"; // Should be false (extra closing parenthesis)
        String line4 = "List list = new ArrayList<{String>();"; // Should be false (mismatched)
        String line5 = "if (x > 0) {"; // Should be false (unmatched opening brace)
        String line6 = "{e(}e)"; //Should return false (wrong order)
        String line7 = "[a{b}a](c);"; //Should return true;

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
        System.out.println("Line 6 is balanced: " + isBalanced(line6));
        System.out.println("Line 7 is balanced: " + isBalanced(line7));
    }
}


