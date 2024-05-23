package BankApplication.BankApplication.Model.Domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "Users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long user_id;

    @Column (name = "Name")
    private String name;

    private String password;

    @Column (name = "Accounts")
    @OneToMany (mappedBy = "user")
    private List<Account> accounts;

    public void addingAccount(Account account) {
        if (accounts==null) {
            accounts = new ArrayList<>();
        }
        accounts.add(account);
    }


}
