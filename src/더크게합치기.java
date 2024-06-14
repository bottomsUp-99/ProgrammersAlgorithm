public class 더크게합치기 {
    class Solution {
        public int solution(int a, int b) {
            String as = String.valueOf(a);
            String bs = String.valueOf(b);
            String f = as + bs;
            String s = bs + as;
            int fi = Integer.parseInt(f);
            int si = Integer.parseInt(s);
            int answer = 0;
            if (fi >= si){
                answer = fi;
            } else {
                answer = si;
            }
            return answer;
        }
    }
}
