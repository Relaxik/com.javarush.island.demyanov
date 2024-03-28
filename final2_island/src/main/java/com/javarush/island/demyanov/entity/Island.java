package com.javarush.island.demyanov.entity;

import com.javarush.island.demyanov.entity.animal.Animal;
import com.javarush.island.demyanov.util.Creator;
import com.javarush.island.demyanov.data.Data;
import com.javarush.island.demyanov.util.Util;

import java.util.Collections;


public class Island {


    public static void main(String[] args) {






        Collections.shuffle(Creator.createAnimals);

        for (Animal createAnimal : Creator.createAnimals) {
            createAnimal.eatPlants();
            createAnimal.eat();
        }

        Util.arrayCleaning(Creator.createAnimals);


        Collections.shuffle(Creator.createAnimals);

        for (Animal createAnimal : Creator.createAnimals) {
            createAnimal.multiply();
        }

        Creator.createAnimals.addAll(Data.temp);


        for (Animal createAnimal : Creator.createAnimals) {
            createAnimal.move();
        }


        Util.animnalsCounting(Creator.createAnimals);


    }
}

