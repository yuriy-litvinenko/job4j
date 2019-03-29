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

    public Set<User> getUsers() {
        return base.keySet();
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

    public List<Account> getUserAccounts(String passport) {
        return base.keySet().stream().filter(p -> passport.equals(p.getPassport())).map(u -> base.get(u)).findFirst().orElse(null);
    }

    public Account getAccount(List<Account> accounts, String requisite) {
        Account result = null;
        if (accounts != null) {
            result = accounts.stream().filter(r -> requisite.equals(r.getRequisites())).findFirst().orElse(null);
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account srcAcc = getAccount(getUserAccounts(srcPassport), srcRequisite);
        Account destAcc = getAccount(getUserAccounts(destPassport), destRequisite);
        if (srcAcc != null && destAcc != null) {
            result = srcAcc.transfer(destAcc, amount);
        }
        return result;
    }
}
