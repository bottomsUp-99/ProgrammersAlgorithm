import java.util.Arrays;

public class 가장큰수 {

  public static void main(String[] args) {
    int[] numbers = {6, 10, 2};
    System.out.println(solution(numbers));
  }

  public static String solution(int[] numbers) {
    StringBuilder answer = new StringBuilder();
    String[] tmp = new String[numbers.length];

    for (int i = 0; i < tmp.length; i++) {
      tmp[i] = String.valueOf(numbers[i]);
    }
    Arrays.sort(tmp, (o1, o2) -> (o2 + o1).compareTo(o1 + o2)); // 문자열로 compare 해줄때 변환 구조 ? 알아보기

    for (String s : tmp) {
      answer.append(s);
    }
    return String.valueOf(answer);
  }
}