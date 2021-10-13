package file;

public class AccountAlreadyExistsException extends RuntimeException{

    public AccountAlreadyExistsException() {
        super("Account already exist");
    }
}
