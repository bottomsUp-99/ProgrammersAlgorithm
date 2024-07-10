import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발_queue {
  public static void main(String[] args) {
    int[] progresses = {93, 30, 55};
    int[] speeds = {1, 30, 5};
    System.out.println(Arrays.toString(solution(progresses, speeds)));
  }
  public static int[] solution(int[] progresses, int[] speeds) {
    Queue<Integer> degreeOfAdvancement = new LinkedList<>();//각 작업별 배포까지 걸리는 날짜 저장
    for (int i = 0; i < progresses.length; i++) {
      degreeOfAdvancement.add((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
    }

    List<Integer> answerList = new ArrayList<>();
    int repetitionNum = degreeOfAdvancement.size();
    int count = 1; //배포가 가능한 작업의 갯수
    int compare = degreeOfAdvancement.remove(); //첫번째 작업부터 비교를 해줄거예요~
    for (int i = 1; i < repetitionNum; i++) {
      if (compare >= degreeOfAdvancement.peek()) {
        count++;
        degreeOfAdvancement.remove();
      } else {
        answerList.add(count);
        count = 1; //다시 배포 가능 갯수 초기화
        compare = degreeOfAdvancement.remove(); //비교값을 그 다음 인덱스로 넘겨 초기화
      }
    }
    answerList.add(count);

    int[] answer = new int[answerList.size()];
    for (int i = 0; i < answerList.size(); i++) {
      answer[i] = answerList.get(i);
    }
    return answer;
  }
}