import java.util.Scanner;

public class Customer extends User{
    private CheckingAccount checking;
    private SavingsAccount savings;

    public void main(){

    }

    public Customer(){
    }

    public void start(){
        boolean continueOperations = true;
        while (continueOperations){
            switch(this.menu().toLowerCase()){
                case "0":
                case "exit":
                    System.out.println("Exiting account");
                    continueOperations = false;
                    break;
                case "1":
                case "checking":
                    if (checking == null){
                        System.out.println("No Checking account detected. Create Checking account? Y/N");
                        Scanner scan = new Scanner(System.in);
                        String input = scan.next();
                        try{
                            switch (input.toUpperCase()){
                                case "Y":
                                    checking = new CheckingAccount(); // could add down payment option
                                    System.out.println("Checking Account created");
                                    break;
                                default:
                                    System.err.println("Input not recognized");
                                case "N":
                                    break;
                            }
                        }
                        catch (Exception e){
                            System.err.println("Incorrect input type");
                        }
                    }
                    else{
                        this.checking.start();
                    }
                    break;
                case "2":
                case "savings":
                    if (savings == null){
                        System.out.println("No Savings account detected. Create Savings account? Y/N");
                        Scanner scan = new Scanner(System.in);
                        String input = scan.next();
                        try{
                            switch (input.toUpperCase()){
                                case "Y":
                                    savings = new SavingsAccount(); // could add down payment option
                                    System.out.println("Savings Account created");
                                    break;
                                default:
                                    System.err.println("Input not recognized");
                                case "N":
                                    break;
                            }
                        }
                        catch (Exception e){
                            System.err.println("Incorrect input type");
                        }
                    }
                    else{
                        this.savings.start();
                    }
                    break;
                case "3":
                case "pin":
                case "change":
                case "change pin":
                    this.changePIN();
                    break;
                default:
                    System.err.println("Input not recognized.");
                    break;
            }
        }
    }

    public String menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("[==---{ Customer Menu }---==]\n" +
                "0) exit\n" +
                "1) manage checking account\n" +
                "2) manage savings account\n" +
                "3) change PIN\n");
        try{
            return scan.next();
        }
        catch(Exception e){
            System.err.println("Incorrect Entry Type");
        }
        return "No return given";
    }

    public void changePIN(){
        System.out.println("what would you like to change your PIN to? ");
        Scanner scan = new Scanner(System.in);
        try{
            int tempPIN = Integer.parseInt(this.getPIN());
            this.setPIN(scan.nextInt());
            if (this.getPIN().compareTo("OOB") == 0){
                this.setPIN(tempPIN);
                System.err.println("Issue changing pin; Reverted to most recent accepted PIN");
            }
            else{
                System.out.println("PIN successfully changed to: " + this.getPIN());
            }
        }
        catch (Exception e){
            System.err.println("Incorrect input type");
        }
    }

    public String getReport(){
        return "No return String";
    }

}
