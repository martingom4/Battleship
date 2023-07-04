import java.io.*;
public class coordenadas {
        BufferedReader libro = new BufferedReader(new InputStreamReader(System.in));
        String player1, player2;
        String dato="";
        int x, y, i, t;
        boolean valido1, valido2;
        Boolean fin=false;
        String[]coordenadas1=new String[3];//arreglo que guarda las coordenadas
        String[]coordenadas2=new String[3];

    public int coordenadasy(String coordenada[],int i,int y) throws IOException{
        int num;
        
        try{
            num=Integer.parseInt(coordenada[i].substring(1));
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

    public int coordenadasx(String coordenada[],int i,int x){
        String letra;
        
        letra=coordenada[i].substring(0, 1);
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
    public void coor(int i,String[]coordenada,int x, int y) throws IOException{
        System.out.println("Inserte coordenadas");
        coordenada[i]=libro.readLine();
           
    }

}

