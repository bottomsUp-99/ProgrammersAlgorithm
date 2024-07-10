import java.util.Arrays;
import java.util.Stack;

public class 같은숫자는싫어 {

  public static void main(String[] args) {
    int[] arr = {1, 1, 3, 3, 0, 1, 1};
    System.out.println(Arrays.toString(solution(arr)));
  }

  public static int[] solution(int[] arr) {
    Stack<Integer> stk = new Stack<>();
    stk.push(arr[0]);//우선 arr배열의 첫번째 값 스택에 푸쉬
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] != stk.peek()) { //그전에 들어간 값과 같은지 다른지만 판별
        stk.push(arr[i]);
      }
    }
    int[] answer = new int[stk.size()];
    for (int j = stk.size() - 1; j >= 0; j--) {//스택은 lifo방식으로 운영되는 컬렉션 객체이니까 반대순서로 뽑아와서 저장
      answer[j] = stk.pop();
    }
    return answer;
  }
}