package com.agendamento.agendamento.entity.exceptions;

public class TransactionDontAuthorizedException extends RuntimeException{
    public TransactionDontAuthorizedException(){
        super("A transação não é autorizada.");
    }

}
