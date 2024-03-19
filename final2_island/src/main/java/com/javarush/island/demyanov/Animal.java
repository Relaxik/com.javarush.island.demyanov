package com.javarush.island.demyanov;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public abstract class Animal {


    // Vremennoe reshenie
    public String getAnimalName() {
        return this.getClass().getSimpleName() + " " + Data.getRandomName();
    }

    public void aliveCheck() {
        if (Data.getHealthPoints(this.getClass()) > 0) {
            Data.isAlive = true;
        } else {
            Data.isAlive = false;
        }
    }

    String name = getAnimalName();


    void eat() {



        for (Animal createAnimal : Creator.createAnimals) {
            String name1 = createAnimal.getClass().getSimpleName();
            if (createAnimal.getClass().getSuperclass().isAnnotationPresent(Eatable.class)) {
                HashMap<Class<? extends Animal>, Integer> classIntegerHashMap = Creator.foodForAll.get(name1);

                
                System.out.println(name1);

            }

        }
    }


    void multiply() {


    }


    void move() {
        aliveCheck();
        int hunger = (int) Data.getHealthPoints(this.getClass());
        int maxSpeed = (int) Data.getMaxSpeed(this.getClass()) + 1;
        switch (Creator.randomizer(5)) {
            case (1) -> System.out.printf("%s moving forward. %d сells crossed. Health point = %d%n",
                    name, Creator.randomizer(maxSpeed), hunger);
            case (2) -> System.out.printf("%s moving right. %d сells crossed. Health point = %d%n",
                    name, Creator.randomizer(maxSpeed), hunger);
            case (3) -> System.out.printf("%s moving left. %d сells crossed. Health point = %d%n",
                    name, Creator.randomizer(maxSpeed), hunger);
            case (4) -> System.out.printf("%s moving backwards. %d сells crossed. Health point = %d%n",
                    name, Creator.randomizer(maxSpeed), hunger);
        }
        die();
    }

    void die() {
        if (Data.getHealthPoints(this.getClass()) == 0) {
            System.out.println("\u001B[31m" + name + " Dies from cringe" + "\u001B[0m");
            Data.isAlive = false;
            Data.setFullHPBar(this.getClass());
        } else {
            Data.setHealthPoints(this.getClass());
        }

    }

}
