package ru.job4j.bank;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    @Test
    public void transferWhenAmountLessThenSumInAcc() {
        Bank bank = new Bank();
        User user1 = new User("Yuriy Litvinenko", "KZ00001");
        User user2 = new User("Petr Arsenev", "KZ00002");
        bank.addUser(user1);
        bank.addUser(user2);
        Account acc1 = new Account(1000, "AC00001");
        Account acc2 = new Account(1000, "AC00001");
        bank.addAccountToUser("KZ00001", acc1);
        bank.addAccountToUser("KZ00002", acc2);
        boolean result = bank.transferMoney("KZ00001", "AC00001", "KZ00002", "AC00001", 200);
        assertThat(result, is(true));
        assertThat(acc1.getValue(), is(800.0));
        assertThat(acc2.getValue(), is(1200.0));
    }

    @Test
    public void transferWhenAmountGreaterThenSumInAcc() {
        Bank bank = new Bank();
        User user1 = new User("Yuriy Litvinenko", "KZ00001");
        User user2 = new User("Petr Arsenev", "KZ00002");
        bank.addUser(user1);
        bank.addUser(user2);
        Account acc1 = new Account(1000, "AC00001");
        Account acc2 = new Account(1000, "AC00001");
        bank.addAccountToUser("KZ00001", acc1);
        bank.addAccountToUser("KZ00002", acc2);
        boolean result = bank.transferMoney("KZ00001", "AC00001", "KZ00002", "AC00001", 1200);
        assertThat(result, is(false));
    }

    @Test
    public void transferWhenSingleUserAccounts() {
        Bank bank = new Bank();
        User user1 = new User("Yuriy Litvinenko", "KZ00001");
        bank.addUser(user1);
        Account acc1 = new Account(1000, "AC00001");
        Account acc2 = new Account(1000, "AC00002");
        bank.addAccountToUser("KZ00001", acc1);
        bank.addAccountToUser("KZ00001", acc2);
        boolean result = bank.transferMoney("KZ00001", "AC00001", "KZ00001", "AC00002", 200);
        assertThat(result, is(true));
        assertThat(acc1.getValue(), is(800.0));
        assertThat(acc2.getValue(), is(1200.0));
    }

    @Test
    public void deleteUserAccount() {
        Bank bank = new Bank();
        User user = new User("Yuriy Litvinenko", "KZ00001");
        bank.addUser(user);
        Account acc1 = new Account(1000, "AC00001");
        Account acc2 = new Account(1000, "AC00002");
        bank.addAccountToUser("KZ00001", acc1);
        bank.addAccountToUser("KZ00001", acc2);
        bank.deleteAccountFromUser("KZ00001", acc1);
        Bank bankRes = new Bank();
        User userRes = new User("Yuriy Litvinenko", "KZ00001");
        bankRes.addUser(userRes);
        bankRes.addAccountToUser("KZ00001", acc2);
        assertThat(bankRes.getUserAccounts("KZ00001"), is(bank.getUserAccounts("KZ00001")));
    }

    @Test
    public void deleteUser() {
        Bank bank = new Bank();
        User user1 = new User("Yuriy Litvinenko", "KZ00001");
        User user2 = new User("Petr Arsenev", "KZ00002");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.deleteUser(user1);
        Bank bankRes = new Bank();
        bankRes.addUser(user2);
        assertThat(bankRes.getUsers(), is(bank.getUsers()));
    }
}
