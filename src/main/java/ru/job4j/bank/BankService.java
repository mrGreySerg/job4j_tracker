package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс управляет счетами клиентов.
 * @author Kustrin Sergei.
 * @version 1.0.
 */
public class BankService {

    /**
     * Список клиентов с их счетами.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добаляет клиента в коллекцию users,
     * Создает пустой список счетов по умолчанию.
     * @param user - новый клиент.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Добавляет банковский счет (Account)
     * клиенту по данным паспорта.
     * @param passport - номер паспорта.
     * @param account - новый счет.
     */
    public void addAccount(String passport, Account account) {
        User user = this.findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
                users.put(user, userAccounts);
            }
        }
    }

    /**
     * Находит клиента по паспотру.
     * @param passport - номер паспорта.
     * @return - найденного клиента банка.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Находит счет (Account) по паспорту клиента и реквизитам счета.
     * @param passport - номер паспорта.
     * @param requisite - реквизиты счета.
     * @return - счет (Account).
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = this.findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            for (Account account : userAccounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Переводит деньги между счетами клиентов.
     * @param srcPassport - номер паспорта клиента отправителя.
     * @param srcRequisite - реквизиты счета отправителя.
     * @param destPassport - номер паспорта клиента получателя.
     * @param destRequisite - реквизиты счета получателя.
     * @param amount - сумма перевода.
     * @return - результат операции (успешно или нет).
     */
    public boolean transferMoney(String srcPassport,
                                 String srcRequisite,
                                 String destPassport,
                                 String destRequisite,
                                 double amount) {
        boolean checkOperation = false;
        Account srcAccount = this.findByRequisite(srcPassport, srcRequisite);
        Account destAccount = this.findByRequisite(destPassport, destRequisite);
        if (srcAccount != null || destAccount != null
                || srcAccount.getBalance() > amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            checkOperation = true;
        }
        return checkOperation;
    }

}
