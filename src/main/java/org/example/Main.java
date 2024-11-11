package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

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
//        CompletableFuture<Void> hello = CompletableFuture.runAsync(()-> {
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                e.printStackTrace();
//            }
//            System.out.println("Hello");
//        }) ;
//
//        CompletableFuture<Void> world = CompletableFuture.runAsync(()-> {
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                e.printStackTrace();
//            }
//            System.out.println("World");
//        }) ;
//
//        CompletableFuture<Void> helloWorld = CompletableFuture.allOf(hello,world);
//        helloWorld.join();

//        task3
//        CompletableFuture<String> hello = CompletableFuture.supplyAsync(()-> {
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                e.printStackTrace();
//            }
//            return "Hello";
//        }) ;
//
//        CompletableFuture<String> world = CompletableFuture.supplyAsync(()-> {
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                e.printStackTrace();
//            }
//            return "World";
//        }) ;
//
//        CompletableFuture<String> helloWorld = hello.thenCombine(world, (h,w)->h +" "+ w);
//        helloWorld.thenAccept(System.out::println);
//        helloWorld.join();
//    }


        //task 4
//        Random random = new Random();
//        CompletableFuture<String> hello = CompletableFuture.supplyAsync(()-> {
//            int delay = random.nextInt(10)+1;
//            try {
//                TimeUnit.SECONDS.sleep(delay);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                e.printStackTrace();
//            }
//            return "Hello";
//        }) ;
//
//        CompletableFuture<String> world = CompletableFuture.supplyAsync(()-> {
//            int delay = random.nextInt(10)+1;
//            try {
//                TimeUnit.SECONDS.sleep(delay);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                e.printStackTrace();
//            }
//            return "World";
//        }) ;
//
//        CompletableFuture<String> helloWorld = hello.thenCombine(world, (h,w)->h +" "+ w)
//                        .orTimeout(10, TimeUnit.SECONDS);
//        helloWorld.thenAccept(System.out::println)
//                        .exceptionally(ex -> {
//                            if (ex.getCause() instanceof TimeoutException) {
//                                System.out.println("Error: Time exceeded 10 seconds");
//                            }
//                            return null;
//                        });
//        helloWorld.join();
//    }
        //task 5
//        String data = "85671 34262 92143 50984 24515 68356 77247 12348 56789 98760";
//
//        List<BigInteger> numbers = Arrays.stream(data.split(" "))
//                .map(BigInteger::new)
//                .collect(Collectors.toList());
//
//        CompletableFuture.supplyAsync(() -> numbers)
//                .thenApply(list ->
//                        list.stream()
//                                .map(Main::calculateFactorial)
//                                .collect(Collectors.toList())
//                )
//                .thenAccept(result ->
//                        System.out.println("Factorials: " + result)
//                ).join();

//    private static BigInteger calculateFactorial(BigInteger num) {
//        BigInteger result = BigInteger.ONE;
//        for (BigInteger i = BigInteger.ONE; i.compareTo(num) <= 0; i = i.add(BigInteger.ONE)) {
//            result = result.multiply(i);
//        }
//        return result;
//    }

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(()-> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            return "Hello";
        }) ;

        CompletableFuture<String> world = CompletableFuture.supplyAsync(()-> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            return "World";
        }) ;

        hello.thenCombine(world, (h, w) -> h + " " + w)
                .thenAccept(System.out::println)
                .join();
    }

}