package ru.job4j.bank;

import org.junit.Test;
import java.util.List;
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
        bank.transferMoney("KZ00001", "AC00001", "KZ00002", "AC00001", 200);
        assertThat(acc1.getValue(), is(800.0));
        assertThat(acc2.getValue(), is(1200.0));
    }
}
