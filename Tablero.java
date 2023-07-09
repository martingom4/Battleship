/*
 * Integrantes:
 * - David Zhang
 * - Nicole Bustamante
 * - Anilys Rodriguez
 * - Martin Gomez
 */

public class Tablero{
    //METODO CREAR TABLERO
    public void CrearTablero(String table[][]){
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table.length;j++){
                table[i][j]="-";
            }//fin de for
        }//fin de for
    }

    // METODO PARA IMPRIMIR EL TABLERO
    public void MostrarTablero(String[][] tablero) {
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        System.out.println("  ╔═══════════════════════════╗");
        System.out.println("  \u2551 1  2  3  4  5  6  7  8  9 \u2551");
        System.out.println("  ╠═══════════════════════════╣");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(letras[i] + " \u2551");
            
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(" " + tablero[i][j] + " ");
            }//fin de for
            
            System.out.println("\u2551");
        }//fin de for
        
        System.out.println("  ╚═══════════════════════════╝");
    }
}
