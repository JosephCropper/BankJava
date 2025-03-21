import java.util.Scanner;
import java.util.ArrayList;
//ArrayLists: they're arrays but better, namely in resizability.
//I know what they are from previous java experience.


//heads up:
//i use "this." a lot in java. its a nervous habit that hasn't broken anything yet. if i feel like im gonna confuse something,
//and i throw it in, and it still works, im just keeping it. if given proper reason to stop, i will.
public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new Customer());
        users.get(0).setUserName("Alice");
        //Fun Fact! leading an integer with a "0" makes it OCTAL. interesting.
        users.get(0).setPIN(1115);

        boolean continueOperations = true;
        int accAccessed;

        while (continueOperations) {
            accAccessed = login(users);
            if (accAccessed != -1){
                users.get(accAccessed).start();
            }
        }


    }

    public static int login(ArrayList<User> database){
        Scanner scan = new Scanner(System.in);
        System.out.print("\n{000000000000000000000}\nUsername: ");
        String UNinput = scan.next();
        System.out.print("PIN: ");
        String PINinput = scan.next(); //i shouldve made this PINput (get it?)
        for (int i = database.size()-1; i >= 0; i--) {
            if (database.get(i).login(UNinput, PINinput)){
                System.out.println("\nLogin Successful. Welcome, " + database.get(i).getUserName());
                return i;
            }
        }
        System.out.println("Username or Password is incorrect.");
        return -1;
    }
}
