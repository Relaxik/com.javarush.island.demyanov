package com.javarush.island.demyanov.entity;

import com.javarush.island.demyanov.Data;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;


public abstract class Animal {

    Animal animal = this;

    String getAnimalName() {

        return this.getClass().getSimpleName() + " " + Data.getRandomName();
    }

    String name = getAnimalName();

    public void aliveCheck() {
        if (Data.getHealthPoints(this.getClass()) > 0) {
            Data.isAlive = true;
        } else {
            Data.isAlive = false;
        }
    }


    public void eat() {
        HashMap<Class<? extends Animal>, Integer> classIntegerHashMap = Data.foodForAll.get(animal.getClass().getSimpleName());
        for (Class<? extends Animal> createAnimal : Creator.createAnimals) {
            if ((classIntegerHashMap.get(createAnimal) != null) && classIntegerHashMap.get(createAnimal) != 0 &&
                    (ThreadLocalRandom.current().nextInt() <= classIntegerHashMap.get(createAnimal))) {
                System.out.println(name + " eated " + createAnimal.getSimpleName());
                Data.setFullHPBar(this.getClass());
                break;
            } else if ((classIntegerHashMap.get(createAnimal) != null) && classIntegerHashMap.get(createAnimal) != 0 &&
                    (ThreadLocalRandom.current().nextInt() > classIntegerHashMap.get(createAnimal))) {
                System.out.println(name + " failed to eat " + createAnimal.getSimpleName());
                break;
            }
        }
    }

    public boolean eatPlants() {
        int i = Creator.randomizer(0, Data.plants.size());
        if (Data.plants.get(i) == null) {
            System.out.println("There is no plant on cell # " + i);
            return false;
        } else {
            Data.plants.set(i, null);
            System.out.println(name + " eated plant # " + i);
            return true;
        }

    }

    public void multiply() {
        int i = 0;
        for (Class<? extends Animal> createAnimal : Creator.createAnimals) {
            if (createAnimal.getSimpleName().equals(animal.getClass().getSimpleName())) {
                i++;
            }
        }
        if (i > 0) {
            Creator.createNewAnimals(animal.getClass(), i / 2);
            System.out.println("That was amazing. " + "New " + animal.getClass().getSimpleName() + " born");
            System.out.println(animal.getClass().getSimpleName() + " population " + i);
        } else {
            System.out.println("Sichyem");
        }
    }


    public void move() {
        aliveCheck();
        int hunger = (int) Data.getHealthPoints(this.getClass());
        int maxSpeed = (int) Data.getMaxSpeed(this.getClass()) + 1;
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
        die();
    }

    public void die() {
        if (Data.getHealthPoints(this.getClass()) == 0) {
            System.out.println("\u001B[31m" + name + " Dies from cringe" + "\u001B[0m");
            Data.isAlive = false;
            Creator.createAnimals.set(Creator.createAnimals.indexOf(animal.getClass()), null);
        } else {
            Data.setHealthPoints(this.getClass());
        }

    }

}
