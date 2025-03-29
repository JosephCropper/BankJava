import java.util.Scanner;

public class Admin extends User{
    public Admin(){}

    public String getReport(){return "why is this here";}
    public void start(){
    }

    public String menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("[==---{ Admin Menu }---==]\n" +
                "0) exit\n" +
                "1) Full Customer Report\n" +
                "2) Add User\n" +
                "3) Apply interest to savings accounts\n");
        try{
            return scan.next();
        }
        catch(Exception e){
            System.err.println("Incorrect Entry Type");
        }
        return "No return given";
    }

}
