package co.edu.eafit.bank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eafit.bank.domain.Customer;
import co.edu.eafit.bank.dto.CustomerDTO;
import co.edu.eafit.bank.mapper.CustomerMapper;
import co.edu.eafit.bank.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> findById(@PathVariable("id") Integer id){
		
		Optional<Customer> customerOptional=customerService.findById(id);
		
		Customer customer=(customerOptional.isPresent()==true)?customerOptional.get():null;
		
		CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
		
		return ResponseEntity.ok().body(customerDTO);
	}
	
	@GetMapping()
	public ResponseEntity<List<CustomerDTO>> findAll(){
		List<Customer> customers=customerService.findAll();
		List<CustomerDTO> customerDTOs = customerMapper.customersToCustomersDTOs(customers);
		
		return ResponseEntity.ok().body(customerDTOs);
	}

	
		
}
