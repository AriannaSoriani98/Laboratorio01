import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBankAccountWithAtmTest {

    private AccountHolder accountHolder;
    private SimpleBankAccountWithAtm bankAccount;

    @BeforeEach
    void setUp() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.deposit(2, 50);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(30, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(2, 70);
        assertEquals(100, bankAccount.getBalance());
    }
    
    @Test
    void testDepositWithAtm(){
        bankAccount.depositWithAtm(accountHolder.getId(), 100);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithAtm() {
        bankAccount.depositWithAtm(accountHolder.getId(), 100);
        bankAccount.withdrawWithAtm(accountHolder.getId(), 70);
        assertEquals(28, bankAccount.getBalance());
    }

    @Test
    void testWrongDepositWithAtm() {
        bankAccount.depositWithAtm(accountHolder.getId(), 100);
        bankAccount.depositWithAtm(2, 50);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdrawWithAtm() {
        bankAccount.depositWithAtm(accountHolder.getId(), 100);
        bankAccount.withdrawWithAtm(2, 70);
        assertEquals(99, bankAccount.getBalance());
    }

}