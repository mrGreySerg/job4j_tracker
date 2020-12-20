package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        Optional<User> user = this.findByPassport(passport);
        if (user.isPresent()) {
            List<Account> userAccounts = users.get(user.get());
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
                users.put(user.get(), userAccounts);
            }
        }
    }

    /**
     * Находит клиента по паспотру.
     * @param passport - номер паспорта.
     * @return - найденного клиента банка.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Находит счет (Account) по паспорту клиента и реквизитам счета.
     * @param passport - номер паспорта.
     * @param requisite - реквизиты счета.
     * @return - счет (Account).
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = this.findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get()).stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
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
        Account srcAccount = this.findByRequisite(srcPassport, srcRequisite).get();
        Account destAccount = this.findByRequisite(destPassport, destRequisite).get();
        if (srcAccount != null && destAccount != null
                && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            checkOperation = true;
        }
        return checkOperation;
    }

}
