package in.ravikalla.cloudBank.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import in.ravikalla.cloudBank.domain.SavingsTransaction;

public interface SavingsTransactionDao extends CrudRepository<SavingsTransaction, Long> {

    List<SavingsTransaction> findAll();
}

