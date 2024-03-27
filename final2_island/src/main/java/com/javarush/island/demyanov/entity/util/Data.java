package com.javarush.island.demyanov.entity.util;


import com.javarush.island.demyanov.entity.*;
import com.javarush.island.demyanov.entity.herbivorous.*;
import com.javarush.island.demyanov.entity.predator.*;
import lombok.EqualsAndHashCode;

import java.util.*;

@EqualsAndHashCode
public class Data {

    public static boolean isAlive = true;

    public static List<Animal> temp = new ArrayList<>();

    static HashMap<Class<? extends Animal>, Integer> wolfsFood = new HashMap<>();

    static {
        wolfsFood.put(Wolf.class, 0);
        wolfsFood.put(Boa.class, 0);
        wolfsFood.put(Fox.class, 0);
        wolfsFood.put(Bear.class, 0);
        wolfsFood.put(Eagle.class, 0);
        wolfsFood.put(Horse.class, 10);
        wolfsFood.put(Deer.class, 15);
        wolfsFood.put(Rabbit.class, 60);
        wolfsFood.put(Mouse.class, 80);
        wolfsFood.put(Goat.class, 60);
        wolfsFood.put(Sheep.class, 70);
        wolfsFood.put(Boar.class, 15);
        wolfsFood.put(Buffalo.class, 10);
        wolfsFood.put(Duck.class, 40);
        wolfsFood.put(Caterpillar.class, 0);
    }

    static HashMap<Class<? extends Animal>, Integer> boasFood = new HashMap<>();

    static {
        boasFood.put(Wolf.class, 0);
        boasFood.put(Boa.class, 0);
        boasFood.put(Fox.class, 15);
        boasFood.put(Bear.class, 0);
        boasFood.put(Eagle.class, 0);
        boasFood.put(Horse.class, 0);
        boasFood.put(Deer.class, 0);
        boasFood.put(Rabbit.class, 20);
        boasFood.put(Mouse.class, 40);
        boasFood.put(Goat.class, 0);
        boasFood.put(Sheep.class, 0);
        boasFood.put(Boar.class, 0);
        boasFood.put(Buffalo.class, 0);
        boasFood.put(Duck.class, 10);
        boasFood.put(Caterpillar.class, 0);
    }

    static HashMap<Class<? extends Animal>, Integer> foxsFood = new HashMap<>();

    static {
        foxsFood.put(Wolf.class, 0);
        foxsFood.put(Boa.class, 0);
        foxsFood.put(Fox.class, 0);
        foxsFood.put(Bear.class, 0);
        foxsFood.put(Eagle.class, 0);
        foxsFood.put(Horse.class, 0);
        foxsFood.put(Deer.class, 0);
        foxsFood.put(Rabbit.class, 70);
        foxsFood.put(Mouse.class, 90);
        foxsFood.put(Goat.class, 0);
        foxsFood.put(Sheep.class, 0);
        foxsFood.put(Boar.class, 0);
        foxsFood.put(Buffalo.class, 0);
        foxsFood.put(Duck.class, 60);
        foxsFood.put(Caterpillar.class, 40);
    }

    static HashMap<Class<? extends Animal>, Integer> bearsFood = new HashMap<>();

    static {
        bearsFood.put(Wolf.class, 0);
        bearsFood.put(Boa.class, 80);
        bearsFood.put(Fox.class, 0);
        bearsFood.put(Bear.class, 0);
        bearsFood.put(Eagle.class, 0);
        bearsFood.put(Horse.class, 40);
        bearsFood.put(Deer.class, 80);
        bearsFood.put(Rabbit.class, 80);
        bearsFood.put(Mouse.class, 90);
        bearsFood.put(Goat.class, 70);
        bearsFood.put(Sheep.class, 70);
        bearsFood.put(Boar.class, 50);
        bearsFood.put(Buffalo.class, 20);
        bearsFood.put(Duck.class, 10);
        bearsFood.put(Caterpillar.class, 0);
    }

    static HashMap<Class<? extends Animal>, Integer> eaglesFood = new HashMap<>();

    static {
        eaglesFood.put(Wolf.class, 0);
        eaglesFood.put(Boa.class, 0);
        eaglesFood.put(Fox.class, 10);
        eaglesFood.put(Bear.class, 0);
        eaglesFood.put(Eagle.class, 0);
        eaglesFood.put(Horse.class, 0);
        eaglesFood.put(Deer.class, 0);
        eaglesFood.put(Rabbit.class, 90);
        eaglesFood.put(Mouse.class, 90);
        eaglesFood.put(Goat.class, 0);
        eaglesFood.put(Sheep.class, 0);
        eaglesFood.put(Boar.class, 0);
        eaglesFood.put(Buffalo.class, 0);
        eaglesFood.put(Duck.class, 80);
        eaglesFood.put(Caterpillar.class, 0);
    }

    static HashMap<Class<? extends Animal>, Integer> mousesFood = new HashMap<>();

    static {
        mousesFood.put(Wolf.class, 0);
        mousesFood.put(Boa.class, 0);
        mousesFood.put(Fox.class, 0);
        mousesFood.put(Bear.class, 0);
        mousesFood.put(Eagle.class, 0);
        mousesFood.put(Horse.class, 0);
        mousesFood.put(Deer.class, 0);
        mousesFood.put(Rabbit.class, 0);
        mousesFood.put(Mouse.class, 0);
        mousesFood.put(Goat.class, 0);
        mousesFood.put(Sheep.class, 0);
        mousesFood.put(Boar.class, 0);
        mousesFood.put(Buffalo.class, 0);
        mousesFood.put(Duck.class, 0);
        mousesFood.put(Caterpillar.class, 90);
    }

