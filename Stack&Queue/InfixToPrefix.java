import java.util.Stack;
public class InfixToPrefix {
    static int priority(char c){
        if (c=='^') return 3;
        else if(c=='*'||c=='/')return 2;
        else if(c=='+'||c=='-')return 1;
        else return -1;
    }

    static String conversion(String s){
        StringBuilder result = new StringBuilder();
        String str = new StringBuilder(s).reverse().toString();// reverse the given string
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            if(Character.isLetterOrDigit(c)){
                result.append(c);
            }
            else if(c==')'){
                st.add(c);
            }
            else if(c=='('){//I swapped the '(' and ')' in if else statment cause i have reversed the string and the bracket are reversed too
                while(!st.isEmpty()&&st.peek()!=')'){
                    result.append(st.pop());
                }
                st.pop();
            }
            else{
                while(!st.isEmpty()&&priority(c)<priority(st.peek())){
                    result.append(st.pop());
                }
                st.add(c);
            }
        }
        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        return result.reverse().toString(); // reverse the string again

    }

    public static void main(String[] args) {
        String s = "a+b*c";
        String ans = conversion(s);
        System.out.println(ans);
    }
}
