package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskScheduler {

    private final ScheduledExecutorService scheduler;

    public TaskScheduler(int poolSize) {
        this.scheduler = Executors.newScheduledThreadPool(poolSize);
    }


    public void scheduleTask(Runnable task, LocalDateTime scheduledTime) {
        long delay = Duration.between(LocalDateTime.now(), scheduledTime).toMillis();

        scheduler.schedule(() -> {
            System.out.println("Task began at: " + LocalDateTime.now());
            task.run();
            System.out.println("Task finished: " + LocalDateTime.now());
        }, delay, TimeUnit.MILLISECONDS);
    }

    public void shutdown() {
        scheduler.shutdown();
    }

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler(3);

        Runnable task1 = () -> System.out.println("Running task 1");
        Runnable task2 = () -> System.out.println("Running task 2");
        Runnable task3 = () -> System.out.println("Running task 3");

        LocalDateTime now = LocalDateTime.now();


        taskScheduler.scheduleTask(task1, now);
        taskScheduler.scheduleTask(task2, now.plusSeconds(3));
        taskScheduler.scheduleTask(task3, now.plusSeconds(5));

        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            taskScheduler.shutdown();
        }
    }
}
