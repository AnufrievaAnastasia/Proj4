package file;

import java.util.HashMap;

public class FailedLoginCounter {
    private static FailedLoginCounter instance;
    private final HashMap<String, Integer> failedCounterMap = new HashMap<>();

    private FailedLoginCounter() {}

    public static FailedLoginCounter getInstance() {
        if (instance == null) {
            instance = new FailedLoginCounter();
        }
        return instance;
    }

    public int failedLogin(String email) {
        if (failedCounterMap.containsKey(email) == false) {
            failedCounterMap.put(email, 1);
        } else {
            failedCounterMap.put(email, failedCounterMap.get(email) + 1);
        }

        return failedCounterMap.get(email);
    }

    public void successLogin(String email) {
        failedCounterMap.put(email, 0);
    }
}


