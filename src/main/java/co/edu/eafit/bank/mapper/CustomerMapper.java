package co.edu.eafit.bank.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.eafit.bank.domain.Customer;
import co.edu.eafit.bank.dto.CustomerDTO;

@Mapper
public interface CustomerMapper {
	
	@Mapping(source ="documentType.dotyId", target = "dotyId" )
	public CustomerDTO customerToCustomerDTO(Customer customer);

}
