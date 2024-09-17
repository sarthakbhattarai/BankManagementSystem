package com.BankManagementSystem;

import com.BankManagementSystem.Management.BankManagementSystem;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BankManagementSystemApplication {

	public static void main(String[] args) {
		 ConfigurableApplicationContext contxt= SpringApplication.run(BankManagementSystemApplication.class, args);
	}

}
