public class 문자리스트를문자열로반환하기 {
    class Solution {
        public String solution(String[] arr) {
            String answer = "";
            for(int i = 0 ; i < arr.length ; i++){
                answer += arr[i];
            }
            return answer;
        }
    }
}
