import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Barco {
    BufferedReader libro = new BufferedReader(new InputStreamReader(System.in));

    int nbarco[]={2,1,1};
    int barco[]={2,3,4};
    String[] ilustracion={"00","000","0000"};
    
    String[] direccion1=new String[3];//arrglo que guarda la direccion Horizontal o vertical del jugador 1
    String[] direccion2=new String[3];
    int[] size1=new int[3]; // arreglo que guarda los tamños de los barcos del jugador 1
    int[] size2=new int[3];
    String[]coordenadas1=new String[3];//arreglo que guarda las coordenadas
    String[]coordenadas2=new String[3];

//Metodo tamano de barco
public int[] TamañoBarco(String[] ilus,int[]t,int i)throws IOException{
        Boolean n=true;
        while(n){
            System.out.println("Tamaño de barcos disponibles disponibles:\n2:"+ilus[0]+"\n3:"+ilus[1]+"\n4:"+ilus[2]);
            System.out.println("Escoga el tamaño del barco");
            t[i]=Integer.parseInt(libro.readLine());
            if(t[i]>1 & t[i]<5){//comprobar que sea un tamaño de barco real
                for(int j=0;j<3;j++){
                    if(t[i]==barco[j] & nbarco[j]>0){//identificar tamaño de barco
                        n=false;
                        nbarco[j]=nbarco[j]-1;
                        if(nbarco[j]==0){
                            ilus[j]="-";
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



    public void xyz(int[]t){
        for(int i=0;i<4;i++){
            System.out.println(t[i]+", ");
        }
    }
}