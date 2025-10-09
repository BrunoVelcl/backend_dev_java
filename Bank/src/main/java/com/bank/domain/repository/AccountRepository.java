package com.bank.domain.repository;

import com.bank.domain.entity.Account;

import java.math.BigDecimal;

public interface AccountRepository {
    public void otvoriRacun(String korisnickoIme, BigDecimal pocetniIznos);
    public void prenesiSredstva(Account posiljatelj, Account primatelj, BigDecimal iznos);
    public BigDecimal provjeriStanje(long id);
    public Account nadjiPoIdu(long id);
}
