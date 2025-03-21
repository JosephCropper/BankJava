import java.util.Scanner;

public class CheckingAccount implements HasMenu {
    private double balance;

    public void CheckingAccount(){
        balance = 0.0;
    }

    public void CheckingAccount(double inBalance){
        balance = inBalance;
    }

    public void main(){
    }

    public String menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("[==---{ Menu }---==]\n " +
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
                    System.out.println("Your balance is: $" + getBalanceString());
                    break;
                case "2":
                case "deposit":



            }
           //---!--- add break condition
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

    }

    private double getDouble(){
        Scanner scan = new Scanner(System.in);
        return 0.0;
    }

    public void makeDeposit(){

    }

    public void makeWithDrawal(){

    }




}
