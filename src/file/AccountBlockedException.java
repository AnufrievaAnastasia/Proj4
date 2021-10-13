package file;

public class AccountBlockedException extends RuntimeException {

    public AccountBlockedException() {
        super("Account is blocked");
    }
}