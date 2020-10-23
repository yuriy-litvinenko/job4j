package ru.job4j.bank;

import java.util.*;

class Bank {
    private Map<User, List<Account>> base = new HashMap<>();

    void addUser(User user) {
        this.base.put(user, new ArrayList<>());
    }

    void deleteUser(User user) {
        this.base.remove(user);
    }

    Set<User> getUsers() {
        return base.keySet();
    }

    void addAccountToUser(String passport, Account account) {
        for (User user : base.keySet()) {
            if (user.getPassport().equals(passport)) {
                base.get(user).add(account);
            }
        }
    }

    void deleteAccountFromUser(String passport, Account account) {
        for (User user : base.keySet()) {
            if (user.getPassport().equals(passport)) {
                base.get(user).remove(account);
            }
        }
    }

    List<Account> getUserAccounts(String passport) {
        return base.keySet().stream().filter(p -> passport.equals(p.getPassport())).map(u -> base.get(u)).findFirst().orElse(null);
    }

    private Account getAccount(List<Account> accounts, String requisite) {
        Account result = null;
        if (accounts != null) {
            result = accounts.stream().filter(r -> requisite.equals(r.getRequisites())).findFirst().orElse(null);
        }
        return result;
    }

    boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account srcAcc = getAccount(getUserAccounts(srcPassport), srcRequisite);
        Account destAcc = getAccount(getUserAccounts(destPassport), destRequisite);
        if (srcAcc != null && destAcc != null) {
            result = srcAcc.transfer(destAcc, amount);
        }
        return result;
    }
}
