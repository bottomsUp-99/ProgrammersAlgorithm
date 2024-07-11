import java.util.Collections;
import java.util.PriorityQueue;

public class 프로세스 {

  public static void main(String[] args) {
    int[] priorities = {2, 1, 3, 2};
    int location = 2;
    System.out.println(solution(priorities, location));
  }
  public static int solution(int[] priorities, int location){
    PriorityQueue<Integer> processQueue = new PriorityQueue<>(Collections.reverseOrder());//내림차순의 큐 생성

    for (int i : priorities) {//큐에 전달받은 우선순위 저장
      processQueue.offer(i);
    }
    System.out.println(processQueue);

    int compare = priorities[location];
    int answer = 0;
    for (Integer i : processQueue){
      if (i == compare){
        break;
      }
      answer++;
    }
    return answer + 1;
  }
}
