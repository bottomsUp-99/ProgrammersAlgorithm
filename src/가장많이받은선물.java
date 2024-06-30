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
    int[][] giftScore = new int[friends.length][friends.length];
    int[] willGivenGift = new int[friends.length];

    for (String gift : gifts) {
      st = new StringTokenizer(gift);
      String from = st.nextToken();
      String to = st.nextToken();
      int indexOfFrom = Arrays.asList(friends).indexOf(from);
      int indexOfTo = Arrays.asList(friends).indexOf(to);
      giftMatrix[indexOfFrom][indexOfTo] += 1;
      giftScore[indexOfFrom][indexOfTo] += 1;
      giftScore[indexOfTo][indexOfFrom] -= 1;
    }

//    for (int i = 0; i < friends.length; i++) {
//      for (int j = 0; j < friends.length; j++) {
//        if (i == j) continue;
//        if (giftMatrix[i][j] > 0) {
//          if (giftMatrix[i][j] > giftMatrix[j][i]) {
//            willGivenGift[i] += 1;
//          } else if (giftMatrix[i][j] == giftMatrix[j][i]) {//이게 두번 검증되므로 빡 나는겨
//            if (giftScore[i][j] > giftScore[j][i])
//              willGivenGift[i] += 1;
//          }
//        } else if (giftMatrix[i][j] == 0) {
//          if (giftMatrix[j][i] == 0) {
//            if (giftScore[i][j] > giftScore[j][i])
//              willGivenGift[i] += 1;
//          }
//        }
//        if (answer < willGivenGift[i]){
//          answer = willGivenGift[i];
//        }
//      }
//    }

    for (int i = 0; i < friends.length; i++) {
      for (int j = 0; j < friends.length; j++) {
        if (i == j) continue;
        if (giftMatrix[i][j] > giftMatrix[j][i]) {
          willGivenGift[i] += 1;
        } else if (giftMatrix[i][j] == giftMatrix[j][i]) {
          if (giftScore[i][j] > giftScore[j][i]) {
            willGivenGift[i] += 1;
          }
        }
      }
    }

    for (int i = 0; i < friends.length; i++) {
      if (answer < willGivenGift[i]) {
        answer = willGivenGift[i];
      }
    }
    return answer/2;
  }
}