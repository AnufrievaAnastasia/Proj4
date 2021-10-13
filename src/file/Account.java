package file;
/*Каждый аккаунт должен быть представлен как объект класса file.Account, содержащий поля: ФИО, дата рождения,
email, пароль и поле blocked (типа boolean, по умолчанию значение false), указывающее, заблокирован ли пользователь.*/

import java.time.LocalDate;

public class Account {

    private String name;
    private String birthdate;
    private String email;
    private String password;
    private boolean blocked;

    public Account(String name, String birthdate, String email, String password, boolean blocked) {
        this.name = name;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
        this.blocked = blocked;

    }

    public String getName() {
        return this.name;
    }

    public void setName(long id) {
        this.name = name;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setName(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}