package org.example;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Factorial {
    public static void main(String[] args) {

        String data = "85671 34262 92143 50984 24515 68356 77247 12348 56789 98760";

        List<BigInteger> numbers = Arrays.stream(data.split(" "))
                .map(BigInteger::new)
                .collect(Collectors.toList());

        List<Integer> numberss = List.of(5, 6, 7, 8, 9);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        try{
            for (int num:numberss){
                Callable<BigInteger> task = () -> calculateFactorial(BigInteger.valueOf(num));

                System.out.println("Factorial of " +num+ " is: "+ executor.submit(task).get());
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }

        String story = "Mary had a little lamb, its fleece was white as snow.";
        List<String> words= Arrays.asList(story.split(" "));
        CompletableFuture<Void> printStory = CompletableFuture.runAsync(()->{
            words.forEach(word-> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(word);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            });
        });

        CompletableFuture.supplyAsync(() -> numbers)
                .thenApply(list ->
                        list.stream()
                                .map(Factorial::calculateFactorial)
                                .collect(Collectors.toList())
                )
                .thenAccept(result ->
                        System.out.println("Factorials: " + result)
                ).join();

        try(ExecutorService service = Executors.newSingleThreadExecutor()){
            for(int i=0; i<3; i++){
                service.submit(() ->{
                    try{
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("Hello World");
                    }catch (InterruptedException ex){
                        Thread.currentThread().interrupt();
                        ex.printStackTrace();
                    }
                });
            }
        }
    }

    private static BigInteger calculateFactorial(BigInteger num) {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(num) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }

    }

