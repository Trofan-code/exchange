package com.example.Exchange.persistance.repository;


import com.example.Exchange.persistance.entity.AccountEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntry, Long> {
}
