package com.javarush.island.demyanov.util;


import com.javarush.island.demyanov.entity.animal.Animal;
import com.javarush.island.demyanov.data.Data;
import com.javarush.island.demyanov.entity.animal.herbivorous.*;
import com.javarush.island.demyanov.entity.animal.predator.*;


import java.util.*;




public class Creator {

    public List<Animal> createAnimals = new ArrayList<>();


    {

        createAnimals.add(createNewAnimals(new Wolf(), (int) (Data.getMaxValueOnField(Wolf.class))));
        createAnimals.add(createNewAnimals(new Boa(), (int) (Data.getMaxValueOnField(Boa.class))));
        createAnimals.add(createNewAnimals(new Fox(), (int) (Data.getMaxValueOnField(Fox.class))));
        createAnimals.add(createNewAnimals(new Bear(), (int) (Data.getMaxValueOnField(Bear.class))));
        createAnimals.add(createNewAnimals(new Eagle(), (int) (Data.getMaxValueOnField(Eagle.class))));
        createAnimals.add(createNewAnimals(new Horse(), (int) (Data.getMaxValueOnField(Horse.class))));
        createAnimals.add(createNewAnimals(new Deer(), (int) (Data.getMaxValueOnField(Deer.class))));
        createAnimals.add(createNewAnimals(new Rabbit(), (int) (Data.getMaxValueOnField(Rabbit.class))));
        createAnimals.add(createNewAnimals(new Mouse(), (int) (Data.getMaxValueOnField(Mouse.class))));
        createAnimals.add(createNewAnimals(new Goat(), (int) (Data.getMaxValueOnField(Goat.class))));
        createAnimals.add(createNewAnimals(new Sheep(), (int) (Data.getMaxValueOnField(Sheep.class))));
        createAnimals.add(createNewAnimals(new Boar(), (int) (Data.getMaxValueOnField(Boar.class))));
        createAnimals.add(createNewAnimals(new Buffalo(), (int) (Data.getMaxValueOnField(Buffalo.class))));
        createAnimals.add(createNewAnimals(new Duck(), (int) (Data.getMaxValueOnField(Duck.class))));
        createAnimals.add(createNewAnimals(new Caterpillar(), (int) (Data.getMaxValueOnField(Caterpillar.class))));

    }

    public static int randomizer(int from, int to) {
        return new Random().ints(from, to)
                .findFirst()
                .getAsInt();
    }

    public Animal createNewAnimals(Animal animal, int i) {
        for (int j = 0; j < i - 1; j++) {
            createAnimals.add(animal);
        }
        return animal;
    }

}
