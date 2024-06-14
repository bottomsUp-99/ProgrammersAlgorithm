public class 문자열겹쳐쓰기 {
    class Solution {
        public String solution(String my_string, String overwrite_string, int s){
            int ms = my_string.length();
            int os = overwrite_string.length();
            String answer = my_string.substring(0, s) + overwrite_string + my_string.substring(os+s,ms);
            return answer;
        }
    }
}
