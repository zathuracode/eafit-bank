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
import co.edu.eafit.bank.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> findById(@PathVariable("id") Integer id){
		
		Optional<Customer> customerOptional=customerService.findById(id);
		
		Customer customer=(customerOptional.isPresent()==true)?customerOptional.get():null;
		
		CustomerDTO customerDTO = customerToCustomerDTO(customer);
		
		return ResponseEntity.ok().body(customerDTO);
	}
	
	@GetMapping()
	public ResponseEntity<List<CustomerDTO>> findAll(){
		List<Customer> customers=customerService.findAll();
		List<CustomerDTO> customerDTOs = customersToCustomersDTOs(customers);
		
		return ResponseEntity.ok().body(customerDTOs);
	}

	private List<CustomerDTO> customersToCustomersDTOs(List<Customer> customers) {
		List<CustomerDTO> customerDTOs=new ArrayList<>(customers.size());
		
		for (Customer customer : customers) {
			CustomerDTO customerDTO=customerToCustomerDTO(customer);
			customerDTOs.add(customerDTO);
		}
		return customerDTOs;
	}

	private CustomerDTO customerToCustomerDTO(Customer customer) {
		
		if(customer==null)
			return null;
		
		CustomerDTO customerDTO=new CustomerDTO();
		customerDTO.setAddress(customer.getAddress());
		customerDTO.setCustId(customer.getCustId());
		customerDTO.setDotyId(customer.getDocumentType().getDotyId());
		customerDTO.setEmail(customer.getEmail());
		customerDTO.setEnable(customer.getEnable());
		customerDTO.setName(customer.getName());
		customerDTO.setPhone(customer.getPhone());
		customerDTO.setToken(customer.getToken());
		return customerDTO;
	}
		
}
