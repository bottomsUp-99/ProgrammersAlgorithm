
import java.util.Arrays;

class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
//    String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II",
    String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
    String[] result = solution.solution(files);
//    for (String r : result) {
//      System.out.println(r);
//    }
    System.out.println(Arrays.toString(result));
  }

  public static int findFirstNumberIndex(char[] a){
    int indexOfNumberFirstA = 0;

    for (int k = 0; k < a.length; k++) {
      if (a[k] >= '0' && a[k] <= '9') {
        indexOfNumberFirstA = k;

        while(k < a.length && a[k] >= '0' && a[k] <= '9') {
          k++;
        }
        break;
      }
    }
    return indexOfNumberFirstA;
  }

  public static int findEndNumberIndex(int firstIndexB, String file) {


//    int k = firstIndexB;
//    while(k < (firstIndexB+5) && k <file.length() ) {
//      if (Character.isDigit(file.charAt(k))){
//        k++;
//      }
//      break;
//    }
//    return k;


    int k = firstIndexB;
    while(k < (firstIndexB+5) && k <file.length() && Character.isDigit(file.charAt(k))) {
      k++;
    }
    return k;


  }

  public String[] solution(String[] files) {

    for (int i = 0; i < files.length - 1; i++) {
      for (int j = i + 1; j < files.length; j++) {

        int firstIndexA = findFirstNumberIndex(files[i].toCharArray());
        int firstIndexB = findFirstNumberIndex(files[j].toCharArray());

        String headA = files[i].substring(0, firstIndexA);
        String headB = files[j].substring(0, firstIndexB);

//        System.out.print(files[i].substring(0, firstIndexA) + "   ");
//        System.out.println(files[j].substring(firstIndexA, lastIndexA));

        if(headA.equalsIgnoreCase(headB)) {
          //숫자 비교
          int lastIndexA = findEndNumberIndex(firstIndexA, files[i]);
          int lastIndexB = findEndNumberIndex(firstIndexB, files[j]);

          int m = Integer.parseInt(files[i].substring(firstIndexA, lastIndexA));
          int n = Integer.parseInt(files[j].substring(firstIndexB, lastIndexB));

          if(m > n) {
            String temp = files[i];
            files[i] = files[j];
            files[j] = temp;
          }
        } else {
          //알파벳 비교
          int headComparison = headA.compareToIgnoreCase(headB);
          if (headComparison > 0) {
            String temp = files[i];
            files[i] = files[j];
            files[j] = temp;
          }
        }
      }
    }
    return files;
  }
}
