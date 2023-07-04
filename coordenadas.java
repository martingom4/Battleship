import java.io.*;
public class coordenadas {
        BufferedReader libro = new BufferedReader(new InputStreamReader(System.in));
        String player1, player2;
        String dato="";
        int x, y, i, t;
        boolean valido1, valido2;
        Boolean fin=false;
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
    public void coor(){
                for (i=1; i<5; i++){
            System.out.println("Barco "+i);
            valido1=false;
            valido2=false;
            while(!valido1){
                try{
                    System.out.println("Ingrese tamaño del barco:");
                    t = Integer.parseInt(libro.readLine());
                    if(0<t && t<5){
                        valido1=true;
                        while(!valido2){
                            System.out.println("Ingrese coordenadas:");
                            dato = libro.readLine();
                            x=coordenadasx(dato);
                            y=coordenadasy(dato);
                            if(x==-1 || y==-1){
                                System.out.println("Valores invalidos.");
                            }else{
                                valido2=true;
                                //insertar metodo de colocar barcos de jugador 1
                            }
                        }
                    }else{
                        System.out.println("Ingrese tamaño valido.");
                    }
                }catch(Exception e){
                    System.out.println("Ingrese valores numericos");
                }
            }
        }
    }
}
