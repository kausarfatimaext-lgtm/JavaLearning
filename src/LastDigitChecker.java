public class LastDigitChecker {
    public static boolean hasSameLastDigit(int a, int b, int c){
        if((a < 10 || a > 1000) || (b < 10 || b > 1000) || (c < 10 || c > 1000)){
            return false;
        }
        int first = a % 10;
        int second = b % 10;
        int third = c % 10;
        return (first == second) || (second == third) || (third == first);
    }
    public static boolean isValid(int num){
        return num >= 10 && num <= 1000;
    }
}