package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DebugGraphics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.javalin.Javalin;

public class Library {

    public static Logger Logger = LoggerFactory.getLogger(Library.class);
    /*
     * notice I did not add an access modifier: this meanas the variable is given
     * the deafult
     * access modifier, which means any code within the current pacakge can use it
     */
    static List<Book> library = new ArrayList<>();

    public static void main(String[] args) {

        Logger.trace("This log was created at the trace level");
        Logger.debug("This log was created at the debug level");
        Logger.info("Application starting");
        Logger.warn("This log was created at the warn level");
        Logger.error("This log was created at the error level");

        Book startingBook = new Book();
        startingBook.setTitle("The Fellowship of the Ring");
        startingBook.setAuthor("J. R. R. Tolkien");
        startingBook.setGenre("Fantasy");
        startingBook.setIsbn(123456789);

        library.add(startingBook);

        Javalin app = Javalin.create();

        app.get("/get/{index}", ctx -> {
            // here you can see I don't HAVE to make the String varaible first, I can pass
            // the results of
            // the pathParam method directly into the parseInt method
            int index = Integer.parseInt(ctx.pathParam("index"));
            Book book = library.get(index);
            ctx.json(book);
            ctx.status(200);
        });

        app.post("/book", ctx -> {
            Book newBook = ctx.bodyAsClass(Book.class);
            library.add(newBook);
            ctx.result("Book added to the library!");
            ctx.status(201);
        });

        app.patch("/book/{index}", ctx -> {
            int index = Integer.parseInt(ctx.pathParam("index"));
            Book updatedBook = ctx.bodyAsClass(Book.class);
            library.get(index).setAuthor(updatedBook.getAuthor());
            library.get(index).setTitle(updatedBook.getTitle());
            library.get(index).setGenre(updatedBook.getGenre());
            ctx.json(library.get(index));
            ctx.status(200);
        });

        app.put("/book/(index)", ctx -> {
            int index = Integer.parseInt(ctx.pathParam("index"));
            Book updatedBook = ctx.bodyAsClass(Book.class);
            library.set(index, updatedBook);
            ctx.json(library.get(index));
            ctx.status(200);
        });

        app.delete("/book/{index}", ctx -> {
            int index = Integer.parseInt(ctx.pathParam("index"));
            library.remove(index);
            ctx.status(200);
        });

        app.start();

    }

}
