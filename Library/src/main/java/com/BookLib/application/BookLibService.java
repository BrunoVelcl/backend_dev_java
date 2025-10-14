package com.BookLib.application;

import com.BookLib.domain.entity.Author;
import com.BookLib.domain.entity.Book;
import com.BookLib.domain.entity.Publisher;
import com.BookLib.domain.repository.GenericRepository;
import com.BookLib.infrastructure.GenericRepositoryImpl;
import com.BookLib.util.HibernateUtil;
import java.time.Year;
import java.util.Set;

public class BookLibService {
    public void run(){
        GenericRepository gr = new GenericRepositoryImpl();
        var nova = gr.addOrUpdate(new Publisher("Nova Press"));
        var tech = gr.addOrUpdate(new Publisher("Tech Core"));
        var apex = gr.addOrUpdate(new Publisher("Apex Books"));
        var aliceg = gr.addOrUpdate(new Author("Alice", "Green"));
        var bobc = gr.addOrUpdate(new Author("Bob", "Carter"));
        var danal = gr.addOrUpdate(new Author("Dana", "Lee"));
        var erics = gr.addOrUpdate(new Author("Eric", "Stone"));
        var carlam = gr.addOrUpdate(new Author("Carla", "More"));
        var frankn = gr.addOrUpdate(new Author("Frank", "Nelson"));


        gr.addOrUpdate(new Book("Shadows of Tomorow", Set.of(aliceg, bobc), nova, Year.of(2018)));
        gr.addOrUpdate(new Book("Quantum Horizons", Set.of(aliceg, danal), nova, Year.of(2019)));
        gr.addOrUpdate(new Book("Digital Minds", Set.of(aliceg, carlam), tech, Year.of(2018)));
        gr.addOrUpdate(new Book("Parallel realities", Set.of(danal, erics), nova, Year.of(2020)));
        gr.addOrUpdate(new Book("Codebreakers", Set.of(carlam, frankn), tech, Year.of(2019)));
        gr.addOrUpdate(new Book("The last Algorithm", Set.of(aliceg, frankn), apex, Year.of(2020)));
        gr.addOrUpdate(new Book("Synthetic Souls", Set.of(erics, bobc), nova, Year.of(2021)));
        gr.addOrUpdate(new Book("Data Storm", Set.of(carlam, danal), tech, Year.of(2021)));
        gr.addOrUpdate(new Book("Echoes of Creation", Set.of(aliceg, erics), apex, Year.of(2021)));
        gr.addOrUpdate(new Book("Future Architectures", Set.of(bobc, frankn), tech, Year.of(2022)));

        HibernateUtil.closeSessionFactory();
    }
}
