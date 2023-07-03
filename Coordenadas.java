import java.io.*;

public class Coordenadas {
    public int coordenadasy(String dato) throws IOException{
        int num;
        int y;
        try{
            num=Integer.parseInt(dato.substring(1));
            if (0<num && num<11){
                y=num-1;
            }else{
                y=-1;
            }
        }catch(Exception e){
            y=-1;
        }
        return y;
    }

    public int coordenadasx(String dato){
        String letra;
        int x;
        letra=dato.substring(0, 1);
        switch(letra){
            case "A":
                x=0;
            break;
            
            case "B":
                x=1;
            break;
            
            case "C":
                x=2;
            break;
            
            case "D":
                x=3;
            break;
            
            case "E":
                x=4;
            break;
            
            case "F":
                x=5;
            break;
            
            case "G":
                x=6;
            break;
            
            case "H":
                x=7;
            break;
            
            case "I":
                x=8;
            break;
            
            case "J":
                x=9;
            break;
            
            default:
                x=-1;
            break;
        }
        return x;
    }
}
