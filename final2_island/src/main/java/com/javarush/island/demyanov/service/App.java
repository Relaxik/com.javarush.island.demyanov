package com.javarush.island.demyanov.service;


import com.javarush.island.demyanov.data.Data;
import com.javarush.island.demyanov.entity.Location;
import com.javarush.island.demyanov.entity.animal.Animal;
import com.javarush.island.demyanov.util.Creator;
import com.javarush.island.demyanov.util.Util;

import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class App {


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Location location = new Location(lock);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);


        int firtsLocation = Util.islandCreation(100, 100, 200);
        Collections.shuffle(Creator.createAnimals);
        for (Animal createAnimal : Creator.createAnimals) {
            createAnimal.eat(Creator.createAnimals);
        }
        Util.arrayCleaning(Creator.createAnimals, Data.temp);
        Collections.shuffle(Creator.createAnimals);
        for (Animal createAnimal : Creator.createAnimals) {
            createAnimal.multiply(Creator.createAnimals);
        }
        Creator.createAnimals.addAll(Data.temp);
        for (Animal createAnimal : Creator.createAnimals) {
            createAnimal.move(firtsLocation);
        }
        Util.animalsCounting(Creator.createAnimals);
        while (true) {
            try {
                Thread.sleep(2000);
                scheduledExecutorService.submit(location);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }
}
