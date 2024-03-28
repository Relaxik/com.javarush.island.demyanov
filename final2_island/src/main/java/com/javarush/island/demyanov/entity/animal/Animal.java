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


    public void eat() {
        Util.aliveCheck(this);
        Util.predatorCheck(this);
        for (Animal createAnimal : Creator.createAnimals) {
            if (Util.predatorCheck(this) == true && (classIntegerHashMap.get(createAnimal.getClass()) != null) && classIntegerHashMap.get(createAnimal.getClass()) != 0 &&
                    (ThreadLocalRandom.current().nextInt() <= classIntegerHashMap.get(createAnimal.getClass()))) {
                Data.temp.add(createAnimal);
                Data.setFullHPBar(this.getClass());

                break;
            } else if (Util.predatorCheck(this) == true && (classIntegerHashMap.get(createAnimal.getClass()) != null) && classIntegerHashMap.get(createAnimal.getClass()) != 0 &&
                    (ThreadLocalRandom.current().nextInt() > classIntegerHashMap.get(createAnimal.getClass()))) {
                break;
            }
        }
    }

    public void eatPlants() {
        if (this instanceof Herbivorous) {
            int i = Creator.randomizer(0, Data.plants.size());
            if (Data.plants.get(i) == null) {
            } else {
                Data.plants.set(i, null);
            }
        }
    }

    public void multiply() {
        int i = 0;
        for (Animal createAnimal : Creator.createAnimals) {
            if (createAnimal.equals(this)) {
                i++;
            }
        }
        if (i > 0) {
            Data.temp.add(this);
        }

    }

    public void move() {

        int maxSpeed = (int) Data.getMaxSpeed(this.getClass()) + 1;
        if (maxSpeed > 1) {
//            switch (Creator.randomizer(1, 5)) {
//                // forward = up
//                case (1) -> {
//                    i = start - Creator.randomizer(1, maxSpeed);
//                    j = start2;
//                    Data.island.get(i + j).add(animal);
//                }
//                //right
//                case (2) -> {
//                    i = start + Creator.randomizer(1, maxSpeed);
//                    j = start2;
//                    Data.island.get(i + j).add(animal);
//                }
//                //left
//                case (3) -> {
//                    i = start;
//                    j = start2 - Creator.randomizer(1, maxSpeed);
//                    Data.island.get(i + j).add(animal);
//                }
//                //backwards = down
//                case (4) -> {
//                    i = start;
//                    j = start2 + Creator.randomizer(1, maxSpeed);
//                    Data.island.get(i + j).add(animal);
//                }
//            }
        }
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
