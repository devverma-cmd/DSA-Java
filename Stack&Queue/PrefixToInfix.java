import java.util.Stack;
public class PrefixToInfix {
    static String conversion(String s){
        Stack<String> st = new Stack<>();
        int len = s.length();
        for(int i =len-1;i>=0;i--){
            Character c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                st.push(c.toString());
            }
            else if(c=='*'||c=='/'||c=='-'||c=='+'||c=='^'){
                String s1 = st.pop();
                String s2 = st.pop();
                s2 = "("+s1+c+s2+")";
                st.push(s2);
            }
        }
        return st.pop();

    }

    public static void main(String[] args) {
        String s = "*+pq-mn";
        System.err.println(conversion(s));
    }
}
