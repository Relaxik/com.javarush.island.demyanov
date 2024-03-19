package com.javarush.island.demyanov;


import java.util.*;


public class Data {

    public static boolean isAlive = true;




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


    public static String getRandomName() {
        int random = Creator.randomizer(10);
        List<String> list = new ArrayList<>();
        list.add("Nikolay");
        list.add("Eugen");
        list.add("Vasgen");
        list.add("Ilyha");
        list.add("Inokentiy");
        list.add("Valera");
        list.add("Serioga");
        list.add("Slavka");
        list.add("Egor");
        list.add("Ryslan");

        return list.get(random);
    }


}
