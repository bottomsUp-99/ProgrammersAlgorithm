import java.util.Stack;

public class 올바른괄호 {

  public static void main(String[] args) {
    String s = "()()";
    System.out.println(solution(s));
  }
  static boolean solution(String s){
//    boolean answer = true;
//    Stack<String> isCorrect = new Stack<>();
//    for (int i = 0; i < s.length(); i++) {
//      if (isCorrect.isEmpty()) {//비어 있으면 s를 하나씩 넣어줌
//        isCorrect.push(String.valueOf(s.charAt(i)));
//      } else {//비어 있지 않은 경우
//        if (isCorrect.peek().equals(String.valueOf(s.charAt(i)))) {
//          isCorrect.pop();
//        } else {
//          answer = false;
//        }
//      }
//    } --------------------> 틀렸으메~~~~~~~~~~~~~~~~~
    boolean answer = false;
    Stack<Character> isCorrect = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        isCorrect.push('(');
      } else {
        if (isCorrect.isEmpty()) {
          return false;
        }
        isCorrect.pop();
      }
    }
    if (isCorrect.isEmpty()){
      answer = true;
    }
    return answer;
  }
}
