package com.javarush.island.demyanov;

import lombok.Getter;

@Getter
public class Fox extends Predator{
    private int weight = 8;

    private int maxSpeed = 2;

    private int foodAmount = 2;
}
