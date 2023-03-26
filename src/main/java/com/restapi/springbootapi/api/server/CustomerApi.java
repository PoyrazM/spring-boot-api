package com.restapi.springbootapi.api.server;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restapi.springbootapi.entity.Customer;
import com.restapi.springbootapi.repository.ICustomerRepository;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@Data
@RequestMapping(value = "api/customers")
@RestController
public class CustomerApi {

    private final ICustomerRepository customerRepository;

    @GetMapping("/")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    record CustomerRequest(String name, String email, String password){}

    @PostMapping(value = "/create")
    public void addCustomer(@RequestBody CustomerRequest newCustomerRequest) {
        Customer customer = new Customer();
        customer.setName(newCustomerRequest.name());
        customer.setEmail(newCustomerRequest.email());
        customer.setPassword(newCustomerRequest.password());
        customerRepository.save(customer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
    }

    @PutMapping("/{customerId}")
    public void updateCustomer(@PathVariable("customerId") Integer id, @RequestBody CustomerRequest updateCustomerRequest) {
        Customer customer = customerRepository.getReferenceById(id);
        customer.setPassword(updateCustomerRequest.password());
        customerRepository.save(customer);
    }

}
