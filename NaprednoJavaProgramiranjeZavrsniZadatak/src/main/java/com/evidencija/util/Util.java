package com.evidencija.util;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import javax.sql.DataSource;
import java.util.Scanner;

public class Util {
    public static final StringBuilder sb;
    public static final Scanner scanner;
    public static final DataSource ds;
    public static final String NEW_LINE;
    public static final String STAR_SEPARATOR;

    static {
        try{
            sb = new StringBuilder();
            scanner = new Scanner(System.in);
            ds = createDataSource();
            NEW_LINE = System.lineSeparator();
            STAR_SEPARATOR = "*********************************";
        } catch (Exception e) {
            System.err.println("Greška kod inicijalizacije programa.");
            throw new RuntimeException(e);
        }
    }

    private static DataSource createDataSource() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setServerName("DESKTOP-Q1U8QL7\\SQLEXPRESS");
        ds.setDatabaseName("JavaAdv");
        ds.setUser("java");
        ds.setPassword("sql");
        ds.setEncrypt(false);
        return ds;
    }
}
