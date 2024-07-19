import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {

  public static void main(String[] args) {
    int[] answers = {1,2,3,4,5};
    System.out.println(Arrays.toString(new List[]{solution(answers)}));
  }
  public static List<Integer> solution(int[] answers){
    int[] rankArr = {0, 0, 0};
    int[][] routine = {{1,2,3,4,5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    for(int i=0; i < answers.length; i++) {
      if(answers[i] == routine[0][i%5]){
        rankArr[0]++;
      }
      if(answers[i] == routine[1][i%8]){
        rankArr[1]++;
      }
      if(answers[i] == routine[2][i%10]){
        rankArr[2]++;
      }
    }
    int max = Math.max(rankArr[0], Math.max(rankArr[1], rankArr[2]));
    List<Integer> answer = new ArrayList<>();
    for (int i = 0; i < rankArr.length; i++) {
      if (rankArr[i] == max){
        answer.add(i + 1);
      }
    }
    return answer;
  }
}
