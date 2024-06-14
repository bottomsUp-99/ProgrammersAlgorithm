public class 덧칠하기 {
    class Solution {
        public int solution(int n, int m, int[] section) {
            int first = section[0];
            int last = first + m - 1;
            int answer = 1;
            for(int i : section){
                if(i >= first && i <= last){
                    continue;
                } else {
                    first = i;
                    last = first + m -1;
                    answer++;
                }
            }
            return answer;
        }
    }
}
