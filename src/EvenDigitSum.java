public class EvenDigitSum {
    static public int getEvenDigitSum(int number){
        int sum = 0;
        if(number < 0){
            return -1;
        }
        while(number >= 10){
            int n = number % 10;
            if(n % 2 == 0){
                sum += n;
            }
            number = number / 10;
        }
        if(number % 2 == 0){
            return number + sum;
        }
        return sum;
    }
}