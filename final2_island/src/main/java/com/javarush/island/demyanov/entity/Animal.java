package com.javarush.island.demyanov.entity;

import com.javarush.island.demyanov.entity.util.Data;
import com.javarush.island.demyanov.entity.herbivorous.Herbivorous;
import com.javarush.island.demyanov.entity.util.Util;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public abstract class Animal {

    private Animal animal = this;
    private String name = getAnimalName();

    private HashMap<Class<? extends Animal>, Integer> classIntegerHashMap = Data.foodForAll.get(animal.getClass().getSimpleName());


    private String getAnimalName() {

        return this.getClass().getSimpleName() + " " + Util.getRandomName();
    }

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
        if (animal instanceof Herbivorous) {
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
            if (createAnimal.equals(animal)) {
                i++;
            }
        }
        if (i > 0) {
            Data.temp.add(this);
        }

    }

    public void move() {

        Util.aliveCheck(this);
        int hunger = (int) Data.getHealthPoints(this.getClass());
        int maxSpeed = (int) Data.getMaxSpeed(this.getClass()) + 1;
        if (maxSpeed <= 1) {
        } else {
            switch (Creator.randomizer(1, 5)) {
                case (1) -> System.out.printf("%s moving forward. %d сells crossed. Health point = %d%n",
                        name, Creator.randomizer(1, maxSpeed), hunger);
                case (2) -> System.out.printf("%s moving right. %d сells crossed. Health point = %d%n",
                        name, Creator.randomizer(1, maxSpeed), hunger);
                case (3) -> System.out.printf("%s moving left. %d сells crossed. Health point = %d%n",
                        name, Creator.randomizer(1, maxSpeed), hunger);
                case (4) -> System.out.printf("%s moving backwards. %d сells crossed. Health point = %d%n",
                        name, Creator.randomizer(1, maxSpeed), hunger);
            }
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
