package BankApplication.BankApplication.Model.Service.Interfaces;

import BankApplication.BankApplication.Model.Domain.Account;
import BankApplication.BankApplication.Model.Dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto creatingAccount(long userid, double money);

    AccountDto findById (long userId, long accountId);

    List<AccountDto> findAllAccountsByPlayer (long userId);

    String deleteAccountByUserIdAndAccountId (long userId, long id);

    String deleteAllAccountsByPlayer (long userId);

    AccountDto addMoney (long userId, long accountId, double money);

    AccountDto substractMoney (long userId, long accountId, double money);

}
