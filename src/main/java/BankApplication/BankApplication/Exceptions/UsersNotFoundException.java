package BankApplication.BankApplication.Exceptions;

public class UsersNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UsersNotFoundException(String mensaje) {
        super(mensaje);
    }
}
