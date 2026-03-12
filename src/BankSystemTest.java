// ----------- Abstract ------------
abstract class Account {
    private String accountNum;
    private double balance;

    public Account(String accountNum, double balance){
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public String getAccountNum(){
        return accountNum;
    }
    public double getBalance(){
        return balance;
    }
    protected void setBalance(double balance){
        this.balance = balance;
    }

    public abstract void accountType();

    public void deposit(double amount){
        if(amount <= 0){
            System.out.println("Deposit must be positive!");
        } else {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        }
    }
    public void withdraw(double amount){
        if(amount > balance){
            System.out.println("Insufficient balance!");
        }else{
            balance -= amount;
            System.out.println(amount + " withdraw. Remaining balance: " + balance);
        }
    }
}

// ----------- Interfaces ------------
interface InterestBearing{
    void addInterest();
}

interface Overdraftable{
    void setOverdraftableLimit(double limit);
}

interface TransactionLogger{
    void logTransaction(String type, double amount);
}

// ----------- Implementing inheritance by extending abstract class and implementing interfaces with polymorphism -------------
class SavingsAccount extends Account implements InterestBearing, TransactionLogger {
    private double interestRate;

    public SavingsAccount(String accountNum, double balance, double interestRate){
        super(accountNum, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void accountType(){
        System.out.println("This is a Savings Account");
    }

    @Override
    public void addInterest(){
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        logTransaction("Interest added to account: ", interest);
    }

    @Override
    public void logTransaction(String type, double amount){
        System.out.println("SavingsAccount Transaction -> " + type + " : " + amount);

    }
}

class CurrentAccount extends Account implements Overdraftable, TransactionLogger {
    private double overdraftLimit;

    public CurrentAccount(String accountNum, double balance, double overdraftLimit){
        super(accountNum, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void accountType() {
        System.out.println("This is a Current Account");
    }

    @Override
    public void logTransaction(String type, double amount) {
        System.out.println("CurrentAccount Transaction -> " + type + " : " + amount);
    }

    @Override
    public void setOverdraftableLimit(double limit) {
        this.overdraftLimit = limit;
    }

    @Override
    public void withdraw(double amount){
        if(amount > getBalance() + overdraftLimit){
            System.out.println("Exceeded overdraft limit!");
        } else {
            setBalance(getBalance() - amount);
            logTransaction("Withdraw", amount);
        }
    }
}

// ----------- Interfaces ------------
interface PaymentMethod {
    void processPayment(Account fromAccount, Account toAccount, double amount);
}

interface Refundable {
    void refund(double amount);
}

// ------------ Multiple Inheritance in case of Interface Usage with polymorphism -----------
class CreditCardPayment implements PaymentMethod, Refundable{
    @Override
    public void processPayment(Account fromAccount, Account toAccount, double amount){
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        System.out.println("Payment processed via Credit Card");
    }
    @Override
    public  void refund(double amount){
        System.out.println("Refunded " + amount + " to credit card.");
    }
}

// ------------ Multiple Inheritance in case of Interface Usage -----------
class OnlinePayment implements PaymentMethod, Refundable{
    @Override
    public void processPayment(Account fromAccount, Account toAccount, double amount){
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        System.out.println("Payment processed via Online transfer");
    }
    @Override
    public void refund(double amount){
        System.out.println("Refunded " + amount + "to account.");
    }
}

public class BankSystemTest {
    public static void main(String[] args){
        SavingsAccount savings = new SavingsAccount("S001", 2000, 5);
        CurrentAccount current = new CurrentAccount("C001", 1000, 500);

        savings.accountType();
        current.accountType();

        System.out.println();

        savings.deposit(500);
        current.deposit(300);

        System.out.println();

        savings.withdraw(400);

        current.deposit(1300);

        System.out.println();

        savings.addInterest();

        System.out.println();

        PaymentMethod payment;

        payment = new OnlinePayment();
        payment.processPayment(current, savings, 150);

        System.out.println();

        Refundable refund = new CreditCardPayment();
        refund.refund(200);

        System.out.println();

        System.out.println("Final Balance: ");
        System.out.println("Savings Account: " + savings.getBalance());
        System.out.println("Current Account: " + current.getBalance());
    }
}