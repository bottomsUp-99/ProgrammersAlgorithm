public class 두수의연산값비교하기 {
    class Solution {
        public int solution(int a, int b) {
            String as = String.valueOf(a);
            String bs = String.valueOf(b);
            String abs = as + bs;
            int abi = Integer.parseInt(abs);
            int cmp = 2*a*b;
            int answer = 0;
            if(abi >= cmp){
                answer = abi;
            } else {
                answer = cmp;
            }
            return answer;
        }
    }
}
