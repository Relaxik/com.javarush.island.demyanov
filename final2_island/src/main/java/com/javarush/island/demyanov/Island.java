package com.javarush.island.demyanov;



import com.javarush.island.demyanov.entity.Creator;
import com.javarush.island.demyanov.entity.predator.Bear;
import com.javarush.island.demyanov.entity.herbivorous.Duck;
import com.javarush.island.demyanov.entity.predator.Wolf;

import java.util.ArrayList;

public class Island {

    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        Wolf wolf2 = new Wolf();
        Bear bear = new Bear();
        Bear bear2 = new Bear();
        Duck duck = new Duck();





        Creator.createAnimals.forEach(System.out::println);




        Creator.createAnimals.forEach(System.out::println);


    }
}

