package com.example.vinnsla;

import java.util.ArrayList;
import java.util.Arrays;

/**
* Bingospjald klasinn útfærir skilin í BingospjaldInterface
* og er að auki með private tilviksbreytu sem nýtist í Controller
*
* @author Svana Kristín Elísdóttir, ske12@hi.is
 */

public class Bingospjald implements BingospjaldInterface{
    private final int[][] spjald;

    public Bingospjald() {
        spjald = nyttSpjald();
    }

    public int[][] getSpjald() {
        return spjald;
    }


    /**
     * Talan á reit (i,j) hefur verið lesin upp. Reiturinn er merktur sem -1 í
     fylkinu.
     * Forskilyrði - (i,j) er innan marka bingóspjaldsins - óþarfi að tékka
     sérstaklega
     *
     * @param i
     * @param j
     */
    @Override
    public void aReit(int i, int j) {
        spjald[i][j] = -1;
    }

    /**
     * bý til tvívítt fylki inní initialize inní controller
     * og skila því þar
     * Frumstillir bingóspjald með tölum af handahófi
     *
     * @return skilar fylkinu með gögnum bingóspjaldsins
     */
    @Override
    public int[][] nyttSpjald() {
        int [][] spjald = new int[5][5];
        spjald = random();
        return spjald;
    }

    /**
     * Athugar hvort það er bingó í hornalínu spjaldsins, báðum
     * hornalínum spjaldsins, ystu línum spjaldsins eða öllu
     * spjaldinu.
     *
     * @return true ef það er bingo annars false
     */
    @Override
    public boolean erBingo(String gerd) {
        switch(gerd){
            case "Velja1":
                int x = 0;
                int y = 0;
                for (int i = 0; i < 5; i++) {
                    if(spjald[i][i] ==-1)x++;
                    if(spjald[4-i][i] ==-1)y++;
                    //if (spjald[i][i] != -1 && spjald[4-i][i]!=-1) return false;
                } return (y==5 || x==5);
            case "Velja2":
                for(int i = 0; i< 5;i++){
                    if(spjald[i][i]!=-1 || spjald[4-i][i]!=-1) return false;
                } return true;
            case "Velja3":
                int k = 0;
                int l = 4;
                for (int i = 0; i < 5; i++) {
                    if (spjald[k][i] != -1 || spjald[i][k] != -1) return false;
                }
                for (int j = 0; j < 5; j++) {
                    if (spjald[l][j] != -1 || spjald[j][l] != -1) return false;
                    }
                return true;
            case "Velja4":
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if(spjald[i][j]!=-1) return false;
                    }
                } return true;
        }
                return false;
    }

    /**
     * Býr til tvívítt 5x5 stórt slembitölufylki úr efstu línu bingóspjalds
     * og ítrar svo gegnum spjaldið línu fyrir línu. Tölurnar skipta sér eins
     * og á venjubundnu bingóspjaldi, fyrir B eru tölur frá 1 upp í 15 o.s.frv.
     * @return tvívítt slembitölufylki
     */
    private static int[][] random() {
        int[][] bingoTolur = new int[5][5];
        for (int i = 0; i < 5; i++) {
            ArrayList<Integer> tolur = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
            for (int j = 0; j < 5; j++) {
                int rand = (int)(Math.random()*tolur.size());
                bingoTolur[i][j] = tolur.get(rand)+i*15;
                tolur.remove(rand);
            }
        }
            return bingoTolur;
    }
}
