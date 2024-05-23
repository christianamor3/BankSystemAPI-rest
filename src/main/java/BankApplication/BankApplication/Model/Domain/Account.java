package BankApplication.BankApplication.Model.Domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long account_id;

    @Column(name="Balance")
    private double balance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void addingMoney(double money) {
        balance += money;
    }

    public void substractingMoney(double money) {
        balance -= money;
    }

}
