/*
 * Integrantes:
 * - David Zhang
 * - Nicole Bustamante
 * - Anilys Rodriguez
 * - Martin Gomez
 */

import java.io.*;
public class Jugador {
    BufferedReader libro=new BufferedReader(new InputStreamReader(System.in));
    String player1, player2;
    int x,y;
    Coordenadas c= new Coordenadas();

    String[][] table1=new String[9][9];//tablero para jugador 1
    String[][] table2=new String[9][9];//tablero para jugador 2
    String[][] table3=new String[9][9];// tablero para hacer los disparos del jugador 1 
    String[][] table4=new String[9][9];// tablero para hacer los disparos del jugador 2 
   

    //INGRESAR NOMBRES DE JUGADORES
    public void IngresarNombres() throws IOException{
        System.out.println("Ingrese jugador 1:");
        player1 = libro.readLine();
        System.out.println("Ingrese jugador 2:");
        player2 = libro.readLine();
        
    }

    //METODO PARA DISPARAR
    public boolean Disparar(String[][] table,String[][] table_d, String[] coordenada, int i){
        boolean valido = false;
        x=c.CoordenadasX(coordenada, i);
        y=c.CoordenadasY(coordenada, i);
        if (x >= 0 && x < table.length && y >= 0 && y < table[0].length) { // se verifica que este dentro del tamaño del arreglo 
            if (table[x][y].equals("-")) {
                System.out.println("Agua");
                table_d[x][y] = "f";
                valido=true;
            }else if (table_d[x][y].equals("f")) { // se verifica si ya se hizo el disparo en ese lugar 
                System.out.println("Ya has disparado aquí antes");
            } else if (table_d[x][y].equals("X")) { // se verifica si ya se hizo el disparo en ese lugar 
                System.out.println("Ya has disparado aquí antes");
            }else if (table[x][y].equals("0")) {
                System.out.println("Has impactado un barco");
                table_d[x][y] = "X"; // Marcar como impacto en un barco con "X"
                table[x][y] = "\u25A0"; //se cambiara por el 0
                valido=true;
                
            }//fin de if else
           
        } else {
            System.out.println("Coordenadas inválidas");
        }//fin de if else
        return valido;
    }

}