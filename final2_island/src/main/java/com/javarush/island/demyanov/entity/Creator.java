package com.javarush.island.demyanov.entity;


import com.javarush.island.demyanov.Data;
import com.javarush.island.demyanov.entity.herbivorous.*;
import com.javarush.island.demyanov.entity.predator.*;
import lombok.EqualsAndHashCode;

import java.util.*;

@EqualsAndHashCode
public class Creator {


    // пока-что это подобие локации , на которой есть по 1 животному
   public static List<Class<? extends Animal>> createAnimals = new ArrayList<>();

    static {

        createAnimals.add(Wolf.class);
        createAnimals.add(Boa.class );
        createAnimals.add(Fox.class);
        createAnimals.add(Bear.class);
        createAnimals.add(Eagle.class);
        createAnimals.add(Horse.class);
        createAnimals.add(Deer.class);
        createAnimals.add(Rabbit.class);
        createAnimals.add(Mouse.class);
        createAnimals.add(Goat.class);
        createAnimals.add(Sheep.class);
        createAnimals.add(Boar.class);
        createAnimals.add(Buffalo.class);
        createAnimals.add(Duck.class);
        createAnimals.add(Caterpillar.class);

    }

    public static void createNewAnimals(Class clazz, int i) {
        for (int j = 0; j < i; j++) {
            Data.setFullHPBar(clazz);
            createAnimals.add(clazz);

        }

    }

    // мапа пища волка


    public static int randomizer(int from, int to) {
        return new Random().ints(from, to)
                .findFirst()
                .getAsInt();
    }


}
