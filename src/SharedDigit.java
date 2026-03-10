public class SharedDigit {
    public static boolean hasSharedDigit(int a, int b){
        if((a < 10 || a > 99)||(b < 10 || b > 99)){
            return false;
        }
        boolean check = false;
        for(int i = a; i > 0; i /= 10){
            int n1 = i % 10;
            for(int j = b; j > 0; j /= 10){
                int n2 = j % 10;
                if(n1 == n2){
                    check = true;
                    break;
                }
            }
            if(check){
                break;
            }
        }
        return check;
    }
}