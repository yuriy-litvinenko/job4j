package ru.job4j.bank;

import java.util.*;

public class Bank {
    private Map<User, List<Account>> base = new HashMap<>();

    public void addUser(User user) {
        this.base.put(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.base.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        for (User user : base.keySet()) {
            if (user.getPassport().equals(passport)) {
                base.get(user).add(account);
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (User user : base.keySet()) {
            if (user.getPassport().equals(passport)) {
                base.get(user).remove(account);
            }
        }
    }

    public List<Account> getUserAccounts (String passport) {
        List<Account> result = null;
        for (User user : base.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = base.get(user);
            }
        }
        return result;
    }

    public Account getAccount (List<Account> accounts, String requisite) {
        Account result = null;
        for (Account account : accounts) {
            if (account.getRequisites().equals(requisite)) {
                result = account;
            }
        }
        return result;
    }

    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean result;
        Account srcAcc = getAccount(getUserAccounts(srcPassport), srcRequisite);
        Account destAcc = getAccount(getUserAccounts(destPassport), destRequisite);
        result = srcAcc.transfer(destAcc, amount);
        return result;
    }
}
