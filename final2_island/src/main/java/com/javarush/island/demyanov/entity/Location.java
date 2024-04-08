package com.javarush.island.demyanov.entity;
import com.javarush.island.demyanov.data.Data;
import com.javarush.island.demyanov.entity.animal.Animal;
import com.javarush.island.demyanov.util.Creator;
import com.javarush.island.demyanov.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class Location implements Runnable {
    private Util util = new Util();
    private Creator creator = new Creator();
    private int i = 1;
    private Lock lock;

    public Location(Lock lock) {
        this.lock = lock;
    }
    public void createIsland (int x , int y , int plants) {
        int firtsLocation = util.islandCreation(x, y, plants);
        Collections.shuffle(creator.createAnimals);
        for (Animal createAnimal : creator.createAnimals) {
            createAnimal.eat(creator.createAnimals);
        }
        util.arrayCleaning(creator.createAnimals, Data.temp);
        Collections.shuffle(creator.createAnimals);
        for (Animal createAnimal : creator.createAnimals) {
            createAnimal.multiply(creator.createAnimals);
        }
        creator.createAnimals.addAll(Data.temp);
        for (Animal createAnimal : creator.createAnimals) {
            createAnimal.move(firtsLocation);
        }
        util.animalsCounting(creator.createAnimals);
    }
    @Override
    public void run() {
        lock.lock();
        try {
            util.locationEat();
            util.locationMultiply();
            util.locationMove();  // нужно вынести отдельно
        } finally {
            lock.unlock();
            System.out.println("Day # " + i + "_".repeat(50));
            util.animalsCounting(Data.population);
            Data.population.clear();
            i++;

        }

    }
}


