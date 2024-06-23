import java.util.HashMap;
import java.util.Map;

public class Test {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    int[] plays = {500, 600, 150, 800, 2500};
    for(int i = 0; i < genres.length; i++) {
      map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
    }
    System.out.println(map);
  }
}