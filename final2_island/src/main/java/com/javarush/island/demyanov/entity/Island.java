package com.javarush.island.demyanov.entity;

import com.javarush.island.demyanov.entity.animal.Animal;
import com.javarush.island.demyanov.entity.animal.predator.Wolf;
import com.javarush.island.demyanov.util.Creator;
import com.javarush.island.demyanov.data.Data;
import com.javarush.island.demyanov.util.Util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Island {


    public static void main(String[] args) {


        Integer i = Util.islandCreation(10, 10, 200);


        Collections.shuffle(Creator.createAnimals);

        System.out.println(" EAT" + " __".repeat(100));
        Util.animnalsCounting(Creator.createAnimals);


        for (Animal createAnimal : Creator.createAnimals) {

            createAnimal.eat(Creator.createAnimals);

        }
        Util.arrayCleaning(Creator.createAnimals,Data.temp);
        Collections.shuffle(Creator.createAnimals);
        System.out.println(" CLEAN EATED " + "__".repeat(100));
        Util.animnalsCounting(Creator.createAnimals);


        for (Animal createAnimal : Creator.createAnimals) {
            createAnimal.multiply(Creator.createAnimals);
        }

        Creator.createAnimals.addAll(Data.temp);


        System.out.println("MULTIPLY " + "__".repeat(100));
        Util.animnalsCounting(Creator.createAnimals);


        for (Animal createAnimal : Creator.createAnimals) {
            createAnimal.move(i);
        }




        System.out.println("OSTROV POKYSHAL" + "_".repeat(100));
        Util.islandEat();
        Util.animnalsCounting(Data.population);



        System.out.println("ITOGI  " + "__".repeat(100));
        Util.islandMultiply();
        Util.animnalsCounting(Data.population);


    }

}


