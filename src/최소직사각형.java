public class 최소직사각형 {

  public static void main(String[] args) {
    int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
    System.out.println(solution(sizes));

    int[][] size1 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
    System.out.println(solution(size1));
  }
  public static int solution(int[][] sizes){
    int x = getMaxX(sizes);
    int y = getMaxY(sizes);
    return findMinRectangle(sizes,x*y);
  }
  public static int findMinRectangle(int[][] sizes, int compareArea){
    int count = 0;
    while (count < sizes.length){
      for (int i = 0; i < sizes.length; i++) {
        int[][] compareArr = sizes;
        int tmp = compareArr[i][0];
        compareArr[i][0] = compareArr[i][1];
        compareArr[i][1] = tmp;
        if (compareArea > getMaxY(compareArr)*getMaxY(compareArr)) {
          compareArea = getMaxY(compareArr)*getMaxY(compareArr);
        }
      }
      count++;
    }
    return compareArea;
  }
  public static int getMaxX(int[][] sizes){
    int x_max = 0;
    for (int i = 0; i < sizes.length; i++) {
      if (sizes[i][0] > x_max) x_max = sizes[i][0];
    }
    return x_max;
  }
  public static int getMaxY(int[][] sizes){
    int y_max = 0;
    for (int i = 0; i < sizes.length; i++) {
      if (sizes[i][0] > y_max) y_max = sizes[i][0];
    }
    return y_max;
  }
}