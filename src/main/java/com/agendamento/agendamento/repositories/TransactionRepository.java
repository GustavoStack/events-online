package com.agendamento.agendamento.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agendamento.agendamento.entity.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

}
