public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double a, double b){
        if( (long)(a * 1000) == (long)(b * 1000) ){
            return true;
        } else {
            return false;
        }
    }
}