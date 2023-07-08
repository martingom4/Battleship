import java.io.*;
public class Jugador {
    static BufferedReader libro=new BufferedReader(new InputStreamReader(System.in));
    //Barco boat=new Barco();
    String Nombre;
    String table[][] = new String[9][9];
    String shot[][] = new String[9][9];

    //Metodo constructor
    public Jugador(int i) throws IOException{
        this.Nombre=Jugador.Nombres(i);
        this.table=CrearTablero();
        this.shot=CrearTablero();
    }

    //METODO PARA INGRESAR NOMBRES DE JUGADORES
    public static String Nombres(int i) throws IOException{
        System.out.println("Ingrese Nombre del Jugador "+i);
        String Name = libro.readLine();
        return Name;
    }
    //METODO CREAR TABLERO
    public String[][] CrearTablero(){
        String table[][] = new String[9][9];
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table.length;j++){
                table[i][j]="-";
            }
        }
        return table;
    }

    // METODO PARA IMPRIMIR EL TABLERO (poner en archivo tablero)
    public  void MostrarTablero(String table[][]){
        char letras []= {'A','B','C','D','E','F','G','H','I'};
        System.out.print("      1     2     3     4     5     6     7     8     9 \n");
        for(int i=0;i<table.length;i++){
            System.out.printf("\n %s",letras[i]);
            for(int j=0;j<table.length;j++){
                System.out.printf("%5s ",table[i][j]+" ");
            }
            System.out.println();
        }
    }
    //metodo para tablero de disparos sin mostrar posicion
    public String[][] NoMostrarPosicion(String tableroDisp[][], String[][] disparos){
        char letras []= {'A','B','C','D','E','F','G','H','I'};
        System.out.print("      1     2     3     4     5     6     7     8     9 \n");
        System.out.println("El tablero se ha actualizado ");
        for(int i=0;i<tableroDisp.length;i++){
            System.out.printf("\n %s",letras[i]);
            for(int j=0;j<tableroDisp.length;j++){
                //System.out.printf("%5s ",tableroDisp[i][j]+" ");
                if (disparos[i][j].equals("-")) {
                System.out.printf("%5s ",tableroDisp[i][j]+" ");
                }else{
                    System.out.println("~");
                }
            }
            System.out.println();
        }
        return disparos;
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

   
}
