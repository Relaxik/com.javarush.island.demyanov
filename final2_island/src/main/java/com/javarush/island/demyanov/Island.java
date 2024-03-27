package com.javarush.island.demyanov;
import com.javarush.island.demyanov.entity.Animal;
import com.javarush.island.demyanov.entity.Creator;
import com.javarush.island.demyanov.entity.util.Data;
import com.javarush.island.demyanov.entity.util.Util;
import java.util.Collections;


public class Island {

    public static void main(String[] args) {
        Util.plantsReborn(10);


        Collections.shuffle(Creator.createAnimals);
        System.out.println("list sozdannih  " + Creator.createAnimals.size());


        for (Animal createAnimal : Creator.createAnimals) {
            createAnimal.eatPlants();
            createAnimal.eat();
        }

        Util.arrayCleaning(Creator.createAnimals);

        System.out.println("list noviy " + Creator.createAnimals.size());

        Collections.shuffle(Creator.createAnimals);

        for (Animal createAnimal : Creator.createAnimals) {
            createAnimal.multiply();
        }

        Creator.createAnimals.addAll(Data.temp);


        for (Animal createAnimal : Creator.createAnimals) {
            createAnimal.move();
        }

        // Нужно запилить вывод на экран по животным !!


        System.out.println("list noviy " + Creator.createAnimals.size());


    }
}

