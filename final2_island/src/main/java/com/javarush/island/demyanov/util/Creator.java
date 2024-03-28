package com.javarush.island.demyanov.util;


import com.javarush.island.demyanov.entity.animal.Animal;
import com.javarush.island.demyanov.data.Data;
import com.javarush.island.demyanov.entity.animal.herbivorous.*;
import com.javarush.island.demyanov.entity.animal.predator.*;
import lombok.EqualsAndHashCode;

import java.util.*;

import static com.javarush.island.demyanov.util.Util.createNewAnimals;

@EqualsAndHashCode
public class Creator {


    // пока-что это подобие локации , на которой есть по 1 животному
    public static List <Animal> createAnimals = new ArrayList<>();


    static {

        createAnimals.add(createNewAnimals(new Wolf(), (int) (Data.getMaxValueOnField(Wolf.class) / 2)));
        createAnimals.add(createNewAnimals(new Boa(), (int) (Data.getMaxValueOnField(Boa.class) / 2)));
        createAnimals.add(createNewAnimals(new Fox(), (int) (Data.getMaxValueOnField(Fox.class) / 2)));
        createAnimals.add(createNewAnimals(new Bear(), (int) (Data.getMaxValueOnField(Bear.class) / 2)));
        createAnimals.add(createNewAnimals(new Eagle(), (int) (Data.getMaxValueOnField(Eagle.class) / 2)));
        createAnimals.add(createNewAnimals(new Horse(), (int) (Data.getMaxValueOnField(Horse.class) / 2)));
        createAnimals.add(createNewAnimals(new Deer(), (int) (Data.getMaxValueOnField(Deer.class) / 2)));
        createAnimals.add(createNewAnimals(new Rabbit(), (int) (Data.getMaxValueOnField(Rabbit.class) / 2)));
        createAnimals.add(createNewAnimals(new Mouse(), (int) (Data.getMaxValueOnField(Mouse.class) / 2)));
        createAnimals.add(createNewAnimals(new Goat(), (int) (Data.getMaxValueOnField(Goat.class) / 2)));
        createAnimals.add(createNewAnimals(new Sheep(), (int) (Data.getMaxValueOnField(Sheep.class) / 2)));
        createAnimals.add(createNewAnimals(new Boar(), (int) (Data.getMaxValueOnField(Boar.class) / 2)));
        createAnimals.add(createNewAnimals(new Buffalo(), (int) (Data.getMaxValueOnField(Buffalo.class) / 2)));
        createAnimals.add(createNewAnimals(new Duck(), (int) (Data.getMaxValueOnField(Duck.class) / 2)));
        createAnimals.add(createNewAnimals(new Caterpillar(), (int) (Data.getMaxValueOnField(Caterpillar.class) / 2)));

    }

    public static int randomizer(int from, int to) {
        return new Random().ints(from, to)
                .findFirst()
                .getAsInt();
    }


}
