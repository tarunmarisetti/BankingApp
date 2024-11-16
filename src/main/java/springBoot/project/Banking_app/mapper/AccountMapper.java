package springBoot.project.Banking_app.mapper;

import springBoot.project.Banking_app.dto.AccountDto;
import springBoot.project.Banking_app.entity.Account;

public class AccountMapper {
//    this method is for normal DTO definition
//    public static Account mapToAccount(AccountDto accountDto) {
//        Account account = new Account(
//                accountDto.getId(),
//                accountDto.getAccountHolderName(),
//                accountDto.getBalance()
//        );
//        return account;
//    }

//    this method is for record usage in dto
public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account(
                accountDto.id(),
                accountDto.accountHolderName(),
                accountDto.balance()
        );
        return account;
    }


    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto=new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto;
    }
}
