import java.util.Stack;
public class PostfixToPrefix {
    static String conversion(String s){
        Stack<String> st = new Stack<>();
        int len = s.length();
        for(int i =0;i<len;i++){
            Character c = s.charAt(i);
            if(c=='^'||c=='*'||c=='/'||c=='+'||c=='-'){
                String s1 = st.pop();
                String s2 = st.pop();
                s2 = c+s2+s1;
                st.push(s2);
            }
            else{
                st.push(c.toString());
            }
        }
        return st.pop();
    }
    public static void main(String[] args) {
        String s = "ab-de+f*/";
        System.out.println(conversion(s));
    }
}
