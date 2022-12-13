package org.example;

import java.util.Random;

public class Poker {
    private static String [] cartas = {"AS", "AC", "AH", "AD",
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

    String [] player1;
    String [] player2;

    public Poker(){
        player1 = new String[2];
        player2 = new String[2];
    }

    public void run(){
        String [] players = generarJugadores();
        player1[0] = players[0];
        player1[1] = players[1];
        player2[0] = players[2];
        player2[1] = players[3];
        System.out.println(player1[0] + player1[1]);
        System.out.println(player2[0] + player2[1]);
    }
    
    public static String[] generarJugadores() {
        Random rd = new Random();
        String [] jg = new String[4];
        int k = 0, num;
        do {
            num = rd.nextInt(53);
            if (validarCartaPlayer(jg, num)){
                jg[k] = cartas[num];
                k++;
            }
        } while (jg[3].equals(""));
        return jg;
    }
    
    public static boolean validarCartaPlayer(String[] jugadores, int num){
        boolean val = true;
        for (String e : jugadores) {
            if (e.equals(cartas[num])){
                val = false;
            }
        }
        return val;
    }
    
    public static void main(String[] args) {
        Poker game = new Poker();
        game.run();
    }
    
    
    

}



