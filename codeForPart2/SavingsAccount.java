import java.io.*;

public class SavingsAccount extends CheckingAccount implements java.io.Serializable{
    private double interestRate = 1.05;

    public void setInterestRate(double inInterestRate){
        interestRate = inInterestRate;
    }

    public void getInterestRate(){
        System.out.println("Interest rate: " + interestRate);
    }

    public void calcInterest(){
        double newBal = getBalance() * interestRate;
        this.setBalance(newBal);
    }

    public void main(){
        this.start();
    }
}
