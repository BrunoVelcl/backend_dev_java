package com.BookLib;

import com.BookLib.application.BookLibService;

public class Main {
    public static void main(String[] args) {
        BookLibService serv = new BookLibService();
        serv.run();
    }
}
