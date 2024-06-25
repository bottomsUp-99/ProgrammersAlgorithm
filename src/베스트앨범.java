import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class 베스트앨범 {

  public static void main(String[] args) {
    String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    int[] plays = {500, 600, 150, 800, 2500};
    System.out.println(Arrays.toString(solution(genres, plays)));
  }
  
  public static class movie{ //관리해주기 위해 클래스를 따로 만들어 index와 play 생성
    int index;
    int play;
    public movie(int index, int play){
      this.index = index;
      this.play = play;
    }
  }
  public static int[] solution(String[] genres, int[] plays) {
    ArrayList<Integer> answer = new ArrayList<>();
    HashMap<String, Integer> genreInfo = new HashMap<>();

    for (int i = 0; i < genres.length; i++) { // 장르별로 저장하여 play 수 누적합 저장하기
      genreInfo.put(genres[i], genreInfo.getOrDefault(genres[i], 0) + plays[i]);
    }

    ArrayList<String> mapToGenres = new ArrayList<>(genreInfo.keySet());//ArrayList 생성해주고 genreInfo의 key 값을 넣어줌
    mapToGenres.sort(((o1, o2) -> genreInfo.get(o2) - genreInfo.get(o1)));//genreInfo의 value 값을 기준으로 내림차순 정렬
    
    for (String item : mapToGenres){
      ArrayList<movie> movies = new ArrayList<>();
      for (int i = 0; i < genres.length; i++) {
        if (item.equals(genres[i])){
          movies.add(new movie(i, plays[i]));
        }
      }
      movies.sort(new Comparator<movie>() {
        @Override
        public int compare(movie o1, movie o2) {//재생횟수가 같으면 고유번호가 낮으 노래 먼저 수록
          if(o1.play == o2.play){
            return o1.index - o2.index;
          }
          return o2.play - o1.play;
        }
      });
      answer.add(movies.get(0).index);
      if (movies.size() > 1){ // 장르별로 노래 최대 두개까지 수록
        answer.add(movies.get(1).index);
      }
    }
    return answer.stream().mapToInt(i -> i).toArray();//stream을 intstream으로 변환
  }
}