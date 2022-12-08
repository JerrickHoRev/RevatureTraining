package com.example;

import java.util.ArrayList;
import java.util.List;

import io.javalin.Javalin;

/**
 * All maven projects have their code stored inside of a src/main/java
 * directory, Now the reason I also have
 * a "com" package and inside of that one there is a package called "example" is
 * because the maven project generally
 * names your base package structure after the grouId you set when you set up
 * your project. What this means is
 * that all of your java code is going to, at minimum, have a "package
 * com.example" to stat it off in orddcer
 * to let maven know where the code is when it builds our application
 */

public class App {

    public static List<String> names = new ArrayList<>();

    public static void main(String[] args) {

        names.add("Billy");
        names.add("Sally");
        names.add("Bruce");

        Javalin app = Javalin.create();

        /*
         * the code below tells Javalin that our web server is created needs to be able
         * to handle a GET
         * http request that ends with /hello. Upon our application receiving this
         * request the application
         * should return the text "Hello World!" to the requester
         */

        app.get("/hello", ctx -> ctx.result("Hello world!"));

        app.post("/add", ctx -> {
            // we get the name from the http request body and save it to a variable
            String newName = ctx.body();
            // we add the new name into the list of names
            names.add(newName);
            // we tell Javalin we want to return a String message to the requester
            ctx.result("Congrats! You added a new name to the names database");
            // we tell Javalin we want the status code 201 returned in the response
            ctx.status(201);

        });

        app.get("/person/{num}", ctx -> {
            String numAsString = ctx.pathParam("num");
            int num = Integer.parseInt(numAsString);
            String person = names.get(num);
            ctx.result(person);
            ctx.status(200);
        });

        app.put("/replace/{num}", ctx -> {
            // get the index position from the path as a string
            String numAsString = ctx.pathParam("num");
            int num = Integer.parseInt(numAsString);
            String replacePerson = ctx.body();
            names.set(num, replacePerson);
            ctx.result("Replaced person succesfully!");
            ctx.status(200);
        });

        app.patch("/update/{num}", ctx ->{
            String numAsString = ctx.pathParam("num");
            int num = Integer.parseInt(numAsString);
            String updatedInformation = ctx.body();
            names.set(num, updatedInformation);
            ctx.result("Successfully updated the person's information");
            ctx.status(200);
        });

        app.delete("/delete/", ctx -> {
            names.clear();
            ctx.result("Successfully deleted information");
            ctx.status(200);
        });

        app.get("/protectedGet/{num}", ctx ->{
            String numAsString = ctx.pathParam("num");
            int num  = Integer.parseInt(numAsString);
            try {
                String person = names.get(num);
                ctx.result(person);
                ctx.status(200);
            } catch (Exception e) {
                ctx.result("Index not found!");
                ctx.status(404);
            }
        });
    
        app.start();

    }
}
