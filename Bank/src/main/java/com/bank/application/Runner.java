package com.bank.application;

import com.bank.domain.repository.AccountRepository;
import com.bank.infrastructure.AccountRepositoryImpl;

import java.math.BigDecimal;

public class Runner {
    public  void run(){
        AccountRepository ar = new AccountRepositoryImpl();

        ar.prenesiSredstva(ar.nadjiPoIdu(1), ar.nadjiPoIdu(3), BigDecimal.valueOf(7000));



    }

}
