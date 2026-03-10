public class NumberPalindrome {
    public static boolean isPalindrome(int number){
        int lastDigit = 0;
        int reverse = 0;
        int Original = number;
        while(Original != 0){
            lastDigit = Original % 10;
            reverse = reverse * 10;
            reverse = reverse + lastDigit;
            Original = Original / 10;
        }
        return number == reverse;
    }
}