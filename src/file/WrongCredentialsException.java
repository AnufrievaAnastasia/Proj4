package file;

public class WrongCredentialsException extends RuntimeException {

    public WrongCredentialsException() {
        super("Wrong email/password");
    }
}
