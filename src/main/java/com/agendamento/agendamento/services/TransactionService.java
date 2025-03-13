package com.agendamento.agendamento.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendamento.agendamento.dtos.TransactionDTO;
import com.agendamento.agendamento.entity.EventEntity;
import com.agendamento.agendamento.entity.Transaction;
import com.agendamento.agendamento.entity.UserEntity;
import com.agendamento.agendamento.entity.exceptions.EventNotFoundException;
import com.agendamento.agendamento.repositories.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private UserService userService;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private EventService eventService;

    public Transaction createTransaction(TransactionDTO transactionDTO){
        UserEntity sender = this.userService.getUserById(transactionDTO.senderId());
        UserEntity receiver = this.userService.getUserById(transactionDTO.receiverId());
        EventEntity event = this.eventService.findEventById(transactionDTO.eventId());


        System.out.println("senderId "+sender.getId());
        System.out.println("senderType "+sender.getUserType());
        System.out.println("receiverId "+receiver.getId());
        System.out.println("receiverType "+receiver.getUserType());

        if(event == null){
            throw new EventNotFoundException();
        }

        BigDecimal eventPrice = event.getPrice();

        userService.validateTransaction(sender);
        userService.validadeBalanceTransactional(sender, transactionDTO.value());

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(eventPrice);
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setEventId(event.getId());
        newTransaction.setTimeStamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(eventPrice));
        receiver.setBalance(receiver.getBalance().add(eventPrice));

        this.transactionRepository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);

        return newTransaction;
    }

    public List<Transaction> getTransactions(){
        return this.transactionRepository.findAll();
    }
}
