public class SavingsAccount extends CheckingAccount{
    private double interestRate;

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
