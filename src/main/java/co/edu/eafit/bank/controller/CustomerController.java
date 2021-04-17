package co.edu.eafit.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eafit.bank.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
		
}
