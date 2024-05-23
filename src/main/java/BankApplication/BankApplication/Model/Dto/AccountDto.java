package BankApplication.BankApplication.Model.Dto;

import BankApplication.BankApplication.Model.Domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountDto {

    private long account_id;

    private double balance;

}
