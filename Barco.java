import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Barco {
    BufferedReader libro = new BufferedReader(new InputStreamReader(System.in));

    int nbarco[]={2,1,1};
    int barco[]={2,3,4};
    String[] ilustracion={"00","000","0000"};
    
    String[] direccion1=new String[4];//arrglo que guarda la direccion Horizontal o vertical del jugador 1
    String[] direccion2=new String[4];
    int[] size1=new int[4]; // arreglo que guarda los tamños de los barcos del jugador 1
    int[] size2=new int[4];

//Metodo tamano de barco
public int[] TamañoBarco(String[] ilus,int[]tam,int i)throws IOException{
        Boolean n=true;
        while(n){
            System.out.println("Tamaño de barcos disponibles disponibles:\n2:"+ilus[0]+"\n3:"+ilus[1]+"\n4:"+ilus[2]);
            System.out.println("Escoga el tamaño del barco");
            tam[i]=Integer.parseInt(libro.readLine());
            if(tam[i]>1 & tam[i]<5){//comprobar que sea un tamaño de barco real
                for(int j=0;j<3;j++){
                    if(tam[i]==barco[j] & nbarco[j]>0){//identificar tamaño de barco
                        n=false;
                        nbarco[j]=nbarco[j]-1;
                        if(nbarco[j]==0){//cuando no hay barco disponible, se elimina la ilustracion
                            ilus[j]="-";
                        }
                        break;
                    }
                }
            }else{
                System.out.println("Introduzca un tamaño de barco disponible");
            }
        }
        return tam;
    }



    public void barcos(int[]t,String[] coord,String[]sentido){
        for(int i=0;i<4;i++){
            System.out.println( "TamañBarco: "+t[i]);
            System.out.println("sus coordenadas:"+coord[i]);
            System.out.println("su sentido es:"+sentido[i]);
        }
    }
}