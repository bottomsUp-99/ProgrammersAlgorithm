public class 같은숫자는싫어 {
    import java.util.*;

    public class Solution {
        public int[] solution(int []arr) {
            Stack<Integer> stk = new Stack<>();
            stk.push(arr[0]);
            for(int i = 1 ; i < arr.length ; i++){
                if(arr[i] != stk.peek()){
                    stk.push(arr[i]);
                }
            }
            int[] answer = new int[stk.size()];
            for(int j = stk.size()-1 ; j >= 0 ; j--){
                answer[j] = stk.pop();
            }
            return answer;
        }
    }
}
