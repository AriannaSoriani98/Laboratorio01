package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount implements BankAccount {

    private double balance;
    private final AccountHolder holder;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder,balance);
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += amount;
            this.balance = this.balance;
        }
    }

    @Override
    public void withdraw(final int usrID, final double amount) {
        if (checkUser(usrID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
        }
    }


    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount;
    }


    protected boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }

    public void depositWithAtm(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += amount;
            this.balance -= 1;
        }
    }

    public void withdrawWithAtm(final int usrID, final double amount) {
        if (checkUser(usrID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
            this.balance -=1;
        }
    }
}
