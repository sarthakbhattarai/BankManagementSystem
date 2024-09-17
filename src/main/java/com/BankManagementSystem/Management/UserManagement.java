package com.BankManagementSystem.Management;

import com.BankManagementSystem.Model.User;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserManagement {
    private Map<String, User> userMap = new HashMap<>();

    public boolean registerUser(String username, String realName, String password, String accountNumber) {
        if (userMap.containsKey(username)) {
            return false;
        }
        User user = new User(realName, password, accountNumber, 0.0);
        userMap.put(username, user);
        return true;
    }

    public User loginUser(String username, String password) {
        User user = userMap.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public boolean deleteUser(String username) {
        return userMap.remove(username) != null;
    }

    public User getUser(String username) {
        return userMap.get(username);
    }
}
