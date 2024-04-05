package com.javarush.island.demyanov.entity;

import com.javarush.island.demyanov.data.Data;
import com.javarush.island.demyanov.util.Util;

import java.util.concurrent.locks.Lock;

public class Location implements Runnable {
    private int i = 1;
    private Lock lock;

    public Location(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            Util.locationEat();
            Util.locationMultiply();
            Util.locationMove();
        } finally {
            lock.unlock();
            System.out.println("Day # " + i + "_".repeat(50));
            Util.animalsCounting(Data.population);
            i++;

        }

    }
}


