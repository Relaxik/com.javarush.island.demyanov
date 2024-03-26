package com.javarush.island.demyanov;


import com.javarush.island.demyanov.entity.Animal;
import com.javarush.island.demyanov.entity.Creator;
import com.javarush.island.demyanov.entity.herbivorous.Caterpillar;
import com.javarush.island.demyanov.entity.predator.Bear;
import com.javarush.island.demyanov.entity.herbivorous.Duck;
import com.javarush.island.demyanov.entity.predator.Wolf;

import java.util.Collections;


public class Island {

    public static void main(String[] args) {
        Data.plantsReborn(10);

        Wolf wolf = new Wolf();
        Wolf wolf2 = new Wolf();
        Bear bear = new Bear();
        Bear bear2 = new Bear();
        Duck duck = new Duck();



        Collections.shuffle(Creator.createAnimals);
        System.out.println("size before " + Creator.createAnimals.size());
        for (Animal createAnimal : Creator.createAnimals) {
            createAnimal.eatPlants();
            createAnimal.eat();



        }


        System.out.println("size after" + Creator.createAnimals.size());


    }
}

