package com.vjezba17.domain.entity;

public enum TransactionIsolationLevel {
    READ_UNCOMMITTED(java.sql.Connection.TRANSACTION_READ_UNCOMMITTED),
    READ_COMMITTED(java.sql.Connection.TRANSACTION_READ_COMMITTED),
    REPEATABLE_READ(java.sql.Connection.TRANSACTION_REPEATABLE_READ),
    SERIALIZABLE(java.sql.Connection.TRANSACTION_SERIALIZABLE);

    private final int level;

    TransactionIsolationLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}