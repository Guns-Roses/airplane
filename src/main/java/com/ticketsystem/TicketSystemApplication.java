package com.ticketsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ticketsystem.dao")
public class TicketSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketSystemApplication.class, args);
	}
}
