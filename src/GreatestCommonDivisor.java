public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first, int second){
        int CommonDiv = 0;
        if(first < 10 || second < 10){
            return -1;
        }
        for(int i = 1; i <= first && i <= second; i++){
            if(first % i == 0 && second % i == 0){
                CommonDiv = i;
            }
        }
        return CommonDiv;
    }
}