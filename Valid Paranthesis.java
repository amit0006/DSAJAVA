class Solution {
    public boolean isValid(String s) {
        char[] str = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (char c : str) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    st.push(c);
                    break;
                case ')':
                    if (st.isEmpty() || st.pop() != '('){
                        return false;
                    } 
                    break;
                case '}':
                    if (st.isEmpty() || st.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (st.isEmpty() || st.pop() != '[') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }

        return st.isEmpty();
        
    }
}