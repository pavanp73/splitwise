package com.lld.splitwise;

import com.lld.splitwise.commands.CommandExecutor;
import com.lld.splitwise.commands.SettleUpUserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication {

	@Autowired
	private static CommandExecutor commandExecutor;
	@Autowired
	private static SettleUpUserCommand settleUpUserCommand;

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
		commandExecutor.addCommand(settleUpUserCommand);

		Scanner scanner = new Scanner(System.in);
		while(true) {
			String input = scanner.next();
			commandExecutor.execute(input);
		}
	}

}
