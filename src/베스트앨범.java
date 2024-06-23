import java.util.Arrays;
import java.util.HashMap;

public class 베스트앨범 {

  public static void main(String[] args) {
    String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    int[] plays = {500, 600, 150, 800, 2500};
    System.out.println(Arrays.toString(solution(genres, plays)));
  }
  public static int[] solution(String[] genres, int[] plays) {
    int[] answer = {};
    HashMap<String, Integer> genreNum = new HashMap<>();
    HashMap<String, Integer> playsNum = new HashMap<>();
    for (String genre : genres){
      genreNum.put(genre, genreNum.getOrDefault(genre, 0) + 1);
    }
    for (int i = 0; i < genres.length; i++) {
      //모르겠어요...
    }
    return answer;
  }
}