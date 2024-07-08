import java.util.PriorityQueue;

public class 상담원인원 {

  public static void main(String[] args) {
    int k1 = 3; // 상담 유형
    int n1 = 5; // 멘토 수
    int[][] reqs1 = {{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}, {60, 30, 2},
        {65, 30, 1}, {70, 100, 2}}; //예약 시간, 상담 시간, 상담 유형
    System.out.println("-----------첫 번째 테스트 케이스-----------");
    System.out.println(solution(k1, n1, reqs1));

    int k2 = 2; // 상담 유형
    int n2 = 3; // 멘토 수
    int[][] reqs2 = {{5, 55, 2}, {10, 90, 2}, {20, 40, 2}, {50, 45, 2}, {100, 50, 2}}; //예약 시간, 상담 시간, 상담 유형
    System.out.println("-----------두 번째 테스트 케이스-----------");
    System.out.println(solution(k2, n2, reqs2));
  }

  public static int solution(int k, int n, int[][] reqs) {
    int answer;
    int[][] waitingList = new int[k][]; // 각 상담타입에 따라서 배정된 멘토의 수에 따른 대기 시간 리스트
    for (int i = 0; i < k; i++) {
      waitingList[i] = getTypeWaiting(i + 1, n - k + 1, reqs); // 각 타입에 대해서 멘토 수 별로 대기 시간을 저장.
    }
    answer = getMinWaiting(waitingList, 0, n);
    return answer;
  }

  public static int[] getTypeWaiting(int type, int maxMento,
      int[][] reqs) { //배정 될 멘토를 1명부터 최대인원까지 늘려가며 각 경우의 대기시간을 구한다
    int[] delays = new int[maxMento];
    for (int i = 0; i < maxMento; i++) {
      int count = i + 1;//최소 한명은 배정
      int delay = 0;
      PriorityQueue<Integer> endQueue = new PriorityQueue<>();
      for (int[] req : reqs) {//각 예약정보 가져오기
        if (req[2] == type) {//타입 별로 ㄱㄱ
          int time = req[0];//예약 시간 추출
          if (endQueue.size() == count) {//신청자와 멘토수가 같은 경우 -> 대기시간 조회
            int endTime = endQueue.remove();
            int delayTime = Math.max(time, endTime);//
            delay += delayTime - time;
          }
          endQueue.add(time + req[1]);//아무도 없거나 신청자보다 멘토가 많은 경우
        }
      }
      delays[i] = delay; // 각 배정 받은 멘토 수에 따른 대기시간 저장
    }
    return delays;
  }

  public static int getMinWaiting(int[][] delayTable, int typeIndex, int numOfMento) {//재귀로 돌려버리기~
    if (typeIndex == delayTable.length) {// 모든 타입에 대한 검사가 끝난 경우
      return 0;
    } else {
      int initialWaitingTime = Integer.MAX_VALUE;//대기시간을 우선 최댜 양의 정수값으로 초기화
      int possibleMento =
          numOfMento - delayTable.length + typeIndex + 1;//지금 검사하는 상담타입에 배정될 수 있는 최대 멘토 수
      // 최소 한명임은 보장 해주기 위해 +1(원래는 타입 1이지만, 배열에선 0으로 표현)
      for (int i = 0; i < possibleMento; i++) {
        initialWaitingTime = Math.min(initialWaitingTime, delayTable[typeIndex][i]
            + getMinWaiting(delayTable, typeIndex + 1, numOfMento - i - 1));
      }//Ex) 첫번째 타입에 한명이 들어왔다면, 그 타입에 한명 들어왔을 경우의 최솟값 + (그 다음 타입에서 또 최대 인원 수를 정해서 각 인원 별로의 최솟값
      return initialWaitingTime;
    }
  }
}