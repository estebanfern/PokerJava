package org.example;

import java.util.Random;

import org.Player;

//import java.util.Random;

public class Poker {
    Player player1;
    Player player2;
    String[] mesa;

    public Poker(){
        player1 = new Player();
        player2 = new Player(player1);
        mesa = new String[5];
        for (int k = 0; k < 5; k++){
            mesa[k] = "";
        }
        generarMesa();
    }

    public void run(){
        System.out.println("run");
        System.out.printf("\nPlayer 1: %s %s", player1.mano[0], player1.mano[1]);
        System.out.printf("\nPlayer 2: %s %s", player2.mano[0], player2.mano[1]);
        System.out.printf("\nMesa: \t  %s %s %s %s %s", mesa[0], mesa[1], mesa[2], mesa[3], mesa[4]);
    }
    
    private void generarMesa() {
        int k = 0, num;
        Random rd = new Random();
        while (k<5) {
            num = rd.nextInt(52);
            if (validarCarta(num) && player1.validar(num) && player2.validar(num)){
                mesa[k] = Player.cartas[num];
                k++;
            }
        }
    }
    
    private boolean validarCarta(int num){
        boolean val = true;
        for (String e : mesa) {
            if (e.equals(Player.cartas[num])){
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



