import java.util.Stack;
public class InfixtoPostfix {
    static int priority(char c){
        if(c =='^')return 3;
        else if(c=='*'||c=='/')return 2;
        else if(c=='+'||c=='-')return 1;
        else return -1;
        
    }
    static String conversion(String s){
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                ans.append(c);
            }
            
            else if(c == '('){
                st.add(c);
            }
            else if(c==')'){
                while(st.peek()!='('){
                    
                    ans.append(st.pop());
                }
                
                if(!st.isEmpty())st.pop();

            }
            else{
                while (!st.isEmpty()&&(priority(c)<=priority(st.peek()))) {
                    ans.append(st.pop());
                }
                st.add(c);
            }
        }
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.toString();

    }


    public static void main(String[] args) {
        String s = "a+b*c";
        String result = conversion(s);
        System.out.println(result);

        
    }
}
