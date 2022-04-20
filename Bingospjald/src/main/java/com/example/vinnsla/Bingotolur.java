package com.example.vinnsla;

import java.util.HashSet;
import java.util.Random;

/***
 * Klasinn birtir nýjar tölur og bókstaf með eftir því sem
 * við á, innan í hring við hliðina á bingóspjaldinu.
 *
 * @author Svana Kristín Elísdóttir, ske12@hi.is
 */
public class Bingotolur {
    private HashSet<Integer> tolurnar;

    public Bingotolur() {
        tolurnar = new HashSet<>();
    }

    public String tala() {
        Random r = new Random();
        String s;
        while(true) {
            if(tolurnar.size() > 74) return null;
            int j = r.nextInt(75)+1;
            if (!tolurnar.contains(j)) {
                tolurnar.add(j);
                if (j > 60) {
                    s = "O" + j;
                }
                else if( j > 45) {
                    s = "G" + j;
                }
                else if(j > 30) {
                    s = "N" + j;
                }
                else if(j > 15) {
                    s = "I" + j;
                }
                else {
                    s = "B" + j;
                }
                break;
            }
        }
        return s;
    }
}
