package file;

import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException {
        Account account = new Account("Петров Петр Петрович", "01.08.01", "asd@gmail.ru",
                "sweqwes@dsd.tu", false);
        AccountManager accountManager = new FileAccountManager();
        accountManager.register(account);
    }
}
