import java.io.*;
public class Jugador {
    BufferedReader libro=new BufferedReader(new InputStreamReader(System.in));
    Barco boat=new Barco();
    String player1, player2;
    String dato;
    int x,y;
    String[][] table1=new String[9][9];//tablero para jugador 1
    String[][] table2=new String[9][9];//tablero para jugador 2
    String[][] table3=new String[9][9];// tablero para hacer los disparos del jugador 1 
    String[][] table4=new String[9][9];// tablero para hacer los disparos del jugador 2 
   



    //INGRESAR NOMBRES DE JUGADORES
    public void Nombres() throws IOException{
        System.out.println("Ingrese jugador 1:");
        player1 = libro.readLine();
        System.out.println("Ingrese jugador 2:");
        player2 = libro.readLine();
        
    }
    //METODO CREAR TABLERO
    public void Tablero(String table[][]){
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table.length;j++){
                table[i][j]="-";
            }
        }
    }

    // METODO PARA IMPRIMIR EL TABLERO (poner en archivo tablero)
    public String[][] MostrarTablero(String table[][]){
        char letras []= {'A','B','C','D','E','F','G','H','I'};
        System.out.print("      1     2     3     4     5     6     7     8     9 \n");
        for(int i=0;i<table.length;i++){
            System.out.printf("\n %s",letras[i]);
            for(int j=0;j<table.length;j++){
                System.out.printf("%5s ",table[i][j]+" ");
            }
            System.out.println();
        }
        return table;
    }
    
    //METODO PARA BARCO HORIZONTAL
    public Boolean BarcoH(String table[][],int[] tam_barco,int i, int j,int n,String[]sentido){
        Boolean barco=true;
        if(j+tam_barco[n]>table.length){ //Condicional si se pasa del tablero
            System.out.println("***NO HAY ESPACIO SUFICIENTE***");
            barco=false;
            n=n-1;
        }
        if(barco){  //condicional si ya hay un barco en el tablero
            for(int l=0;l<tam_barco[n];l++){
                if(table[i][j+l].equals("0")){
                    System.out.println("Ya hay un barco");
                    barco=false;
                    n=n-1;
                    break;
                }
            }
        }
        if(barco){ //condicional que crea el barco y guarda
            for(int k=0;k<tam_barco[n];k++){
                table[i][j+k]="0";
            }
            System.out.println("Barco guardado exitosamente");
            sentido[n]="HORIZONTAL";
        }
        return barco;
    }
    
    //METODO PARA BARCO VERTICAL
    public Boolean BarcoV(String table[][],int[] tam_barco,int i, int j,int n,String[]sentido){
        Boolean barco=true;
        if(i+tam_barco[n]>table.length){
            System.out.println("***NO HAY ESPACIO SUFICIENTE***");
            barco=false;
            n=n-1;
        }
        if(barco){
            for(int l=0;l<tam_barco[n];l++){
                if(table[i+l][j].equals("0")){
                    System.out.println("Ya hay un barco");
                    barco=false;
                    n=n-1;
                    break;
                }
            }
        }
        if(barco){
            for(int k=0;k<tam_barco[n];k++){
                table[i+k][j]="0";
            }
            System.out.println("Barco guardado exitosamente");
            sentido[n]="VERTICAL";
        }
        return barco;
    }
    //metodo para disparar 
    public boolean Disparar(String[][] table,String[][] table_d, String[] coordenada, int i)throws IOException{
        boolean valido = false;
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
                table[x][y] = "$"; //se cambiara por el 0
                valido=true;
            }
           
        } else {
            System.out.println("Coordenadas inválidas");
        }
        return valido;
    }
   

   
}