import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class K번째수 {

  public static void main(String[] args) {
    int[] array = {1, 5, 2, 6, 3, 7, 4};
    int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
    System.out.println(Arrays.toString(solution(array, commands)));
  }
  public static int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];

    for(int i = 0; i < commands.length; i++){
      ArrayList<Integer> tmp = new ArrayList<>();//임시로 담아둘 tmp라는 list 하나 생성
      int first = commands[i][0];
      int last = commands[i][1];
      int index = commands[i][2];
      for(int j = first - 1 ; j < last ; j++){ // 지정된 범위에 해당하는 숫자를 tmp에 넣어주기
        tmp.add(array[j]);
      }
      Collections.sort(tmp); // 정렬
      answer[i] = tmp.get(index - 1); // 원하는 위치에 있는 숫자 가져와 answer에 넣어주기
    }
    return answer;
  }
}