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
        if (this.findByPassport(passport) != null) {
            User user = this.findByPassport(passport);
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
        if (checkTransfer(srcPassport, srcRequisite,
                destPassport, destRequisite, amount)) {
            this.offBalance(srcPassport, srcRequisite, amount);
            this.refillAccount(destPassport, destRequisite, amount);
            checkOperation = true;
        }
        return checkOperation;
    }

    /**
     * Списывает со счета клиента деньги.
     * @param srcPassport - данные паспорта клиента.
     * @param srcRequisite - реквизиты счета.
     * @param amount - сумма списания.
     */
    private void offBalance(String srcPassport,
                            String srcRequisite,
                            double amount) {
        User srcUser = this.findByPassport(srcPassport);
        List<Account> accountsSrcUser = users.get(srcUser);
        Account srcAccount = this.findByRequisite(srcPassport, srcRequisite);
        int indexSrcAccount = accountsSrcUser.indexOf(srcAccount);
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        accountsSrcUser.set(indexSrcAccount, srcAccount);
        users.put(srcUser, accountsSrcUser);
    }

    /**
     * Пополняет счет клиента.
     * @param destPassport - номер паспорта клиента.
     * @param destRequisite - реквизиты счета.
     * @param amount - сумма поступления.
     */
    private void refillAccount(String destPassport,
                               String destRequisite,
                               double amount) {
        User destUser = this.findByPassport(destPassport);
        List<Account> accountsDestUser = users.get(destUser);
        Account destAccount = this.findByRequisite(destPassport, destRequisite);
        int indexDestAccount = accountsDestUser.indexOf(destAccount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        accountsDestUser.set(indexDestAccount, destAccount);
        users.put(destUser, accountsDestUser);
    }

    /**
     * Проверяет возможность выполнения операции перевода со счета на счет.
     * @param srcPassport - номер паспорта отправителя.
     * @param srcRequisite - реквизиты счета отправителя.
     * @param destPassport - номер паспорта получателя.
     * @param destRequisite - реквизиты счета получателя.
     * @param amount - сумма перевода.
     * @return - результат проверки (можно или нет).
     */
    private boolean checkTransfer(String srcPassport,
                                  String srcRequisite,
                                  String destPassport,
                                  String destRequisite,
                                  double amount) {
        return this.findByRequisite(srcPassport, srcRequisite).getBalance() < amount
                || this.findByRequisite(srcPassport, srcRequisite) == null
                || this.findByRequisite(destPassport, destRequisite) == null
                ? false : true;
    }

}
