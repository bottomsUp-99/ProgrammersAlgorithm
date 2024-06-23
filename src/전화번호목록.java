import java.util.HashMap;

public class 전화번호목록 {

  public static void main(String[] args) {
    String[] phone_book = {"119", "97674223", "1195524421"};
    System.out.println(solution(phone_book));
  }
  public static boolean solution(String[] phone_book) {
    HashMap<String, Integer> phoneNumList = new HashMap<>();
    boolean answer = true;
    // 번호 저장
    for (int i = 0; i < phone_book.length; i++) {
      phoneNumList.put(phone_book[i], i);
    }
    for (int i = 0; i < phone_book.length; i++) {
      // 전화번호목록 길이만큼 순회
      for (int j = 0; j < phone_book[i].length(); j++) {
        // 한 번호가 다른 번호의 접두어인 경우가 있는지 확인
        if (phoneNumList.containsKey(phone_book[i].substring(0, j))) {
          answer = false;
        }
      }
    }
    return answer; // 얘도 런타임 ....
  }
}