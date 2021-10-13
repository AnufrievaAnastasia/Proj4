package file;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static final String CSV_SEPARATOR  = "-";
    private static final String DATABASE_FILENAME = "database.csv";

    private static FileService instance;
    private BufferedWriter output;
    private BufferedReader input;

    private FileService() {}

    public static FileService getInstance() {
        if (instance == null) {
            instance = new FileService();
        }
        return instance;
    }

    public List<Account> read() throws IOException {
        String line;
        createFile();
        input = new BufferedReader(new FileReader(DATABASE_FILENAME));
        List<Account> result = new ArrayList<>();
        while ((line = input.readLine()) != null) {
            String[] data = line.split(",");
            result.add(new Account(data[0], data[1], data[2], data[3], Boolean.getBoolean(data[4])));
        }
        input.close();
        return result;
    }

    public void write(List<Account> accounts) throws IOException {
        output = new BufferedWriter(new FileWriter(DATABASE_FILENAME));
        for (Account account: accounts) {
            writeToCsv(account);
        }
        output.close();
    }

    private void writeToCsv(Account account) throws IOException {
        StringBuffer line = new StringBuffer();
        line.append(account.getName());
        line.append(CSV_SEPARATOR);
        line.append(account.getBirthdate());
        line.append(CSV_SEPARATOR);
        line.append(account.getEmail());
        line.append(CSV_SEPARATOR);
        line.append(account.getPassword());
        line.append(CSV_SEPARATOR);
        line.append(account.isBlocked());
        output.write(line.toString());
        output.newLine();
    }

    private void createFile() throws IOException {
        File file = new File("./database.csv");
        if(file.exists() == false) {
            file.createNewFile();
        }
    }
}

