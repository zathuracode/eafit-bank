package co.edu.eafit.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eafit.bank.dto.CustomerDTO;
import co.edu.eafit.bank.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> findById(@PathVariable("id") Integer id){
		return null;
	}
		
}
