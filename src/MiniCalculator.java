import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class MiniCalculator{
    public static void main(String[] args){
        ArrayList<Object> arrayList = new ArrayList<>();
        Scanner userInput = new Scanner(System.in);
        boolean ToContinue = true;

        while(ToContinue){
            UserInput(arrayList, userInput);
            UserOpInput(arrayList, userInput);
            performOperations(arrayList);

            System.out.println("Do you want to continue(y/n): ");
            char input = userInput.next().charAt(0);
            if(input == 'Y' || input == 'y'){
                ToContinue = true;
            }else{
                ToContinue = false;
            }
        }
    }

    public static void UserInput(ArrayList<Object> array, Scanner input){
        while (array.size() < 2){
            System.out.println("Enter number: ");
            double number = input.nextDouble();
            array.add(number);
            backspaceOp(array, input);
        }
    }

    public static void UserOpInput(ArrayList<Object> array, Scanner input){
        System.out.println("Select Operation (+, -, *, /, %): ");
        char op = input.next().charAt(0);

        if(op != '+' && op != '-' && op != '*' && op != '/' && op != '%'){
            System.out.println("Enter valid operator");
            UserOpInput(array, input);
        } else {
            array.add(op);
            backspaceOp(array, input);
            if(array.size()<3){
                UserOpInput(array, input);
            }
        }
    }

    public static void performOperations(ArrayList<Object> array){
        BigDecimal result = BigDecimal.valueOf(0);
        double a = (double)array.get(0);
        double b = (double)array.get(1);
        char op = (char)array.get(2);
        result = switch (op) {
            case '+' -> BigDecimal.valueOf(a + b);
            case '-' -> BigDecimal.valueOf(a - b);
            case '*' -> BigDecimal.valueOf(a * b);
            case '/' -> BigDecimal.valueOf(a / b);
            case '%' -> BigDecimal.valueOf(a % b);
            default -> result;
        };
        System.out.println("Here is the result: " + result);
    }
    public static void backspaceOp(ArrayList<Object> array, Scanner input){
        System.out.println("OR Do you want to use backspace(Y/N): ");
        char uInput = input.next().charAt(0);
        if(uInput == 'Y' || uInput == 'y'){
            array.removeLast();
        } else if (uInput == 'N' || uInput == 'n') {
            return;
        } else {
            System.out.println("Enter valid answer");
            backspaceOp(array, input);
        }
    }
}