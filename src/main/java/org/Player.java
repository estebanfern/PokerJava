package org;

import java.util.Random;

public class Player {
    public static String[] cartas =  {"AS", "AC", "AH", "AD",
                                "2S", "2C", "2H", "2D",
                                "3S", "3C", "3H", "3D",
                                "4S", "4C", "4H", "4D",
                                "5S", "5C", "5H", "5D",
                                "6S", "6C", "6H", "6D",
                                "7S", "7C", "7H", "7D",
                                "8S", "8C", "8H", "8D",
                                "9S", "9C", "9H", "9D",
                                "TS", "TC", "TH", "TD",
                                "JS", "JC", "JH", "JD",
                                "QS", "QC", "QH", "QD",
                                "KS", "KC", "KH", "KD",};

    public String [] mano;

    public Player() {
        Random rd = new Random();
        int k = 0, num;
        mano = new String[2];
        mano[0] = "";
        mano[1] = "";
        while (k <= 1) {
            num = rd.nextInt(52);
            if (k == 0){
                mano[0] = cartas[num];
                k++;
            }else if (!mano[0].equals(cartas[num])){
                mano[1] = cartas[num];
                k++;
            }
        }
    }
    
    public Player(Player jugador) {
        Random rd = new Random();
        int k = 0, num;
        mano = new String[2];
        mano[0] = "";
        mano[1] = "";
        while (k <= 1) {
            num = rd.nextInt(52);
            if (k == 0 && !jugador.mano[0].equals(cartas[num]) && !jugador.mano[0].equals(cartas[num])){
                mano[0] = cartas[num];
                k++;
            }else if (!mano[0].equals(cartas[num]) && !jugador.mano[0].equals(cartas[num]) && !jugador.mano[0].equals(cartas[num])){
                mano[1] = cartas[num];
                k++;
            }
        }
    }

    public boolean validar(int num) {
        return (!mano[0].equals(cartas[num]) && !mano[0].equals(cartas[num]));
    }

}
