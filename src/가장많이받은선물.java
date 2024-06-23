import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장많이받은선물 {

  public static void main(String[] args) {
    String[] friends = {"muzi", "ryan", "frodo", "neo"};
    String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi",
        "frodo muzi", "frodo ryan", "neo muzi"};
    System.out.println(solution(friends, gifts));
  }

  public static int solution(String[] friends, String[] gifts) {
    int answer = 0;
    StringTokenizer st;
    int[][] giftMatrix = new int[friends.length][friends.length];
    int[][] giftScore = new int[friends.length][3];
    int[] predictGift = new int[friends.length];
    for (String gift : gifts) {
      st = new StringTokenizer(gift);
      String from = st.nextToken();
      String to = st.nextToken();
      int indexOfTo = Arrays.asList(friends).indexOf(from);
      int indexOfFrom = Arrays.asList(friends).indexOf(to);
      giftMatrix[indexOfTo][indexOfFrom] += 1;
      giftScore[indexOfTo][0] += 1;
      giftScore[indexOfTo][2] += 1;
      giftScore[indexOfFrom][1] += 1;
      giftScore[indexOfFrom][2] -= 1;
    }
    for (int i = 0; i < friends.length; i++) {
      for (int j = 0; j < friends.length; j++) {
        if (giftMatrix[i][j] > 0) {
          if (giftMatrix[i][j] > giftMatrix[j][i]) {
            predictGift[i] += 1;
          } else if (giftMatrix[i][j] == giftMatrix[j][i]) {
            if (giftScore[i][2] > giftScore[j][2])
              predictGift[i] += 1;
          }

        } else if (giftMatrix[i][j] == 0) {
          if (giftMatrix[j][i] == 0) {
            if (giftScore[i][2] > giftScore[j][2])
              predictGift[i] += 1;
          }
        }
        if (answer < predictGift[i])
          answer = predictGift[i];
      }
    }
    return answer; // 예전 학교 스터디에 한건데 이해가 안감..
  }
}