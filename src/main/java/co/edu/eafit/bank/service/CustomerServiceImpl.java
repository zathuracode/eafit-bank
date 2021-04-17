package co.edu.eafit.bank.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.eafit.bank.domain.Customer;
import co.edu.eafit.bank.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	Validator validator;
	
	@Override
	public void validate(Customer entity) throws Exception {
		Set<ConstraintViolation<Customer>> constrainsViolations=validator.validate(entity);
		
		if(constrainsViolations.isEmpty()==false) {
			throw new ConstraintViolationException(constrainsViolations);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Customer> findById(Integer id) {
		return customerRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public Customer save(Customer entity) throws Exception {
		
		if(entity==null) {
			throw new Exception("El customer es nulo");
		}
		
		validate(entity);
		
		if(customerRepository.existsById(entity.getCustId())==true){
			throw new Exception("El customer ya existe");
		}
		
		return customerRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public Customer update(Customer entity) throws Exception {
		if(entity==null) {
			throw new Exception("El customer es nulo");
		}
		
		validate(entity);
		
		if(customerRepository.existsById(entity.getCustId())==false){
			throw new Exception("El customer no existe");
		}
		
		return customerRepository.save(entity);
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
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
