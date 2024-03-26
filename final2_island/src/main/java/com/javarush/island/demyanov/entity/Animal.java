package com.javarush.island.demyanov.entity;

import com.javarush.island.demyanov.Data;
import com.javarush.island.demyanov.entity.herbivorous.Herbivorous;


import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;



public abstract class Animal {

    private Animal animal = this;
    private String name = getAnimalName();
    private HashMap<Class<? extends Animal>, Integer> classIntegerHashMap = Data.foodForAll.get(animal.getClass().getSimpleName());


    private String getAnimalName() {

        return this.getClass().getSimpleName() + " " + Data.getRandomName();
    }


    private void aliveCheck() {
        if (animal != null && Data.getHealthPoints(this.getClass()) > 0) {
            Data.isAlive = true;
        } else {
            Data.isAlive = false;

        }
    }

    private boolean predatorCheck() {
        if (Data.foodForAll.containsKey(animal.getClass().getSimpleName())) {
            return true;
        }
        return false;
    }

    public void eat() {
        aliveCheck();
        predatorCheck();

        for (Animal createAnimal : Creator.createAnimals) {
            if (predatorCheck() == true && (classIntegerHashMap.get(createAnimal.getClass()) != null) && classIntegerHashMap.get(createAnimal.getClass()) != 0 &&
                    (ThreadLocalRandom.current().nextInt() <= classIntegerHashMap.get(createAnimal.getClass()))) {


                System.out.println(name + " eated " + createAnimal.getClass().getSimpleName());

                Data.setFullHPBar(this.getClass());
                break;

            } else if (predatorCheck() == true && (classIntegerHashMap.get(createAnimal.getClass()) != null) && classIntegerHashMap.get(createAnimal.getClass()) != 0 &&
                    (ThreadLocalRandom.current().nextInt() > classIntegerHashMap.get(createAnimal.getClass()))) {


                System.out.println(name + " failed to eat " + createAnimal.getClass().getSimpleName());

                break;
            }
        }

    }

    public void eatPlants() {
        if (animal instanceof Herbivorous) {
            int i = Creator.randomizer(0, Data.plants.size());
            if (Data.plants.get(i) == null) {

//                System.out.println("There is no plant on cell # " + i);
            } else {
                Data.plants.set(i, null);
//                System.out.println(name + " eated plant # " + i);


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
