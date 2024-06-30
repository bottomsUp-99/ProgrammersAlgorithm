import java.util.Arrays;
import java.util.Comparator;

public class 파일명정렬 {

  public static void main(String[] args) {
    String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
    System.out.println(Arrays.toString(solution(files)));
  }
  public static String[] solution(String[] files) {
    String[] answer = {};
    Arrays.sort(files, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        String[] file1 = fileInfo(s1);
        String[] file2 = fileInfo(s2);

        int headValue = file1[0].compareTo(file2[0]);//head 부분 비교해주기
        if (headValue == 0) { //head 부분이 같으면
          int numValue1 = Integer.parseInt(file1[1]);
          int numValue2 = Integer.parseInt(file2[1]);
          return Integer.compare(numValue1, numValue2);//number 부분 비교해주기
        }
        return headValue;
      }
      private String[] fileInfo(String s) {
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        StringBuilder tail = new StringBuilder();

        int location = 0;

        while (location < s.length() && !Character.isDigit(s.charAt(location))) {//숫자인지 판별하여 숫자가 아닌 문자이면 head에 추가
          head.append(s.charAt(location));
          location++;
        }

        while (location < s.length() && Character.isDigit(s.charAt(location))) {//이 전 while 문에서 문자가 아닌 숫자로 판별되어 while 문 탈출
          number.append(s.charAt(location));                                    //여기서는 숫자인지 판별하여 숫자가 아닌 값이 나올 때까지 number에 추가
          location++;
        }

        if (location < s.length()) {//나머지 부분은 tail에 그냥 다 넣어주기
          tail.append(s.substring(location));
        }

        return new String[]{head.toString().toLowerCase() + number.toString() + tail.toString()};
      }
    });

    answer = files;
    return answer;
  }
}
