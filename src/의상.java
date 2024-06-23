import java.util.HashMap;

public class 의상 {

  public static void main(String[] args) {
    String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
    System.out.println(solution(clothes));
  }

  public static int solution(String[][] clothes) {
    int answer = 1;
    HashMap<String, Integer> cloth = new HashMap<>();

    for(int i = 0; i < clothes.length; i++) {//getOrDefault() 함수를 활용하여 종류에 맞게 중복없이 개수를 더해준다.
      cloth.put(clothes[i][1], cloth.getOrDefault(clothes[i][1], 0) + 1);
    }
    for(String key : cloth.keySet()) {
      int value = cloth.get(key);
      answer *= (value + 1); // 해당 부위를 안 입을 수 있으니 하나씩 더해서 곱해준다.
    }
    return answer - 1; // 나체는 ㄴㄴ해요...
    //아니 얘도 런타임..................ㅡ.ㅡ
  }
}
