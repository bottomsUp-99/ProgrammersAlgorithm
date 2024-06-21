import java.util.HashMap;
import java.util.HashSet;

public class 완주하지못한선수 {

  public static void main(String[] args) {
    String[] participant = {"mislav", "stanko", "mislav", "ana"};
    String[] completion = {"stanko", "ana", "mislav"};
    String s = (String) solution(participant, completion);
    System.out.println(s);
  }
  public static Object solution(String[] participant, String[] completion){
    String answer = "";
    HashMap<String, HashSet<Integer>> participantMap = new HashMap<>();

    for (String s : participant) {
      if (!participantMap.containsKey(s)){
        participantMap.put(s, new HashSet<>());
        participantMap.get(s).add(0);
      } else {
        Integer[] a = participantMap.get(s).toArray(new Integer[0]);
        int max = -1;
        for(int num : a){
          max = Math.max(num, max);
        }
        participantMap.get(s).add(max + 1);
      }
    }

    for (String s : completion){
      if (participantMap.get(s).size() > 1){
        Integer[] a = participantMap.get(s).toArray(new Integer[0]);
        int max = -1;
        for(int num : a){
          max = Math.max(num, max);
        }
        participantMap.get(s).remove(max);
      } else {
        participantMap.remove(s);
      }
    }

    answer = participantMap.keySet().toString();
    return answer;
  }
  //값은 제대로 다 나오는데 런타임에러...;;;
}
