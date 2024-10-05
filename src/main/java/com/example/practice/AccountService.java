package com.example.practice;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This service return account detail according to accountId
 * Implement cache inside service to make it faster
 */
@Service
public class AccountService {

    List<Long> accountIds = new ArrayList<>();
    List<Account> accounts = new ArrayList<>();
    Map<Long, Account> map = new HashMap<>();

    /**
     * @return account detail of this accountId
     */
    public Account getAccountById1(long accountId) {
        Account account = new Account();
        if (!accountIds.contains(accountId)) {
            accountIds.add(accountId);
            account = fetchAccountFromRemoteServer(accountId);
            accounts.add(account);
        } else {
            account = accounts.stream().filter(account1 -> account1.getAccountId().equals(accountId)).findFirst().get();
//            account = accounts.stream().anyMatch();
        }
        return account;
    }

    public Account getAccountById(long accountId) {
        Account account = new Account();
        if (map.containsKey(accountId)) {
            return map.get(accountId);
        } else {
            account = fetchAccountFromRemoteServer(accountId);
            map.put(accountId, account);
        }

        return account;
    }

    /**
     * Call remote server to retrieve account detail of given id
     */
    private Account fetchAccountFromRemoteServer(long accountId) {
        // assume there is code send http request and get http response
        // no need to write any code here
        return null;
    }

    public List<Account> fetchAccount(List<Account> accountList, List<Long> accountIds) {
        List<Account> accounts = new ArrayList<>();
        Set<Long> ids = accountList.stream().map(Account::getAccountId).collect(Collectors.toSet());
//        Map<Long, String> map = accountList.stream().collect(Collectors.toMap(Map.Entry.getKey, Map.Entry::getValue, (e1, e2)-> e1.getAccountId(), LinkedHashMap::new));

        accountList.stream().forEach(account -> {
            if (accountIds.contains(account.getAccountId())) {
                accounts.add(account);
            }
        });

        return accounts;
    }


}