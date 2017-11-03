package in.ravikalla.cloudBank.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import in.ravikalla.cloudBank.domain.PrimaryTransaction;

public interface PrimaryTransactionDao extends CrudRepository<PrimaryTransaction, Long> {

    List<PrimaryTransaction> findAll();
}
