package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
//        CompletableFuture<Void> future = CompletableFuture.runAsync(()-> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                e.printStackTrace();
//            }
//            System.out.println("Hello world!");
//        }) ;
//        future.join();

        //task2
        CompletableFuture<Void> hello = CompletableFuture.runAsync(()-> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Hello");
        }) ;

        CompletableFuture<Void> world = CompletableFuture.runAsync(()-> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("World");
        }) ;

        CompletableFuture<Void> helloWorld = CompletableFuture.allOf(hello,world);
        helloWorld.join();
    }

}