package file;

import java.io.IOException;

public interface AccountManager {

    void register(Account account) throws IOException;
    Account login(String email, String password) throws IOException;
    void removeAccount(String email, String password) throws IOException;
}
