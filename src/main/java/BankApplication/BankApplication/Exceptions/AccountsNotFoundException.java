package BankApplication.BankApplication.Exceptions;

public class AccountsNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AccountsNotFoundException(String mensaje) {
        super(mensaje);
    }
}