    static HashMap<Class<? extends Animal>, Integer> boarsFood = new HashMap<>();

    static {
        boarsFood.put(Wolf.class, 0);
        boarsFood.put(Boa.class, 0);
        boarsFood.put(Fox.class, 0);
        boarsFood.put(Bear.class, 0);
        boarsFood.put(Eagle.class, 0);
        boarsFood.put(Horse.class, 0);
        boarsFood.put(Deer.class, 0);
        boarsFood.put(Rabbit.class, 0);
        boarsFood.put(Mouse.class, 50);
        boarsFood.put(Goat.class, 0);
        boarsFood.put(Sheep.class, 0);
        boarsFood.put(Boar.class, 0);
        boarsFood.put(Buffalo.class, 0);
        boarsFood.put(Duck.class, 0);
        boarsFood.put(Caterpillar.class, 90);
    }

    static HashMap<Class<? extends Animal>, Integer> ducksFood = new HashMap<>();

    static {
        ducksFood.put(Wolf.class, 0);
        ducksFood.put(Boa.class, 0);
        ducksFood.put(Fox.class, 0);
        ducksFood.put(Bear.class, 0);
        ducksFood.put(Eagle.class, 0);
        ducksFood.put(Horse.class, 0);
        ducksFood.put(Deer.class, 0);
        ducksFood.put(Rabbit.class, 0);
        ducksFood.put(Mouse.class, 0);
        ducksFood.put(Goat.class, 0);
        ducksFood.put(Sheep.class, 0);
        ducksFood.put(Boar.class, 0);
        ducksFood.put(Buffalo.class, 0);
        ducksFood.put(Duck.class, 0);
        ducksFood.put(Caterpillar.class, 90);
    }

    public static Map<String, HashMap<Class<? extends Animal>, Integer>> foodForAll = new HashMap<>();

    static {
        foodForAll.put("Wolf", wolfsFood);
        foodForAll.put("Boa", boasFood);
        foodForAll.put("Fox", foxsFood);
        foodForAll.put("Bear", bearsFood);
        foodForAll.put("Eagle", eaglesFood);
        foodForAll.put("Mouse", mousesFood);
        foodForAll.put("Boar", boarsFood);
        foodForAll.put("Duck", ducksFood);
    }

    public static ArrayList<Plant> plants = new ArrayList<>();



    public static ArrayList<Class<? extends Animal>> animals = new ArrayList<>();


    public static final Map<Class<? extends Animal>, double[]> ANIMAL_PARAMETERS = new HashMap<>();


    static {      // Weight , Max count per location, max speed , food to feed up , start HP
        ANIMAL_PARAMETERS.put(Wolf.class, new double[]{50, 30, 3, 8, 100});
        ANIMAL_PARAMETERS.put(Boa.class, new double[]{15, 30, 1, 3, 100});
        ANIMAL_PARAMETERS.put(Fox.class, new double[]{8, 30, 2, 2, 100});
        ANIMAL_PARAMETERS.put(Bear.class, new double[]{500, 5, 2, 80, 100});
        ANIMAL_PARAMETERS.put(Eagle.class, new double[]{6, 20, 3, 1, 100});
        ANIMAL_PARAMETERS.put(Horse.class, new double[]{400, 20, 4, 60, 100});
        ANIMAL_PARAMETERS.put(Deer.class, new double[]{300, 20, 4, 50, 100});
        ANIMAL_PARAMETERS.put(Rabbit.class, new double[]{2, 150, 2, 0.45, 100});
        ANIMAL_PARAMETERS.put(Mouse.class, new double[]{0.05, 500, 1, 0.01, 100});
        ANIMAL_PARAMETERS.put(Goat.class, new double[]{60, 140, 3, 10, 100});
        ANIMAL_PARAMETERS.put(Sheep.class, new double[]{70, 140, 3, 15, 100});
        ANIMAL_PARAMETERS.put(Boar.class, new double[]{400, 50, 2, 50, 100});
        ANIMAL_PARAMETERS.put(Buffalo.class, new double[]{700, 10, 3, 100, 100});
        ANIMAL_PARAMETERS.put(Caterpillar.class, new double[]{0.01, 1000, 0, 0, 100});
        ANIMAL_PARAMETERS.put(Duck.class, new double[]{1, 200, 4, 0.15, 100});

    }

    public static double getWeight(Class<? extends Animal> clazz) {
        double[] doubles = Data.ANIMAL_PARAMETERS.get(clazz);
        double d = doubles[0];
        return d;
    }

    public static double getMaxValueOnField(Class clazz) {
        double[] doubles = Data.ANIMAL_PARAMETERS.get(clazz);
        double d = doubles[1];
        return d;
    }

    public static double getMaxSpeed(Class clazz) {
        double[] doubles = Data.ANIMAL_PARAMETERS.get(clazz);
        double d = doubles[2];
        return d;
    }

    public static double getMaxFoodToFeedUp(Class clazz) {
        double[] doubles = Data.ANIMAL_PARAMETERS.get(clazz);
        double d = doubles[3];
        return d;
    }

    public static double getHealthPoints(Class clazz) {
        double[] doubles = Data.ANIMAL_PARAMETERS.get(clazz);
        double d = doubles[4];
        return d;
    }

    public static double setHealthPoints(Class clazz) {
        double[] doubles = Data.ANIMAL_PARAMETERS.get(clazz);
        doubles[4] = doubles[4] - 25;
        double d = doubles[4];
        return d;
    }

    public static void setFullHPBar(Class clazz) {
        double[] doubles = Data.ANIMAL_PARAMETERS.get(clazz);
        doubles[4] = 100;
    }





}
