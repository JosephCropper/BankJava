import java.util.Scanner;
import java.io.*;

public class CheckingAccount implements HasMenu, java.io.Serializable {
    private double balance;

    public void CheckingAccount(){
        this.setBalance(0.0);
    }

    public void CheckingAccount(double inBalance){
        this.setBalance(inBalance);
    }

    public void main(){
        this.start();
    }

    public String menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("[==---{ Account Menu }---==]\n" +
                "0) exit\n" +
                "1) check balance\n" +
                "2) make a deposit\n" +
                "3) make a withdrawal\n");
        try{
            return scan.next();
        }
        catch(Exception e){
            System.err.println("Incorrect Entry Type");
        }
        return "No return given";
    }

    public void start(){
        //assuming this should return void like in the interface
        boolean continueLoop = true;
        String input;
        while (continueLoop){
            input = this.menu().toLowerCase();
            switch (input){
                case "0":
                case "exit":
                    continueLoop = false;
                    break;
                case "1":
                case "balance":
                    this.checkBalance();
                    break;
                case "2":
                case "deposit":
                    this.makeDeposit();
                    break;
                case "3":
                case "withdrawal":
                    this.makeWithdrawal();
                    break;
                default:
                    System.err.println("Invalid Entry");
            }
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getBalanceString(){
        return (balance + "");
    }

    public void setBalance(double inBalance){
        balance = inBalance;
    }

    public void checkBalance(){
        System.out.println("Your Balance: $" + getBalanceString());
    }

    private double getDouble(){
        Scanner scan = new Scanner(System.in);
        try{
            return scan.nextDouble();
        }
        catch (Exception e){
            System.err.println("Incorrect Input Type");
        }
        return 0.0;
    }

    public void makeDeposit(){
        System.out.println("\nDeposit amount:");
        double inputAmt = this.getDouble();
        if (inputAmt > 0){
            balance += inputAmt;
            System.out.println(inputAmt + " $ added to account\n");
        }
        else{
            System.err.println("Input below or equal to zero");
        }
    }

    public void makeWithdrawal(){
        System.out.println("\nWithdrawal amount:");
        double inputAmt = this.getDouble();
        if (inputAmt > 0){
            balance -= inputAmt;
            System.out.println(inputAmt + " $ subtracted from account\n");
        }
        else{
            System.err.println("Input below or equal to zero");
        }
    }




}
