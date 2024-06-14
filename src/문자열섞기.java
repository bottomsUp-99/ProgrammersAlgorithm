public class 문자열섞기 {
    class Solution {
        public String solution(String str1, String str2) {
            int str1Len = str1.length();
            int str2Len = str2.length();
            String answer = "";
            for(int i = 0 ; i < str1Len ; i++){
                answer += str1.substring(i, i + 1) + str2.substring(i, i + 1);
            }
            return answer;
        }
    }
}
