import java.io.*;
public class Coordenadas {
        BufferedReader libro = new BufferedReader(new InputStreamReader(System.in));
        String player1, player2;
        String dato="";
        int x, y, i, t;
        boolean valido1, valido2;
        Boolean fin=false;
        String[]coordenadas1=new String[4];//arreglo que guarda las coordenadas
        String[]coordenadas2=new String[4];

    public int coordenadasy(String coordenada[],int i) throws IOException{
        int num;
        int y;
        try{
            num=Integer.parseInt(coordenada[i].substring(1));
            if (num>0 && num<11){
                y=num-1;
            }else{
                y=-1;
            }
        }catch(Exception e){
            y=-1;
        }
        return y;
    }

   public int coordenadasx(String coordenada [], int i){
        String letra;
        int x;
        letra=dato.substring(0, 1);
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
        }
        return x;
    }
    
    public String[] coor(String[]coordenada,int i) throws IOException{
        System.out.println("Inserte coordenadas");
        coordenada[i]=libro.readLine();
        x=coordenadasx(coordenada,i);
        y=coordenadasy(coordenada,i);
        return coordenada;
    }

}

