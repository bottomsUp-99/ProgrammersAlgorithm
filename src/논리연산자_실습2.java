public class 논리연산자_실습2 {
    public static boolean isAgeTwenties(int age) {
        boolean isTwenties = false;
        //아래 빈칸을 채워 코드를 완성하세요.
        if(
                (age >= 20) && (age < 30)
        ) {
            isTwenties = true;
        }
        else {
            isTwenties = false;
        }
        return isTwenties;
    }

    public static void main(String[] args) {
        isAgeTwenties(19);
        isAgeTwenties(25);
    }
}