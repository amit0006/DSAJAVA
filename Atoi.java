class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty() || s==null){
            return 0;
        }
        long x = 0;
        int n = 0;
        int sign = 1;
        if (s.charAt(n) == '+' || s.charAt(n) == '-') {
            sign = s.charAt(n) == '-' ? -1 : 1;
            n++;
        }
        while(n<s.length() && Character.isDigit(s.charAt(n))){
            int digit = s.charAt(n)-'0';
            x = (x*10)+digit;
            if(x>Integer.MAX_VALUE){
                if(sign == -1){
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            n++;
        }
        return (int)(sign * x);
        
    }
}