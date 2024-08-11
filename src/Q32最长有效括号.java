import java.util.Stack;

public class Q32最长有效括号{
    public static void main(String[] args) {
        String p1 = "(()";
        String p2 = ")()())";
        String p3 = "";
        String p4 = "()(()";
        String p5 = "()(())";
//        longestValidParentheses(p1);
//        longestValidParentheses(p2);
//        longestValidParentheses(p3);
//        longestValidParentheses(p4);
        longestValidParentheses(p5);

    }

    public static int longestValidParentheses(String s) {
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // 初始基准索引
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 左括号索引入栈
                stack.push(i);
            } else {
                // 弹出栈顶元素
                stack.pop();
                if (stack.isEmpty()) {
                    // 如果栈为空，说明当前的右括号无法匹配，更新基准索引
                    stack.push(i);
                } else {
                    // 如果栈不为空，计算当前有效子串的长度
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        System.out.println(maxLength);
        return maxLength;
    }
//    public static int longestValidParentheses(String s) {
//        int count = 0;
//        int length = s.length();
//        int pushCount = 0;
//        Stack<Character> parentheses = new Stack<>();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < length; i++) {
//            if (s.charAt(i)=='('){
//                parentheses.push('(');
//                pushCount+=1;
//                if (pushCount>1){
//                    count=0;
//                }
//            }
//            else if (s.charAt(i)==')' && !parentheses.isEmpty()) {
//                parentheses.pop();
//                sb.append('(');
//                count+=1;
//                sb.append(')');
//                count+=1;
//                pushCount=0;
//            }
//
//        }
//        System.out.println(sb.toString());
//        System.out.println(count);
//        return sb.length();
//    }
}
