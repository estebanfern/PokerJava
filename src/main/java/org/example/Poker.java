package org.example;

import java.util.Random;
import java.util.HashMap;

public class Poker {
    public final static String[] cartas =  {"AS", "AC", "AH", "AD",
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


    private String [] mano;

    public Poker() {
        mano = new String[5];
        mano[0] = "";
        mano[1] = "";
        mano[2] = "";
        mano[3] = "";
        mano[4] = "";
    }
    
    
    
    public boolean validarCarta(int num) {
        for (String e : mano){
            if (e.equals(cartas[num])){
                return false;
            }
        }
        return true;
    }

    public String getMano(){
        //generarMano();
        String cad = ""; 
        if (isEscalera() && isColor()){
            cad = "ESCALERA COLOR";
        }

        return toString() + " -----> " + cad;
    }

    private boolean isEscalera(){
        int [] valores = new int[13];
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("A", 0);
        map.put("2", 1);
        map.put("3", 2);
        map.put("4", 3);
        map.put("5", 4);
        map.put("6", 5);
        map.put("7", 6);
        map.put("8", 7);
        map.put("9", 8);
        map.put("T", 9);
        map.put("J", 10);
        map.put("Q", 11);
        map.put("K", 12);
        



        return true;
    }

    private boolean isColor(){
        char c = mano[0].toCharArray()[1];
        for (String e : mano){
            if (c != e.toCharArray()[1]){
                return false;
            }
        }
        return true;
    }
    
    public void generarMano(){
        Random rd = new Random();
        int k = 0, num = 0;
        while(k < 5){
            num = rd.nextInt(52);
            if (validarCarta(num)){
                mano[k] = cartas[num];
                k++;
            }
        }
    }

    public void setMano(String a, String b, String c, String d, String e){
        mano[0] = a;
        mano[1] = b;
        mano[2] = c;
        mano[3] = d;
        mano[4] = e;
    }

    @Override
    public String toString() {
        return String.format("[ %s\t%s\t%s\t%s\t%s ]", mano[0], mano[1], mano[2], mano[3], mano[4]);
    }
    
    public static void main(String[] args) {
        Poker game = new Poker();
        game.setMano("2S", "3S", "4S", "5S", "6S");
        System.out.println(game.getMano());
    }
}
