import java.util.Stack;
public class PreFixToPostfix {
    static String conversion(String s){
        Stack<String> st = new Stack<>();
        int len = s.length();
        for(int i =len-1;i>=0;i--){
            Character c = s.charAt(i);
            if(c=='^'||c=='*'||c=='/'||c=='+'||c=='-'){
                String s1 = st.pop();
                String s2 = st.pop();
                s2 = s1+s2+c;
                st.push(s2);
            }
            else{
                st.push(c.toString());
            }
        }
        return st.pop();
    }
    public static void main(String[] args) {
        String s = "/-ab*+def";
        System.out.println(conversion(s));
    }
}
