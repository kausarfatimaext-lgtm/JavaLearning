public class NumberToWords {
    public static void numberToWords(int number){
        if(number < 0){
            System.out.println("Invalid Value");
        }
        int num = reverse(number);
        int leadingZeroes = getDigitCount(number) - getDigitCount(num);
        if(number == 0){
            System.out.println("Zero");
            return;
        }
        for(int i = num; i > 0; i /= 10){
            int digit = i % 10;
            switch(digit){
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
            }
        }
        for(int i = 0; i < leadingZeroes; i++){
            System.out.println("Zero");
        }
    }
    public static int reverse(int number){
        int reverse = 0;
        while (number != 0) {
            reverse = reverse * 10 + number % 10;
            number /= 10;
        }
        return reverse;
    }
    public static int getDigitCount(int number){
        if(number < 0){
            return -1;
        }
        if(number == 0) return 1;
        int count = 0;
        for(int i = number; i > 0; i /= 10){
            count++;
        }
        return count;
    }
}