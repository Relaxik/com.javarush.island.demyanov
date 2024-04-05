package com.javarush.island.demyanov.entity.animal;


import com.javarush.island.demyanov.util.Creator;
import com.javarush.island.demyanov.data.Data;
import com.javarush.island.demyanov.entity.animal.herbivorous.Herbivorous;
import com.javarush.island.demyanov.util.Util;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public abstract class Animal {

    private String name = this.getClass().getSimpleName();

    private HashMap<Class<? extends Animal>, Integer> classIntegerHashMap = Data.foodForAll.get(this.getClass().getSimpleName());


    public void eat(Collection<Animal> animals) {
        Util.predatorCheck(this);
        for (Animal createAnimal : animals) {
            if (Util.predatorCheck(this) == true && (classIntegerHashMap.get(createAnimal.getClass()) != null) && classIntegerHashMap.get(createAnimal.getClass()) != 0 &&
                    (ThreadLocalRandom.current().nextInt() <= classIntegerHashMap.get(createAnimal.getClass()))) {
                Data.temp.add(createAnimal);
                break;
            } else if (Util.predatorCheck(this) == true && (classIntegerHashMap.get(createAnimal.getClass()) != null) && classIntegerHashMap.get(createAnimal.getClass()) != 0 &&
                    (ThreadLocalRandom.current().nextInt() > classIntegerHashMap.get(createAnimal.getClass()))) {
                break;
            } else if (Util.predatorCheck(this) == false) {
                eatPlants();
            }
        }
    }

    public void eatPlants() {
        if (this instanceof Herbivorous) {
            int i = Creator.randomizer(0, Data.plants.size());
            if (Data.plants.get(i) != null) {
                Data.plants.set(i, null);
            } else {

            }
        }
    }

    public void multiply(Collection<Animal> animals) {
        int i = 0;
        if (animals.contains(this)) {
            i++;
        }
        if (i > 0) {
            Data.temp.add(this);
        }
    }

    public int move(Integer key) {
        int i = 0;
        int maxSpeed = (int) Data.getMaxSpeed(this.getClass()) + 1;
        if (maxSpeed > 1) {
            switch (Creator.randomizer(1, 5)) {
                // forward = up
                case (1) -> {
                    i = key - (int) (Creator.randomizer(1, maxSpeed) * Math.pow(10, String.valueOf(key / 10).length()));
                    Data.island.get(i).add(this);
                }
                //right
                case (2) -> {
                    i = key + Creator.randomizer(1, maxSpeed);
                    Data.island.get(i).add(this);
                }
                //left
                case (3) -> {
                    i = key - Creator.randomizer(1, maxSpeed);
                    Data.island.get(i).add(this);
                }
                //backwards = down
                case (4) -> {
                    i = (int) (Creator.randomizer(1, maxSpeed) * Math.pow(10, String.valueOf(key / 10).length()));
                    Data.island.get(i).add(this);
                }
            }
        }
        return i;

    }

    public void die() {
        if (Data.getHealthPoints(this.getClass()) == 0) {
            System.out.println("\u001B[31m" + name + " Dies from cringe" + "\u001B[0m");
            Data.isAlive = false;
        } else {
            Data.setHealthPoints(this.getClass());
        }

    }

}
