package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    int size = 1000;
    double[] transactions = new double[size];
    int index = 0;

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if (amount > 0 && index < size) { // We check if
            transactions[index] = amount;
            index ++;
            currentBalance += amount;
            System.out.println("Name: " + name + ", Deposit: " + amount + ", New balance: " + currentBalance);
        }
        else {
            System.out.println("Unsuccessful deposit.");
        }
    }

    public void withdraw(double amount){
        if (amount > 0 && amount <= currentBalance && index < size){
            transactions[index] = - amount;
            index ++;
            currentBalance -= amount;
            System.out.println("Name: " + name + ", Withdraw: " + amount + ", New balance: " + currentBalance);
        }
        else {
            System.out.println("Unsuccessful withdrawal.");
        }
    }

    public void displayTransactions(){
        for (int i = 0; i < index; i++) {
            if (transactions[i] > 0) {
                System.out.println("Deposit: " + transactions[i]);
            }
            else {
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
