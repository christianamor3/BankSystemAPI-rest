package BankApplication.BankApplication.Model.Service.Impl;

import BankApplication.BankApplication.Exceptions.AccountsNotFoundException;
import BankApplication.BankApplication.Model.Domain.Account;
import BankApplication.BankApplication.Model.Domain.User;
import BankApplication.BankApplication.Model.Dto.AccountDto;
import BankApplication.BankApplication.Model.Repository.AccountRepository;
import BankApplication.BankApplication.Model.Repository.UserRepository;
import BankApplication.BankApplication.Model.Service.Interfaces.AccountService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    AccountRepository accountRepo;

    @Autowired
    UserRepository userRepo;

    @Override
    public AccountDto creatingAccount(long userId, double money) {
        Optional<User> user = userRepo.findById(userId);

        if (user.isEmpty()){
            throw new EntityNotFoundException("User not found");
        } else {

            Account account = new Account();
            account.setBalance(money);
            account.setUser(user.get());

            user.get().addingAccount(account);

            userRepo.save(user.get());
            return toDto(accountRepo.save(account));
        }
    }

    @Override
    public AccountDto findById(long userId, long accountId) {
        Optional<User> user = userRepo.findById(userId);

        if (user.isEmpty()){
            throw new EntityNotFoundException("User not found");
        } else {
           Optional<Account> account = accountRepo.findById(accountId);

            if (account.isEmpty()){
                throw new EntityNotFoundException("Account not found");
            } else {
                return toDto(account.get());
            }
        }
    }

    @Override
    public List<AccountDto> findAllAccountsByPlayer(long userId) {
        Optional<User> user = userRepo.findById(userId);

        if (user.isEmpty()) {
            throw new EntityNotFoundException("User not found");
        } else {
            List<Account> accountList = user.get().getAccounts();

            if (accountList.isEmpty() || accountList.size()==0){
                throw new AccountsNotFoundException("Accounts not found");
            } else {
                return accountList.stream().map(this::toDto).toList();
            }

        }
    }

    @Override
    public String deleteAccountByUserIdAndAccountId(long userId, long accountId) {
        Optional<User> user = userRepo.findById(userId);

        if (user.isEmpty()){
            throw new EntityNotFoundException("User not found");
        } else {
            accountRepo.deleteById(accountId);
            return "Se ha eliminado la partida correctamente";
        }
    }

    @Override
    public String deleteAllAccountsByPlayer(long userId) {
        Optional<User> user = userRepo.findById(userId);

        List<Account> accountList = user.get().getAccounts();

        if (accountList.isEmpty() || accountList.size()==0){
            throw new AccountsNotFoundException("Accounts not found");
        } else {
            accountRepo.deleteAll(accountList);
            return "Se han eliminado todas las partidas del jugador";
        }
    }

    @Override
    public AccountDto addMoney(long userId, long accountId, double money) {

        Optional<User> user = userRepo.findById(userId);

        if (user.isEmpty()) {
            throw new EntityNotFoundException("User not found");
        } else {

            Optional<Account> account = accountRepo.findById(accountId);

            if (account.isEmpty()) {
                throw new EntityNotFoundException("Account not found");
            } else {
                account.get().addingMoney(money);
                return toDto(accountRepo.save(account.get()));
            }
        }

    }

        @Override
        public AccountDto substractMoney (long userId, long accountId, double money){

            Optional<User> user = userRepo.findById(userId);

            if (user.isEmpty()) {
                throw new EntityNotFoundException("User not found");
            } else {

                Optional<Account> account = accountRepo.findById(accountId);

                if (account.isEmpty()) {
                    throw new EntityNotFoundException("Account not found");
                } else {
                    account.get().substractingMoney(money);
                    return toDto(accountRepo.save(account.get()));
                }
            }

        }

        AccountDto toDto(Account account){

        AccountDto accountDto = new AccountDto();

        accountDto.setAccount_id(account.getAccount_id());
        accountDto.setBalance(account.getBalance());

        return accountDto;

        }


    }
