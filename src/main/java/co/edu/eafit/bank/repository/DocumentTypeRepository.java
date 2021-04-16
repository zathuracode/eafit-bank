package co.edu.eafit.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.eafit.bank.domain.DocumentType;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Integer> {

}
