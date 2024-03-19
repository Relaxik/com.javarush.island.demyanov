package com.javarush.island.demyanov;


import java.util.*;

public class Creator {


    // пока-что это подобие локации , на которой есть по 1 ждивотному
    static List<Animal> createAnimals = new ArrayList<>();

    static {
        createAnimals.add(new Wolf());
        createAnimals.add(new Boa());
        createAnimals.add(new Fox());
        createAnimals.add(new Bear());
        createAnimals.add(new Eagle());
        createAnimals.add(new Horse());
        createAnimals.add(new Deer());
        createAnimals.add(new Rabbit());
        createAnimals.add(new Mouse());
        createAnimals.add(new Goat());
        createAnimals.add(new Boar());
        createAnimals.add(new Sheep());
        createAnimals.add(new Buffalo());
        createAnimals.add(new Caterpillar());
        createAnimals.add(new Duck());
    }



    // мапа пища волка
    static HashMap<Class<? extends Animal>, Integer> wolfsFood = new HashMap<>();

    static {
        wolfsFood.put(Horse.class, 10);
        wolfsFood.put(Deer.class, 15);
        wolfsFood.put(Rabbit.class, 60);
        wolfsFood.put(Mouse.class, 80);
        wolfsFood.put(Goat.class, 60);
        wolfsFood.put(Sheep.class, 70);
        wolfsFood.put(Boar.class, 15);
        wolfsFood.put(Buffalo.class, 10);
        wolfsFood.put(Duck.class, 40);
    }



    //мапа для всех
    static Map<String, HashMap <Class<? extends Animal>, Integer>> foodForAll = new HashMap<>();
    static {
        foodForAll.put("Wolf",wolfsFood);

    }




    static int randomizer(int to) {
        return new Random().ints(1, to)
                .findFirst()
                .getAsInt();
    }


}
