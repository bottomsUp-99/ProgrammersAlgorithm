public class 대소문자바꿔서출력하기 {
    import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = new String(br.readLine());
            String ans = "";
            for (int i = 0 ; i < str.length() ; i++){
                char c = str.charAt(i);
                if (Character.isUpperCase(c)){
                    ans += Character.toLowerCase(c);
                } else {
                    ans += Character.toUpperCase(c);
                }
            }
            System.out.println(ans);
        }
    }
}
