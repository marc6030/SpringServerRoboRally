package com.example.springboot_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot_example.view.IpAddressWindow;

@SpringBootApplication
public class SpringbootExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootExampleApplication.class, args);
		IpAddressWindow.openWindow();
	}

}
