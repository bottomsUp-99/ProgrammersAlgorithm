import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {

  public static void main(String[] args) {
    int[] prices = {1 ,2 ,3 ,2 ,3};
    System.out.println(Arrays.toString(solution(prices)));
  }
  public static int[] solution(int[] prices) {
    int[] answer = new int[prices.length];
    Stack<Integer> priceOfStock = new Stack<>();

    for (int i = 0; i < prices.length; i++) {//값이 떨어진 인덱스들에 대해서만 시간 저장
      while (!priceOfStock.isEmpty() && prices[i] < prices[priceOfStock.peek()]) {//비어있지 않고, 주식가격이 떨어진 경우
        answer[priceOfStock.peek()] = i - priceOfStock.peek();//그 전에 들어가있던 인덱스(시간,초)를 현재 인덱스에서 빼줌.
        priceOfStock.pop();
      }
      priceOfStock.push(i);//주식가격이 유지됐거나 상승했을 경우 혹은 비어있을 경우 or 그전과 비교해주기 위해 삽입
    }

    answer[prices.length - 1] = 0; // 마지막은 무조건 0
    for (int i = 0; i < prices.length - 1; i++) {//마지막 자리는 0으로 해줬기 때문에 그전까지의 위치까지만 검증 ㄱ
      if (answer[i] == 0){
        answer[i] = prices.length - i - 1;
      }
    }
    return answer;
  }
}
