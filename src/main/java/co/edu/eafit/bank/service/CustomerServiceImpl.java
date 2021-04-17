package co.edu.eafit.bank.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eafit.bank.domain.Customer;
import co.edu.eafit.bank.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	Validator validator;

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Customer> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer save(Customer entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer update(Customer entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Customer entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(Customer entity) throws Exception {
		Set<ConstraintViolation<Customer>> constrainsViolations=validator.validate(entity);
		
		if(constrainsViolations.isEmpty()==false) {
			throw new ConstraintViolationException(constrainsViolations);
		}

	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
