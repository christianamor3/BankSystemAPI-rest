package BankApplication.BankApplication.Model.Repository;

import BankApplication.BankApplication.Model.Domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
