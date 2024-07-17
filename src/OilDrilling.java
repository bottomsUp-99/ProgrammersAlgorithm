import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class OilDrilling {
  public static void main(String[] args) {
    OilDrilling Solution = new OilDrilling();
    int[][] land = {
        {0, 0, 0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 1, 1, 0, 0},
        {1, 1, 0, 0, 0, 1, 1, 0},
        {1, 1, 1, 0, 0, 0, 0, 0},
        {1, 1, 1, 0, 0, 0, 1, 1}
    };
    System.out.println(Solution.solution(land));
    int[][] land2 = {
        {1, 0, 1, 0, 1, 1},
        {1, 0, 1, 0, 0, 0},
        {1, 0, 1, 0, 0, 1},
        {1, 0, 0, 1, 0, 0},
        {1, 0, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 1}
    };
    System.out.println(Solution.solution(land2));
    int[][] land3 = {
        {1, 1, 1, 1},
        {1, 0, 0, 0},
        {1, 0, 1, 0},
        {1, 0, 0, 0},
        {1, 1, 1, 1}
    };
    System.out.println(Solution.solution(land3));
    int[][] land4 = {
        {1, 1, 1, 0, 0, 0},
        {1, 1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1, 1},
        {0, 0, 1, 1, 0, 0}
    };
    System.out.println(Solution.solution(land4));

  }

  Map<Integer, Integer> map = new HashMap<>();
  int count = 2;

  public int solution(int[][] land) {
    int answer = 0;
    count = 2;
    map.clear();

    int height = land.length;
    int width = land[0].length;
    int[][] oilLand = new int[height][width]; // 석유 현황을 보여줄 2차원배열

    for (int row = 0; row < land.length; row++) {
      for (int col = 0; col < land[0].length; col++) {
        if (land[row][col] == 1) {
          int value = checkAround(land, row, col, oilLand);
          map.put(count, value);
          count++;
        }
      }
    }

//    for (int row = 0; row < land.length; row++) {
//      for (int col = 0; col < land[0].length; col++) {
//        System.out.print(land[row][col] + " ");
//      }
//      System.out.println();
//    }

//    for (Integer integer : map.keySet()) {
//      System.out.print("Key : " + integer + ", Value : " + map.get(integer) + " ");
//    }
//    System.out.println();

    for (int col = 0; col < oilLand[0].length; col++) {
      int sum = 0;
      Set<Integer> set = new HashSet<>();
      for (int row = 0; row < oilLand.length; row++) {
        set.add(oilLand[row][col]);
      }
      for (Integer integer : set) {
        sum += map.getOrDefault(integer, 0);
      }
      answer = Math.max(answer, sum);
    }

    return answer;
  }

  public int checkAround(int[][] land, int row, int col, int[][] oilLand) {
    if (row < 0 || col < 0) {
      return 0; // 배열 범위 확인
    } else if (row >= land.length || col >= land[0].length) {
      return 0;
    } else if (land[row][col] != 1) {
      return 0;   // 방문한 곳이거나 석유가 없으면 0 반환
    } else {    // 방문하지 않은 석유가 있으면
      int value = oilLand[row][col];
      land[row][col] = count;
      oilLand[row][col] = count;
      return checkAround(land, row - 1, col, oilLand) +
          checkAround(land, row, col - 1, oilLand) +
          checkAround(land, row + 1, col, oilLand) +
          checkAround(land, row, col + 1, oilLand) +
          value;
    }
  }
}
