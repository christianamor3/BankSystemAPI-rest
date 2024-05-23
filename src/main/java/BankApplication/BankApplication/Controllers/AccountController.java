package BankApplication.BankApplication.Controllers;

import BankApplication.BankApplication.Model.Domain.Account;
import BankApplication.BankApplication.Model.Dto.AccountDto;
import BankApplication.BankApplication.Model.Service.Interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Double.parseDouble;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create/{userId}")
    public ResponseEntity<AccountDto> creatingAccount(@PathVariable long userId, @RequestParam(defaultValue = "0") String money) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.creatingAccount(userId, parseDouble(money)));
    }

    @GetMapping("/find/{userId}/{accountId}")
    public ResponseEntity<AccountDto> findByUserIdAndAccountId(@PathVariable long userId, @PathVariable long accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(accountService.findById(userId, accountId));
    }

    @GetMapping("/findAll/{userId}")
    public ResponseEntity<List<AccountDto>> findAllAccountsByPlayer(@PathVariable long userId){
        return ResponseEntity.ok(accountService.findAllAccountsByPlayer(userId));
    }

    @DeleteMapping("/delete/{userId}/{accountId}")
    public ResponseEntity<String> deleteAccountByUserIdAndAccountId(@PathVariable long userId, @PathVariable long accountId){
        return ResponseEntity.ok(accountService.deleteAccountByUserIdAndAccountId(userId, accountId));
    }
    @DeleteMapping("/deleteAll/{userId}")
    public ResponseEntity<String> deleteAllAccountsByPlayer(@PathVariable long userId){
        return ResponseEntity.ok(accountService.deleteAllAccountsByPlayer(userId));
    }

    @PutMapping("/addMoney/{userId}/{accountId}")
    public ResponseEntity<AccountDto> addMoney(@PathVariable long userId, @PathVariable long accountId, @RequestParam(defaultValue = "0") String money){
        return ResponseEntity.ok(accountService.addMoney(userId, accountId, parseDouble(money)));
    }
    @PutMapping("/substractMoney/{userId}/{accountId}")
    public ResponseEntity<AccountDto> substractMoney(@PathVariable long userId, @PathVariable long accountId, @RequestParam(defaultValue = "0") String money){
        return ResponseEntity.ok(accountService.substractMoney(userId, accountId, parseDouble(money)));
    }


}
