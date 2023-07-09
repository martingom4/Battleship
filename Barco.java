/*
 * Integrantes:
 * - David Zhang
 * - Nicole Bustamante
 * - Anilys Rodriguez
 * - Martin Gomez
 */

import java.io.*;
public class Barco {
    BufferedReader libro = new BufferedReader(new InputStreamReader(System.in));

    int nbarco1[]={2,1,1};
    int nbarco2[]={2,1,1};
    int barco1[]={2,3,4};
    int barco2[]={2,3,4};
    String[] ilustracion1={"00","000","0000"};
    String[] ilustracion2={"00","000","0000"};
    String[] direccion1=new String[4];//arreglo que guarda la direccion Horizontal o vertical del jugador 1
    String[] direccion2=new String[4];

    int[] size1=new int[4]; // arreglo que guarda los tamños de los barcos del jugador 1
    int[] size2=new int[4];


    //METODO PARA BARCO HORIZONTAL
    public Boolean BarcoH(String table[][],int[] tam_barco,int i, int j,int n,String[]sentido){
        Boolean barco=true;
        if(j+tam_barco[n]>table.length){ //Condicional si se pasa del tablero
            System.out.println("***NO HAY ESPACIO SUFICIENTE***");
            barco=false;
            n=n-1;
        }//fin de if
        if(barco){  //condicional si ya hay un barco en el tablero
            for(int l=0;l<tam_barco[n];l++){
                if(table[i][j+l].equals("0")){
                    System.out.println("Ya hay un barco");
                    barco=false;
                    n=n-1;
                    break;
                }//fin de if
            }//fin de for
        }//fin de if
        if(barco){ //condicional que crea el barco y guarda
            for(int k=0;k<tam_barco[n];k++){
                table[i][j+k]="0";
            }//fin de for
            System.out.println("Barco guardado exitosamente");
            sentido[n]="HORIZONTAL";
        }//fin de if
        return barco;
    }
    
    //METODO PARA BARCO VERTICAL
    public Boolean BarcoV(String table[][],int[] tam_barco,int i, int j,int n,String[]sentido){
        Boolean barco=true;
        if(i+tam_barco[n]>table.length){
            System.out.println("***NO HAY ESPACIO SUFICIENTE***");
            barco=false;
            n=n-1;
        }//fin de if
        if(barco){
            for(int l=0;l<tam_barco[n];l++){
                if(table[i+l][j].equals("0")){
                    System.out.println("Ya hay un barco");
                    barco=false;
                    n=n-1;
                    break;
                }//fin de if
            }//fin de for
        }//fin de if
        if(barco){
            for(int k=0;k<tam_barco[n];k++){
                table[i+k][j]="0";
            }//fin de for
            System.out.println("Barco guardado exitosamente");
            sentido[n]="VERTICAL";
        }//fin de if
        return barco;
    }

    //METODO PARA ESCOGER TAMAÑO
    public int[] TamañoBarco(String[] ilus,int[]tam,int i,int[]nbarco,int[]barco)throws IOException{
        Boolean b=true;
        while(b){
            System.out.println("Tamaño de barcos disponibles :\n2:"+ilus[0]+"\n3:"+ilus[1]+"\n4:"+ilus[2]);
            System.out.println("Escoga el tamaño del barco");
            tam[i]=Integer.parseInt(libro.readLine());
            if(tam[i]>1 & tam[i]<5){//comprobar que sea un tamaño de barco real
                for(int j=0;j<3;j++){
                    if(tam[i]==barco[j] & nbarco[j]>0){//identificar tamaño de barco
                        b=false;
                        nbarco[j]=nbarco[j]-1;
                        if(nbarco[j]==0){//cuando no hay barco disponible, se elimina la ilustracion
                            ilus[j]="-";
                        }//fin de if
                        break;
                    }//fin de if
                }//fin de for
            }else{
                System.out.println("Introduzca un tamaño de barco disponible");
            }//fin de if else
        }//fin de while b
        return tam;
    }

    //METODO PARA MOSTRAR LISTA DE BARCOS
    public void ListaBarcos(int[] tamaños, String[] coordenadas, String[] direcciones) {
        for (int i = 0; i < 4; i++) {
            System.out.println("Barco " + (i + 1) + ":");
            System.out.println("Tamaño: " + tamaños[i]);
            System.out.println("Posición: " + coordenadas[i]);
            System.out.println("Orientación: " + direcciones[i]);
            System.out.println();
        }//fin de for
    }

    //METODO PARA VERIFICAR QUE TODOS LOS BARCOS SE HAN HUNDIDO
    public boolean TodosBarcosHundidos(String[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j].equals("0")) {
                    return false; //si encuentra barcos, retorna false
                }//fin de if
            }//fin de for
        }//fin de for
        return true; //si no encuentra barcos, retorna true
    }


}