public class LargestPrime {

    public static int getLargestPrime(int number){

        if(number < 2){
            return -1;
        }

        int largestPrime = -1;

        for(int i = 2; i <= number; i++){

            while(number % i == 0){
                largestPrime = i;
                number /= i;
            }
        }
        return largestPrime;
    }
}