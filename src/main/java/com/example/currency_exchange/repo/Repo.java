package com.example.currency_exchange.repo;

import com.example.currency_exchange.entities.RateHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<RateHistoryEntity, Long> {

}
