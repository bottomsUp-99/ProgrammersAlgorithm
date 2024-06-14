public class 나머지가1이되수찾기 {
    class Solution {
        public int solution(int n) {
            int ans = 0;
            for(int i = 1 ; i < n ; i++){
                if(n % i == 1){
                    ans = i;
                    break;
                }
            }
            return ans;
        }
    }
}
