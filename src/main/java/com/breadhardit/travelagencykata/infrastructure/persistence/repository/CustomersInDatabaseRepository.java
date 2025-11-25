package com.breadhardit.travelagencykata.infrastructure.persistence.repository;

import com.breadhardit.travelagencykata.application.port.CustomersRepository;
import com.breadhardit.travelagencykata.domain.Customer;
import com.breadhardit.travelagencykata.infrastructure.persistence.entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Scope()
@RequiredArgsConstructor()
public class CustomersInDatabaseRepository implements CustomersRepository {

    private final CustomersJPARepository customersJPARepository;

    @Override
    public void saveCustomer(Customer customer) {
        customersJPARepository.save(createEntityByCustomer(customer));
    }

    @Override
    public Optional<Customer> getCustomerById(String id) {

        Optional<CustomerEntity> customerEntityOptional = customersJPARepository.findById(id);

        if(customerEntityOptional.isPresent()) {
            return createCustomerByEntity(customerEntityOptional.get());
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<Customer> getCustomerByPassport(String id) {

        Optional<CustomerEntity> customerEntityOptional = Optional.ofNullable(customersJPARepository.getByPassportNumber(id));

        if (customerEntityOptional.isPresent()) {
            return createCustomerByEntity(customerEntityOptional.get());
        } else {
            return Optional.empty();
        }
    }

    private CustomerEntity createEntityByCustomer (Customer customer) {

        CustomerEntity.CustomerEntityBuilder builder = CustomerEntity.builder();
        builder.name(customer.getName());
        builder.id(customer.getId());
        builder.passportNumber(customer.getPassportNumber());
        builder.birthDate(customer.getBirthDate());
        builder.enrollmentDate(customer.getEnrollmentDate());
        builder.surnames(customer.getSurnames());
        builder.active(customer.getActive());

        return builder.build();

    }

    private Optional<Customer> createCustomerByEntity (CustomerEntity customerEntity) {

        if(customerEntity == null) {
            return Optional.empty();
        }

        Customer.CustomerBuilder builder = Customer.builder();
        builder.name(customerEntity.getName());
        builder.id(customerEntity.getId());
        builder.passportNumber(customerEntity.getPassportNumber());
        builder.birthDate(customerEntity.getBirthDate());
        builder.enrollmentDate(customerEntity.getEnrollmentDate());
        builder.surnames(customerEntity.getSurnames());
        builder.active(customerEntity.getActive());

        return  Optional.of(builder.build());

    }
}
