package com.javarush.island.demyanov.util;


import com.javarush.island.demyanov.data.Data;
import com.javarush.island.demyanov.entity.animal.Animal;
import com.javarush.island.demyanov.entity.Plant;
import java.util.*;
import java.util.stream.Collectors;

public class Util {
    private List<Animal> tempo = new ArrayList<>();


    public Integer islandCreation(Integer x, Integer y, Integer plants) {
        Integer i = x * y;
        Integer locationNo;
        for (locationNo = 0; locationNo < i; locationNo++) {
            Data.island.put(locationNo, new ArrayList<>());
            Data.island.get(locationNo).add(new Plant());
            plantsReborn(plants);
        }
        return (x / 2) * ((int) (1 * Math.pow(10, String.valueOf(x / 2).length()))) + (y / 2);
    }

    private void plantsReborn(int set) {
        for (int i = 0; i < set; i++) {
            Data.plants.add(new Plant());
        }
    }
    public void arrayCleaning(List listForClean, List listTemp) {
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

    public void locationEat() {
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
    public void locationMultiply() {
        for (int i = 0; i < 1; i++) {
            if (Data.island.get(i) != null) {
                for (List<Animal> value : Data.island.values()) {
                    for (Animal animal : value) {
                        if (Collections.frequency(value, animal) < Data.getMaxValueOnField(animal.getClass())) {
                            animal.multiply(value);
                        }
                    }
                    Data.population.addAll(value);
                }
                tempo.clear();
                Data.temp.clear();
            }
        }
    }
    public void locationMove() {
        for (int i = 0; i < 1; i++) {
            if (Data.island.get(i) != null) {
                for (List<Animal> value : Data.island.values()) {
                    for (Animal animal : value) {
                        if (animal.move(i) > 0 || animal.move(i) < Data.island.size()) {
                            Data.island.get(animal.move(i)).add(i,animal);
                        } else if (animal.move(i) >= Data.island.size()) {
                            Data.island.get(i).remove(animal);
                        }
                    }
                    value.clear();
                }
            }
        }
    }

    public void animalsCounting(List<Animal> inputList) {
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
