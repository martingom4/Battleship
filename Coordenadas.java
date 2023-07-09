/*
 * Integrantes:
 * - David Zhang
 * - Nicole Bustamante
 * - Anilys Rodriguez
 * - Martin Gomez
 */

public class Coordenadas {
    int x, y, i;
    Barco boat = new Barco();
    String[]coordenadas1=new String[4];//arreglo que guarda las coordenadas
    String[]coordenadas2=new String[4];
    String[]coordenadas3=new String[4];
    String[]coordenadas4=new String[4];
         
        
    //METODO PARA CORDENADAS EN Y
    public int CoordenadasY(String coordenada[], int i)  {
        int num;
        int y;
        try {
            if (coordenada[i] != null) {  // Verificar si la cadena no es nula
                num = Integer.parseInt(coordenada[i].substring(1));
                if (num > 0 && num < 11) {
                    y = num - 1;
                } else {
                    y = -1;
                }//fin de if else
            } else {
                y = -1;
            }//fin de if else
        } catch (Exception e) {
            y = -1;
        }//fin de try catch
        return y;
    }

    //METODO PARA COORDENADAS EN X
    public int CoordenadasX(String coordenada[],int i){
        String letra;
        int x;
        letra=coordenada[i].substring(0, 1).toUpperCase();
        if(letra.equals("A") || letra.equals("a")){
            x=0;
        }else if(letra.equals("B") || letra.equals("b")){
            x=1;
        }else if(letra.equals("C") || letra.equals("c")){
            x=2;
        }else if(letra.equals("D") || letra.equals("d")){
            x=3;
        }else if(letra.equals("E") || letra.equals("e")){
            x=4;
        }else if(letra.equals("F") || letra.equals("f")){
            x=5;
        }else if(letra.equals("G") || letra.equals("g")){
            x=6;
        }else if(letra.equals("H") || letra.equals("h")){
            x=7;
        }else if(letra.equals("I") || letra.equals("i")){
            x=8;
        }else if(letra.equals("J") || letra.equals("j")){
            x=9;
        }else{
            x=-1;
        }//fin de if else
        return x;
    }

    //METODO PARA GUARDAR COORDENADAS
    public String[] GuardarCoords(String dato, String[]coordenada,int i){
        coordenada[i]=dato;
        x=CoordenadasX(coordenada,i);
        y=CoordenadasY(coordenada,i);
        return coordenada;
    }

}