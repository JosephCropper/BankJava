import java.util.Scanner;
import java.io.*;

public abstract class User implements HasMenu, java.io.Serializable{
    private String userName;
    private String PIN;

    //i love ternary operators PLEASE let me have this it's just an in-line if statement
    public boolean login(){
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter Username:");
            String inUserName = scan.next();
            System.out.println("Enter PIN: ");
            String inPIN = scan.next();
            return (inUserName.compareTo(getUserName()) == 0 &&
                    inPIN.compareTo(getPIN()) == 0);
        }
        catch(Exception e){
            System.err.println("Incorrect Entry type");
        }
        System.err.println("Incorrect User or PIN");
        return false;
    }

    public boolean login(String inUserName, String inPIN){

        return (inUserName.compareTo(getUserName()) == 0 &&
                inPIN.compareTo(getPIN()) == 0);
    }

    public void setUserName(String newUserName){
        userName = newUserName;
    }

    public String getUserName(){
        return userName;
    }

    public void setPIN(int inPIN){
        //knew you wanted something with the inline command, couldn't remember what exactly
        //you used and couldn't find anything online, using simple String formatting for now
        PIN = (inPIN >= 0 && inPIN <= 9999)?
                //inPIN is not negative
                String.format("%04d", inPIN):
                //inPIN is negative and invalid
                "OOB";
    }

    public String getPIN(){
        return PIN;
    }

    public abstract String getReport();


}
