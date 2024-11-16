package springBoot.project.Banking_app.service;

import springBoot.project.Banking_app.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id,double amount);

    AccountDto withDraw(Long id,double amount);
    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);
}
