package com.javarush.island.demyanov.util;


import com.javarush.island.demyanov.data.Data;
import com.javarush.island.demyanov.entity.animal.Animal;
import com.javarush.island.demyanov.entity.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Util {


    public static Animal createNewAnimals(Animal animal, int i) {
        for (int j = 0; j < i - 1; j++) {
            Data.setFullHPBar(animal.getClass());
            Creator.createAnimals.add(animal);
        }
        return animal;
    }

    public static Integer islandCreation(Integer x, Integer y, Integer plants) {
        plantsReborn(plants);
        Integer i = x * y;
        Integer locationNo;
        for (locationNo = 0; locationNo < i; locationNo++) {
            Data.island.put(locationNo, new ArrayList<>());
        }
        return (x/2) * ((int) (1 * Math.pow(10, String.valueOf(x/2).length()))) + (y/2);
    }

    static void plantsReborn(int set) {
        for (int i = 0; i < set; i++) {
            Data.plants.add(new Plant());
        }

    }


    public static void arrayCleaning(List listForClean) {
        for (Object o : Data.temp) {
            for (int i = listForClean.size() - 1; i >= 0; --i) {
                if (listForClean.get(i).equals(o)) {
                    listForClean.remove(i);
                    break;
                }
            }
        }
        Data.temp.clear();
    }

    public void movingUp(Animal animal, Integer maxSpeed, Integer start) {

        Integer i = start - Creator.randomizer(1, maxSpeed);
        Data.island.get(i).add(animal);
    }


    public static void animnalsCounting(List<Animal> inputList) {
        for (Animal createAnimal : inputList) {
            Data.stringArray.add(createAnimal.getClass().getSimpleName());
        }
        Map<String, Long> map = Data.stringArray.stream().collect(Collectors.groupingBy(item -> item, Collectors.counting()));
        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }


    public static void aliveCheck(Animal animal) {
        if (animal != null && Data.getHealthPoints(animal.getClass()) > 0) {
            Data.isAlive = true;
        } else {
            Data.isAlive = false;
        }
    }

    public static boolean predatorCheck(Animal animal) {
        if (Data.foodForAll.containsKey(animal.getClass().getSimpleName())) {
            return true;
        }
        return false;
    }

}
