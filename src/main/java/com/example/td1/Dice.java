package com.example.td1;

import org.springframework.stereotype.Component;

@Component
public class Dice {
    private final int nbFaces;

    public Dice() {
        this.nbFaces = 6;
    }

    public Dice(int nbFaces) {
        this.nbFaces = nbFaces;
    }

    public int roll() {
        return (int) (Math.random() * nbFaces) + 1;
    }
}
