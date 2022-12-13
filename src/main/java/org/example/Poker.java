package org.example;

import java.util.Random;
import java.util.HashMap;

public class Poker {
    public final static String[] cartas = { "AS", "AC", "AH", "AD",
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
            "KS", "KC", "KH", "KD", };

    private String[] mano;

    public Poker() {
        mano = new String[5];
        mano[0] = "";
        mano[1] = "";
        mano[2] = "";
        mano[3] = "";
        mano[4] = "";
    }

    public boolean validarCarta(int num) {
        for (String e : mano) {
            if (e.equals(cartas[num])) {
                return false;
            }
        }
        return true;
    }

    public String getMano() {
        // generarMano();
        String cad = "";
        if (isEscalera() && isColor()) {
            cad = "ESCALERA COLOR";
        } else if (isPoker()) {
            cad = "POKER";
        } else if (isTrio() && isPar()) {
            cad = "FULL";
        } else if (isColor()) {
            cad = "COLOR";
        } else if (isEscalera()) {
            cad = "ESCALERA";
        } else if (isTrio()) {
            cad = "TRIO";
        } else if (isDoblePar()) {
            cad = "DOBLE PAR";
        } else if (isPar()) {
            cad = "PAR";
        } else {
            cad = cartaAlta();
        }

        return toString() + " -----> " + cad;
    }

    private boolean isDoblePar() {
        int[] valores = getValues();
        boolean band = false;
        for (int e : valores) {
            if (e == 2) {
                if (band) {
                    return true;
                }
                band = true;
            }
        }
        return false;
    }

    private String cartaAlta() {
        String[] nombres = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "AS" };
        int k = 0;
        Character c = 'C';
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('2', 0);
        map.put('3', 1);
        map.put('4', 2);
        map.put('5', 3);
        map.put('6', 4);
        map.put('7', 5);
        map.put('8', 6);
        map.put('9', 7);
        map.put('T', 8);
        map.put('J', 9);
        map.put('Q', 10);
        map.put('K', 11);
        map.put('A', 12);
        for (String e : mano) {
            if (map.get(e.toCharArray()[0]) > k) {
                k = map.get(e.toCharArray()[0]);
                c = e.toCharArray()[1];
            }
        }
        HashMap<Character, String> colores = new HashMap<Character, String>();
        colores.put('C', " DE TREBOL");
        colores.put('S', " DE ESPADAS");
        colores.put('H', " DE CORAZONES");
        colores.put('D', " DE DIAMANTES");
        return nombres[k] + colores.get(c);
    }

    private boolean isPoker() {
        int[] valores = getValues();
        for (int e : valores)
            if (e == 4)
                return true;
        return false;
    }

    private boolean isTrio() {
        int[] valores = getValues();
        for (int e : valores)
            if (e == 3)
                return true;
        return false;
    }

    private boolean isPar() {
        int[] valores = getValues();
        for (int e : valores)
            if (e == 2)
                return true;
        return false;
    }

    private int[] getValues() {
        int[] valores = new int[13];
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('2', 1);
        map.put('3', 2);
        map.put('4', 3);
        map.put('5', 4);
        map.put('6', 5);
        map.put('7', 6);
        map.put('8', 7);
        map.put('9', 8);
        map.put('T', 9);
        map.put('J', 10);
        map.put('Q', 11);
        map.put('K', 12);
        for (String e : mano) {
            valores[map.get(e.toCharArray()[0])]++;
        }
        return valores;
    }

    private boolean isEscalera() {
        int k = 0, car = 0, i = 0;
        int[] valores = getValues();
        while (car < 5) {
            if (valores[i] > 0) {
                car++;
                if (valores[i] != 1) {
                    k = 0;
                } else {
                    k++;
                }
            } else {
                k = 0;
            }
            i++;
            if (i == 13) {
                if (k == 4 && valores[0] == 1) {
                    return true;
                }
                i = 0;
            }
            if (k == 5) {
                return true;
            }
        }
        return k == 5;
    }

    private boolean isColor() {
        char c = mano[0].toCharArray()[1];
        for (String e : mano) {
            if (c != e.toCharArray()[1]) {
                return false;
            }
        }
        return true;
    }

    public void generarMano() {
        Random rd = new Random();
        int k = 0, num = 0;
        while (k < 5) {
            num = rd.nextInt(52);
            if (validarCarta(num)) {
                mano[k] = cartas[num];
                k++;
            }
        }
    }

    public void setMano(String a, String b, String c, String d, String e) {
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
        game.setMano("AD", "2D", "3D", "4D", "5D");
        System.out.println(game.getMano());
        game.setMano("TS", "JS", "QS", "KS", "AS");
        System.out.println(game.getMano());
        game.setMano("QS", "KS", "AS", "2S", "3S");
        System.out.println(game.getMano());
        game.setMano("AS", "AC", "AH", "AD", "3S");
        System.out.println(game.getMano());
        game.setMano("3S", "3C", "3H", "3D", "4S");
        System.out.println(game.getMano());
        game.setMano("2S", "AC", "2H", "2D", "3S");
        System.out.println(game.getMano());
        game.setMano("2S", "2C", "2H", "3D", "3S");
        System.out.println(game.getMano());
        game.setMano("2S", "2C", "4H", "5D", "3S");
        System.out.println(game.getMano());
        game.setMano("2S", "2C", "4H", "3D", "3S");
        System.out.println(game.getMano());
        game.setMano("4S", "5C", "7H", "6D", "8S");
        System.out.println(game.getMano());
        game.setMano("AS", "2C", "4H", "6D", "8S");
        System.out.println(game.getMano());

        System.out.println("\n--------- GENERANDO MANOS ALEATORIAS ---------");
        for (int k = 0; k < 50; k++) {
            game.generarMano();
            System.out.println(game.getMano());
        }
    }
}
