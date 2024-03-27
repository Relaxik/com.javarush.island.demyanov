package com.javarush.island.demyanov.entity.util;


import com.javarush.island.demyanov.entity.Animal;
import com.javarush.island.demyanov.entity.Creator;
import com.javarush.island.demyanov.entity.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Util {


    public static String getRandomName() {
        int random = Creator.randomizer(1, 10);
        List<String> list = new ArrayList<>();
        list.add("Nikolay");
        list.add("Eugen");
        list.add("Vasgen");
        list.add("Ilyha");
        list.add("Inokentiy");
        list.add("Valera");
        list.add("Serioga");
        list.add("Slavka");
        list.add("Egor");
        list.add("Ryslan");

        return list.get(random);
    }




    public static Animal createNewAnimals(Animal animal, int i) {
        for (int j = 0; j < i - 1; j++) {
            Data.setFullHPBar(animal.getClass());
            Creator.createAnimals.add(animal);
        }
        return animal;
    }

    public static void plantsReborn(int set) {
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


    public static <T> Map<T, Long> countByStreamToMap(List<T> inputList) {
        for (int i = 0; i < inputList.size(); i++) {
            String simpleName = inputList.get(i).getClass().getSimpleName();
        }


        return inputList.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));

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
