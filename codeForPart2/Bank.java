import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Bank {
    private Admin admin;
    private ArrayList<Customer> customers;

    public Bank(){
        admin = new Admin();
        admin.setUserName("admin");
        admin.setPIN(0);
        customers = new ArrayList<Customer>();
        this.loadCustomers();
        /*customers.add(new Customer());
        customers.get(0).setUserName("alice");
        customers.get(0).setPIN(1111);
        customers.get(0).getSavings().setBalance(1000);
        customers.get(0).getChecking().setBalance(1000);*/


    }
    public void main(){}
    public void loadSampleCustomers(){}
    public void loadCustomers(){
        try{
            FileInputStream file = new FileInputStream("Info.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            customers = (ArrayList<Customer>)in.readObject();
            in.close();
            file.close();
        }
        catch (Exception e){
            System.out.println("Failed Fetching");
        }

    }
    public void saveCustomers(){
        try {
            FileOutputStream file = new FileOutputStream("Info.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(customers);
            out.close();
            file.close();
        }
        catch(Exception e){
            System.err.println("Failed Saving");
        }
    }

    public void fullCustomerReport(){
        for (int i = 0; i < customers.size(); i++){
            System.out.println("User: " + customers.get(i).getReport());
        }
    }

    public void addUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("New Customer username? ");
        String inUserName = scan.next();
        System.out.println("New Customer PIN? ");
        String inPIN = scan.next();
        customers.add(new Customer());
        customers.getLast().setUserName(inUserName);
        customers.getLast().setPIN(Integer.parseInt(inPIN));
    }

    public void applyInterest(){
        for (int i = 0; i < customers.size(); i++){
            customers.get(i).getSavings().calcInterest();
        }
    }

    public void loginAsCustomer(){
        int userAccessed = -1;
        Scanner scan = new Scanner(System.in);
        System.out.print("\n{000000000000000000000}\nUsername: ");
        String UNinput = scan.next();
        System.out.print("PIN: ");
        String PINinput = scan.next();
        for (int i = customers.size()-1; i >= 0; i--) {
            if (customers.get(i).login(UNinput, PINinput)){
                System.out.println("\nLogin Successful. Welcome, " + customers.get(i).getUserName());
                userAccessed = i;
                break;
            }
        }
        if(userAccessed != -1){
            customers.get(userAccessed).start();
        }
        else {
            System.out.println("Username or Password is incorrect.");
        }
    }
    public String menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("[==---{ Bank Menu }---==]\n" +
                "0) exit\n" +
                "1) Admin Login\n" +
                "2) User Login\n");
        try{
            return scan.next();
        }
        catch(Exception e){
            System.err.println("Incorrect Entry Type");
        }
        return "No return given";
    }

    public void start(){
        boolean continueLoop = true;
        String input;
        while (continueLoop){
            input = this.menu().toLowerCase();
            switch (input){
                case "0":
                case "exit":
                    continueLoop = false;
                    saveCustomers();
                    break;
                case "1":
                case "admin":
                    this.startAdmin();
                    break;
                case "2":
                case "user":
                    loginAsCustomer();
                    break;
                default:
                    System.err.println("Invalid Entry");
            }
        }
    }

    public void startAdmin(){
        if(admin.login()){
            boolean continueOperations = true;
            while (continueOperations){
                switch(admin.menu().toLowerCase()){
                    case "0":
                    case "exit":
                        System.out.println("Exiting account");
                        continueOperations = false;
                        break;
                    case "1":
                    case "report":
                        this.fullCustomerReport();
                        break;
                    case "2":
                    case "add user":
                        this.addUser();
                        break;
                    case "3":
                    case "interest":
                    case "apply interest":
                        this.applyInterest();
                        break;
                    default:
                        System.err.println("Input not recognized.");
                        break;
                }
            }
        }
    }

}
