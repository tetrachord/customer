package com.foo;

import com.foo.model.Customer;
import com.foo.service.CustomerRestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import java.io.File;
import java.util.Scanner;

@SpringBootApplication
public class CustomerApplication {

    @Autowired
    private CustomerRestClientService customerRestClientService;

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            Resource resource = ctx.getResource("classpath:customerDir/customers.csv");
            File csvFile = resource.getFile();

            try(Scanner scanner = new Scanner(csvFile)) {
                while (scanner.hasNextLine()) {
                    Customer customer = getRecord(scanner.nextLine());
                    customerRestClientService.postCustomer(customer);
                }
            }

        };
    }

    private Customer getRecord(String line) {

        String[] tokens = line.split(";");

        return new Customer(
                tokens[0],
                tokens[1],
                tokens[2],
                tokens[3],
                tokens[4],
                tokens[5],
                tokens[6],
                tokens[7]);
    }

}