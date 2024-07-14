import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 석유시추 {
  // 석유의 존재 유무를 확인하기 위해 (상, 하, 좌, 우)를 움직일 수 있음.
  private static final int[] dx = {-1, 1, 0, 0};
  private static final int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) {
    int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 1, 1, 0, 0},
        {1, 1, 0, 0, 0, 1, 1, 0},
        {1, 1, 1, 0, 0, 0, 0, 0},
        {1, 1, 1, 0, 0, 0, 1, 1}};
    System.out.println(solution(land));
  }

  public static int solution(int[][] land) {
    int height = land.length;
    int width = land[0].length;

    int[][] oilLand = new int[height][width]; // 석유 현황을 보여줄 2차원배열
    Map<Integer, Integer> oilStorage = new HashMap<>(); // 석유의 양과 구역을 저장
    int numOfOilSection = 2; // 석유 구역 번호 (1은 석유 존재 유무를 나타내므로 2부터 시작)

    // 석유 구역 찾기
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (land[i][j] == 1) {//만약 석유가 존재하면~
          int amount = dfs(land, oilLand, i, j, numOfOilSection);
          oilStorage.put(numOfOilSection, amount);
          numOfOilSection++;
        }
      }
    }

    // 각 열마다 최대 석유보유량 계산
    int maxOil = 0;
    for (int j = 0; j < width; j++) {//각열마다 조회하므로
      Set<Integer> oilSectionSet = new HashSet<>();
      int totalOil = 0;
      for (int i = 0; i < height; i++) {//오일이 들어있는 구역 번호를 저장.
        if (oilLand[i][j] > 1) {
          oilSectionSet.add(oilLand[i][j]);
        }
      }
      for (int id : oilSectionSet) {
        totalOil += oilStorage.get(id);
      }
      maxOil = Math.max(maxOil, totalOil);
    }
    return maxOil;
  }
  private static int dfs(int[][] land, int[][] oilLand, int height, int weight, int oilId) {
    if (height < 0 || height >= land.length || weight < 0 || weight >= land[0].length || land[height][weight] != 1) {
      return 0;
    }

    land[height][weight] = oilId;
    oilLand[height][weight] = oilId;
    int amountOfOil = 1;

    for (int d = 0; d < 4; d++) {
      int nx = height + dx[d];
      int ny = weight + dy[d];
      amountOfOil += dfs(land, oilLand, nx, ny, oilId);
    }
    return amountOfOil;
  }
}
