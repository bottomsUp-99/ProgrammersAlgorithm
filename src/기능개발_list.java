import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발_list {

  public static void main(String[] args) {
    int[] progresses = {93, 30, 55};
    int[] speeds = {1, 30, 5};
    System.out.println(Arrays.toString(solution(progresses, speeds)));

  }
  public static int[] solution(int[] progresses, int[] speeds){
    int[] degreeOfAdvancement = new int[progresses.length];//각 작업별 배포까지 걸리는 날짜 저장
    for (int i = 0; i < progresses.length; i++) {
      degreeOfAdvancement[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
    }

    List<Integer> answerList = new ArrayList<>();
    int count = 1; //배포가 가능한 작업의 갯수
    int compare = degreeOfAdvancement[0]; //첫번째 작업부터 비교를 해줄거예요~
    for (int i = 1; i < degreeOfAdvancement.length; i++) {//그래서 두번째 값부터 가져와서 compare랑 비교 ㄱㄱ
      if (compare >= degreeOfAdvancement[i]){
        count++;
      } else {
        answerList.add(count);
        count = 1; //다시 배포 가능 갯수 초기화
        compare = degreeOfAdvancement[i]; //비교값을 그 다음 인덱스로 넘겨 초기화
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
