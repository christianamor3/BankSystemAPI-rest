package BankApplication.BankApplication.Model.Dto;

import BankApplication.BankApplication.Model.Domain.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private long user_id;
    private String name;
}
