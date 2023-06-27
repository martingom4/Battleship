import java.io.*;
public class Jugador {
    BufferedReader libro=new BufferedReader(new InputStreamReader(System.in));

    String player1, player2;
    String dato;
    String[][] table1=new String[9][9];//tablero para jugador 1
    String[][] table2=new String[9][9];//tablero para jugador 2


    //INGRESAR NOMBRES DE JUGADORES
    public void Nombres() throws IOException{
        System.out.println("Ingrese jugador 1:");
        player1 = libro.readLine();
        System.out.println("Ingrese jugador 2:");
        player2 = libro.readLine();
    }

    //METODO CREAR TABLERO
    public String[][] Tablero(String table[][]){
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table.length;j++){
                table[i][j]="-";
            }
        }
        return table;
    }

    // METODO PARA IMPRIMIR EL TABLERO
    public void MostrarTablero(String table[][]){
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table.length;j++){
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }
    }

    //METODO PARA BARCO HORIZONTAL
    public String[][] BarcoH(String table[][],int tam_barco,int i, int j){
        if(j+tam_barco>table.length){
            System.out.println("exceso");
            return table;
        }else if(int i=0){

        }else{
            for(int k=0;k<tam_barco;k++){
                table[i][j+k]="0";
            }
            return table;
        }
    }
    
    //METODO PARA BARCO VERTICAL
    public String[][] BarcoV(String table[][],int tam_barco,int i, int j){
        if(j+tam_barco>table.length){
            System.out.println("exceso");
            return table;
        }else{
            for(int k=0;k<tam_barco;k++){
                table[i+k][j]="0";
            }
            return table;
        }
    }

    //METODO PARA DISPARO
    public void Ataque(String table[][],int i, int j){
        if(table[i][j].equals("0")){
            table[i][j]="X";
            System.out.println("Disparo Acertado");
        }else{
            table[i][j]="f";
            System.out.println("Fallaste");
        }

    }
}

