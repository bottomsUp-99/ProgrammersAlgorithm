public class 논리연산자_실습1 {
    public static boolean isAgeDiscountable(int age) {
        boolean isDiscount = false;
        // 아래 빈칸을 채워 코드를 완성하세요.
        if(
                (age <= 19) || (age >= 60)
        ) {
            isDiscount = true;
        }
        else {
            isDiscount = false;
        }
        return isDiscount;
    }

        public static void main(String[]args) {

            isAgeDiscountable(15);
            isAgeDiscountable(27);
        }
    }

