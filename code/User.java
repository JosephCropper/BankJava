public abstract class User implements HasMenu{
    private String userName;
    private String PIN;

    //i love ternary operators PLEASE let me have this its just an in-line if statement
    public boolean login(){
        return false;
    }

    public boolean login(String inUserName, String inPIN){
        /*System.out.println("inputted user name: " + inUserName);
        System.out.println("Username: " + getUserName());
        System.out.println("inputted PIN: " + inPIN);
        System.out.println("PIN: " + getPIN());*/
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
