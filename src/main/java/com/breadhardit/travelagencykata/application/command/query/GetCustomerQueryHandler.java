package com.breadhardit.travelagencykata.application.command.query;

import com.breadhardit.travelagencykata.application.port.CustomersRepository;
import com.breadhardit.travelagencykata.domain.Customer;
import org.flywaydb.core.internal.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCustomerQueryHandler {

    private final CustomersRepository customersRepository;

    public GetCustomerQueryHandler(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public Optional<Customer> handle(GetCustomerQuery query) {
        if (StringUtils.hasText(query.getId())) {
            return customersRepository.getCustomerById(query.getId());
        }
        if (StringUtils.hasText(query.getPassport())) {
            return customersRepository.getCustomerByPassport(query.getPassport());
        }
        return Optional.empty();
    }
}
