package com.javarush.island.demyanov.util;


import com.javarush.island.demyanov.data.Data;
import com.javarush.island.demyanov.entity.animal.Animal;
import com.javarush.island.demyanov.entity.Plant;

import java.util.*;
import java.util.stream.Collectors;

public class Util {

    static List<Animal> tempo = new ArrayList<>();


    public static Animal createNewAnimals(Animal animal, int i) {
        for (int j = 0; j < i - 1; j++) {
            Data.setFullHPBar(animal.getClass());
            Creator.createAnimals.add(animal);
        }
        return animal;
    }

    public static Integer islandCreation(Integer x, Integer y, Integer plants) {
        Integer i = x * y;
        Integer locationNo;
        for (locationNo = 0; locationNo < i; locationNo++) {
            Data.island.put(locationNo, new ArrayList<>());
            plantsReborn(plants);
        }
        return (x / 2) * ((int) (1 * Math.pow(10, String.valueOf(x / 2).length()))) + (y / 2);
    }

    static void plantsReborn(int set) {
        for (int i = 0; i < set; i++) {
            Data.plants.add(new Plant());
        }

    }


    public static void arrayCleaning(List listForClean, List listTemp) {
        for (Object o : listTemp) {
            for (int i = listForClean.size() - 1; i >= 0; --i) {
                if (listForClean.get(i).equals(o)) {
                    listForClean.remove(i);
                    break;
                }
            }
        }
        listTemp.clear();
    }

    public static int getKey() {
        for (int i = 0; i < 1; i++) {
            if (Data.island.get(i) != null) {
                return i;
            }
        }
        return 0;
    }

    public static void islandEat() {
        for (int i = 0; i < 1; i++) {
            if (Data.island.get(i) != null) {
                for (List<Animal> value : Data.island.values()) {
                    tempo.addAll(value);
                    for (Animal animal1 : value) {
                        animal1.eat(tempo);
                    }
                    arrayCleaning(value, Data.temp);
                    Data.population.addAll(value);
                    tempo.clear();
                }
            }
        }
    }

    public static void islandMultiply() {
        for (int i = 0; i < 1; i++) {
            if (Data.island.get(i) != null) {
                for (List<Animal> value : Data.island.values()) {
                    for (Animal animal : value) {

                    }


                }

                tempo.clear();
                Data.temp.clear();
            }
        }

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
        Data.stringArray.clear();
    }

    public static boolean predatorCheck(Animal animal) {
        if (Data.foodForAll.containsKey(animal.getClass().getSimpleName())) {
            return true;
        }
        return false;
    }

}
