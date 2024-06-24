import java.util.HashMap;

public class 완주하지못한선수 {

  public static void main(String[] args) {
    String[] participant = {"mislav", "stanko", "mislav", "ana"};
    String[] completion = {"stanko", "ana", "mislav"};
    String s = (String) solution(participant, completion);
    System.out.println(s);
  }
  public static Object solution(String[] participant, String[] completion){
    String answer = "";
    HashMap<String, Integer> marathon = new HashMap<>();

    for (String name : participant) {
      if (marathon.containsKey(name)){
        marathon.put(name, marathon.get(name) + 1);
      } else {
        marathon.put(name, 1);
      }
    }

    for (String athlete : completion){
      if (marathon.get(athlete) == 1) {
        marathon.remove(athlete);
      } else {
        marathon.put(athlete, marathon.get(athlete) - 1);
      }
    }

    answer = (String) marathon.keySet().toArray()[0];
    return answer;
  }
}