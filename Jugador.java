import java.io.*;
public class Jugador {
    BufferedReader libro=new BufferedReader(new InputStreamReader(System.in));

    String player1, player2;
    String dato;
    String[][] table1=new String[9][9];//tablero para jugador 1
    String[][] table2=new String[9][9];//tablero para jugador 2

    int nbarco[]={2,1,1};
    int barco[]={2,3,4};
    String[] ilustracion={"00","000","0000"};



    //INGRESAR NOMBRES DE JUGADORES
    public void Nombres() throws IOException{
        System.out.println("Ingrese jugador 1:");
        player1 = libro.readLine();
        System.out.println("Ingrese jugador 2:");
        player2 = libro.readLine();
    }

    //METODO CREAR TABLERO

    public void Tablero(String table[][]){
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

        char arreglo1 []= {'A','B','C','D','E','F','G','H','I'};
        System.out.print("      1     2     3     4     5     6     7     8     9 \n");
        for(int i=0;i<table.length;i++){
            System.out.printf("\n %s",arreglo1[i]);
            for(int j=0;j<table.length;j++){
                System.out.printf("%5s ",table[i][j]+" ");

        for(int i=0;i<table.length;i++){
            for(int j=0;j<table.length;j++){
                System.out.print(table[i][j]+" ");

            }
            System.out.println();
        }
    }

    //METODO PARA TAMAÑO DE BARCO
    public int TamañoBarco(String[] b)throws IOException{
        int t=0;
        Boolean n=true;
        while(n){
            System.out.println("Tamaño de barcos disponibles disponibles:\n2:"+b[0]+"\n3:"+b[1]+"\n4:"+b[2]);
            System.out.println("Escoga el tamaño del barco");
            t=Integer.parseInt(libro.readLine());
            if(t>1 & t<5){//comprobar que sea un tamaño de barco real
                for(int i=0;i<3;i++){
                    if(t==barco[i] & nbarco[i]>0){//identificar tamaño de barco
                        n=false;
                        nbarco[i]=nbarco[i]-1;
                        if(nbarco[i]==0){
                            b[i]="-";
                        }
                        break;
                    }
                }
            }else{
                System.out.println("Introduzca un tamaño de barco disponible");
            }
        }
        return t;
    }
    //METODO PARA BARCO HORIZONTAL
    public int BarcoH(String table[][],int tam_barco,int i, int j,int n){
        Boolean barco=true;
        if(j+tam_barco>table.length){ //Condicional si se pasa del tablero
            System.out.println("***NO HAY ESPACIO SUFICIENTE***");
            barco=false;
            n=n-1;
        }
        if(barco){  //condicional si ya hay un barco en el tablero
            for(int l=0;l<tam_barco;l++){
                if(table[i][j+l].equals("0")){
                    System.out.println("Ya hay un barco");
                    barco=false;
                    n=n-1;
                    break;
                }
            }
        }
        if(barco){ //condicional que crea el barco y guarda
            for(int k=0;k<tam_barco;k++){
                table[i][j+k]="0";
            }
        }
        return n;
    }
    
    
    //METODO PARA BARCO VERTICAL
    public int BarcoV(String table[][],int tam_barco,int i, int j,int n){
        Boolean barco=true;
        if(i+tam_barco>table.length){
            System.out.println("***NO HAY ESPACIO SUFICIENTE***");
            barco=false;
            n=n-1;
        }
        if(barco){
            for(int l=0;l<tam_barco;l++){
                if(table[i+l][j].equals("0")){
                    System.out.println("Ya hay un barco");
                    barco=false;
                    n=n-1;
                    break;
                }
            }
        }
        if(barco){
            for(int k=0;k<tam_barco;k++){
                table[i+k][j]="0";
            }
        }
        return n;


    //METODO PARA BARCO HORIZONTAL
    public String[][] BarcoH(String table[][],int tam_barco,int i, int j){
        if(j+tam_barco>table.length){
            System.out.println("exceso");
            return table;
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

