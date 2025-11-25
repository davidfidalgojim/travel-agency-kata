package com.breadhardit.travelagencykata.application.command.query;

import com.breadhardit.travelagencykata.application.command.command.CreateCustomerCommand;
import com.breadhardit.travelagencykata.application.port.CustomersRepository;
import com.breadhardit.travelagencykata.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateCustomerCommandHandler {

    private final CustomersRepository customersRepository;

    public CreateCustomerCommandHandler(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public String handle(CreateCustomerCommand command) {
        String id = UUID.randomUUID().toString();

        Customer customer = Customer.builder()
                .id(id)
                .name(command.getName())
                .surnames(command.getSurnames())
                .birthDate(command.getBirthDate())
                .passportNumber(command.getPassportNumber())
                .build();

        customersRepository.saveCustomer(customer);
        return customer.getId();
    }
}
