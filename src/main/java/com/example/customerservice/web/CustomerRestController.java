package com.example.customerservice.web;

import com.example.customerservice.Dao.entities.Customer;
import com.example.customerservice.Dao.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Customers")
public class CustomerRestController {
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/listCustomers")
    public List<Customer> customerList() {
        return customerRepository.findAll();
    }
    @GetMapping("/{id}")
    public Customer customerById(@PathVariable Long id) {
        return customerRepository.findById(id).orElse(null);
    }
    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
}
