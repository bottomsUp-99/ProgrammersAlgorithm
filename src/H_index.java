import java.util.Arrays;

public class H_index {

  public static void main(String[] args) {
    int[] citiations = {3, 0, 6, 1, 5};
    System.out.println(solution(citiations));
  }
  public static int solution(int[] citations) {
    int answer = 0;
    Arrays.sort(citations);
    for (int i = 0; i < citations.length; i++) {
      int num = citations.length - i;
      if (citations[i] >= num) {
        answer = num;
        break;
      }
    }
    return answer;
  }
}
