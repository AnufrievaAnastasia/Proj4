package file;

import java.io.IOException;
import java.util.List;

public class FileAccountManager implements AccountManager{

    @Override
    public Account login(String email, String password) throws IOException {
        List<Account> accountList = FileService.getInstance().read();
        //проверка на блокировку//
        for (Account account: accountList) {
            if (account.getEmail().equals(email) && account.getPassword().equals(password)) {
                if (account.isBlocked () == true) {
                    FailedLoginCounter.getInstance().successLogin(email);
                    return account;
                }
                throw new AccountBlockedException();
            }
        }
        if (FailedLoginCounter.getInstance().failedLogin(email) == 5) {
            for (Account account: accountList) {
                if (account.getEmail() == (email)) {
                    account.setBlocked(true);
                }
            }
        }
        throw new WrongCredentialsException();
    }

    @Override
    public void register(Account account) throws IOException {
        List<Account> accountList = FileService.getInstance().read();
        if (accountList.stream().anyMatch(account1 -> account1.getEmail().equals(account.getEmail()))) {
            throw new AccountAlreadyExistsException();
        }
        accountList.add(account);
        FileService.getInstance().write(accountList);
    }


    @Override
    public void removeAccount(String email, String password) throws IOException {
        List<Account> accountList = FileService.getInstance().read();
        Account accountToBlock = null;
        for (Account account: accountList) {
            if (account.getEmail().equals(email) && account.getPassword().equals(password)) {
                accountToBlock = account;
                break;
            }
        }
        if (accountToBlock != null) {
            accountList.remove(accountToBlock);
            FileService.getInstance().write(accountList);
        } else {
            throw new WrongCredentialsException();
        }
    }
}
