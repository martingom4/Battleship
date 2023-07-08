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

//Metodo tamano de barco
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
    
    public void barcos(int[] tam, String[] ilus, String[] sentido) {
    for (int i = 0; i < 3; i++) {
        System.out.println("Tamaño del Barco " + (i+2) + ": " + tam[i]);
        System.out.println("Posiciones: " + ilus[i]);
        System.out.println("Sentido: " + sentido[i]);
        System.out.println();
    }
}

}