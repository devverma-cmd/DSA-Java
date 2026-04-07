import java.util.Stack;
public class PostfixToInfix {

    
    static String conversion(String s){
        int len = s.length();
        Stack<String> st = new Stack<>();
        for(int i = 0;i<len;i++){
            Character c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                st.push(c.toString());
            }
            else if(c=='*'||c=='/'||c=='-'||c=='+'||c=='^'){
                String s1 = st.pop();
                String s2 = st.pop();
                s2 = "("+s2+c+s1+")";
                st.push(s2);
            }
        }
        return st.pop();
    }
    public static void main(String[] args) {
        String s = "ab-de+f*/";
        String result = conversion(s);
        System.out.println(result);
    }
}
