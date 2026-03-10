//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    IO.println(String.format("Hello and welcome!"));

    for (int i = 1; i <= 5; i++) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        IO.println("i = " + i);
    }

    int primeCounter = 0;
    for(int i = 10; i < 50; i++){
        boolean isCheck = isPrime(i);
        if (isCheck){
            System.out.println("Here is prime number: " + i);
            primeCounter++;
        }
        if (primeCounter == 3){
            break;
        }
    }
    int sum = 0;
    int count = 0;
    for(int i = 1; i <= 1000; i++){
       if(i % 3 == 0 && i % 5 == 0){
           sum += i;
           count++;
       }
       if(count == 5){
           break;
       }
    }
    System.out.println("Here is the sum of numbers that met the conditions: " + sum);
    System.out.println("Final sum of digits: " + sumDigits(1234));
//    System.out.println("Are there shared value: " + hasSharedDigit(15, 55));
//    String name = System.console().readLine("What is your name? ");
//    System.out.println("Here is your name: " + name);

    int number = 0;
    int OddCount = 0;
    while (number <= 20){
        if(OddCount == 5){
            break;
        }
        if(number % 2 == 0){
            System.out.println("It is even number: " + number);
            OddCount++;
        } else {
            continue;
        }
        number++;
    }
}
public static boolean isPrime(int wholeNumber){
    if(wholeNumber <= 2){
        return (wholeNumber == 2);
    }
    for(int divisor = 2; divisor <= wholeNumber / 2; divisor++){
        if(wholeNumber % divisor == 0){
            return false;
        }
    }
    return true;
}
public static boolean isEvenNumber(int number){
    return number % 2 == 0;
}
public static int sumDigits(int number){
    int sum = 0;
    if(number < 0){
        return -1;
    }
    while(true){
        if(number < 10) break;
        sum += number%10;
        number = number/10;
    }
    return sum + number;
}
//public static boolean hasSharedDigit(int a, int b){
//    if((a < 10 || a > 99)||(b < 10 || b > 99)){
//        return false;
//    }
//    boolean check = false;
//    for(int i = a; i > 0; i /= 10){
//        int n1 = i % 10;
//        for(int j = b; j > 0; j /= 10){
//            int n2 = j % 10;
//            if(n1 == n2){
//                check = true;
//                break;
//            }
//        }
//        if(check){
//            break;
//        }
//    }
//    return check;
//}