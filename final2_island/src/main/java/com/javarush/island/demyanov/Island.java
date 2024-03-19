package com.javarush.island.demyanov;


public class Island {

    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        Wolf wolf2 = new Wolf();
        Bear bear = new Bear();
        Bear bear2 = new Bear();


        wolf.move();
        wolf.eat();



//        Creator.createAnimals.forEach(System.out::println);


    }
}

