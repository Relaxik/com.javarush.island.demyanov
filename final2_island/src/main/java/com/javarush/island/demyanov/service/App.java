package com.javarush.island.demyanov.service;
import com.javarush.island.demyanov.entity.Location;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class App {


    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Location location = new Location(lock);
        ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);


        location.createIsland(10,10,200);


        while (true) {
            try {
                Thread.sleep(1000);
                scheduledExecutorService.submit(location);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
