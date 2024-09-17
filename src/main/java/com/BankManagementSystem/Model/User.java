package com.BankManagementSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@Component
public class User {
    private String realName;
    private String password;
    private String accountNumber;
    private double balance;
    private String username;

    public User(String realName, String password, String accountNumber, double balance) {
        this.realName = realName;
        this.password = password;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.username = accountNumber;
    }
}

