package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    int size = 1000; // size of the transactions array
    double[] transactions = new double[size]; // array to hold transactions
    int index = 0; // current index for next transaction

    public BankAccount(String name, int startingBalance){
        // Initialize the name and starting balance
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if (amount > 0 && index < size) { // check for positive amount and space in array
            transactions[index] = amount; // store the deposit
            index ++; // move to next index
            currentBalance += amount; // update balance
            System.out.println("Name: " + name + ", Deposit: " + amount + ", New balance: " + currentBalance);
        }
        else {
            // either amount is non-positive or array is full
            System.out.println("Unsuccessful deposit.");
        }
    }

    public void withdraw(double amount){
        // check for positive amount, sufficient balance, and space in array
        if (amount > 0 && amount <= currentBalance && index < size){
            transactions[index] = - amount; // store the withdrawal as negative
            index ++; // move to next index
            currentBalance -= amount; // update balance
            System.out.println("Name: " + name + ", Withdraw: " + amount + ", New balance: " + currentBalance);
        }
        else {
            // either amount is non-positive, insufficient balance, or array is full
            System.out.println("Unsuccessful withdrawal.");
        }
    }

    public void displayTransactions(){
        for (int i = 0; i < index; i++) {
            if (transactions[i] > 0) { // positive amount indicates deposit
                System.out.println("Deposit: " + transactions[i]);
            }
            else { // negative amount indicates withdrawal
                System.out.println("Withdraw: " + (-transactions[i]));
            }
        }
    }

    public void displayBalance(){
        System.out.println("Name: " + name + ", Current balance: " + currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
