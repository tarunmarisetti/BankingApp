package springBoot.project.Banking_app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springBoot.project.Banking_app.dto.AccountDto;
import springBoot.project.Banking_app.entity.Account;
import springBoot.project.Banking_app.mapper.AccountMapper;
import springBoot.project.Banking_app.repository.AccountRepository;
import springBoot.project.Banking_app.service.AccountService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Does not Exist!"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Does not Exist!"));
        double total=account.getBalance()+amount;
        account.setBalance(total);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withDraw(Long id, double amount) {
        Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Does not Exist!"));
        if(account.getBalance()<amount){
            throw new RuntimeException("inSufficient funds");
        }
        double amountAfterWithdraw=account.getBalance()-amount;
        account.setBalance(amountAfterWithdraw);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accountList=accountRepository.findAll();
        return  accountList.stream().map(AccountMapper::mapToAccountDto).toList();
    }

    @Override
    public void deleteAccount(Long id) {
        Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Does not Exist!"));
        accountRepository.delete(account);
    }
}
