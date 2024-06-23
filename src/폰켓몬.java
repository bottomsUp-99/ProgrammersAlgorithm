import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {

  public static void main(String[] args) {
    int[] nums = {3, 3, 3, 2, 2, 2};
    int result = solution(nums);
    System.out.println(result);
  }
  public static int solution(int[] nums){
    int answer = 0;
    int poneKetMonNum = nums.length / 2; //내가 가질 수 있는 최대 폰켓몬 종류 수
    Set<Integer> myPoneKetMon = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      myPoneKetMon.add(nums[i]);
    }
//    if (myPoneKetMon.size() >= poneKetMonNum){
//      answer = poneKetMonNum;
//    } else {
//      answer = myPoneKetMon.size();
//    }
    if (poneKetMonNum >= myPoneKetMon.size()){
      answer = myPoneKetMon.size();
    } else {
      answer = poneKetMonNum;
    }
    return answer;
  }//값은 제대로 다 나오는데 런타임에러...;;;아오 ㅋㅋㅋㅋ
}
