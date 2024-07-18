import java.util.Arrays;

public class 최소직사각형 {

  public static void main(String[] args) {
    int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
    System.out.println(solution(sizes));

    int[][] size1 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
    System.out.println(solution(size1));
  }
  public static int solution(int[][] sizes){
    int max_x = 0;
    int max_y = 0;

    for (int i = 0; i < sizes.length; i++) {
      Arrays.sort(sizes[i]);
    }
    for (int i = 0; i < sizes.length; i++) {
        max_x = Math.max(max_x, sizes[i][0]);
        max_y = Math.max(max_y, sizes[i][1]);
    }

    return max_x * max_y;
  }
}