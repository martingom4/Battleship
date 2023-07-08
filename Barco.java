import java.io.*;
public class Barco {
    BufferedReader libro = new BufferedReader(new InputStreamReader(System.in));

    int nbarco[]={2,1,1};
    int barco[]={2,3,4};
    String[] ilustracion={"00","000","0000"};
    String[] direccion=new String[4];//arrglo que guarda la direccion Horizontal o vertical del jugador 1
    int[] size=new int[4]; // arreglo que guarda los tamños de los barcos del jugador 1
    String[]coordenadasbarco=new String[4];
    String[]coordenadasdisp=new String[4];
    String dato="";
    int x, y, i, t;
    
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
    public int coordenadasy(String coordenada[], int i) throws IOException {
        int num;
        int y;
        try {
            if (coordenada[i] != null) {  // Verificar si la cadena no es nula
                num = Integer.parseInt(coordenada[i].substring(1));
                if (num > 0 && num < 11) {
                    y = num - 1;
                } else {
                    y = -1;
                }
            } else {
                y = -1;
            }
        } catch (Exception e) {
            y = -1;
        }
        return y;
    }
        public int coordenadasx(String coordenada[],int i){
            String letra;
            int x;
            letra=coordenada[i].substring(0, 1).toUpperCase();
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
        public String[] coor(String[]coordenada,int i) throws IOException{
            System.out.println("Inserte coordenadas");
            coordenada[i]=libro.readLine();
            x=coordenadasx(coordenada,i);
            y=coordenadasy(coordenada,i);
            return coordenada;
        }
    
        public void Disparar(String[][] table,String[][] table_d, String[] coordenada, int i)throws IOException{
            int x = coordenadasx(coordenada,i);
            int y = coordenadasy(coordenada,i );
    
            if (x >= 0 && x < table.length && y >= 0 && y < table[0].length) {
                if (table[x][y].equals("-")) {
                    System.out.println("Agua");
                    table_d[x][y] = "f";
                } else if (table[x][y].equals("X")){
                    System.out.println("Ya has disparado aquí antes");
                }else if (table[x][y].equals("0")) {
                System.out.println("Has impactado un barco");
                table_d[x][y] = "X"; // Marcar como impacto en un barco con "X"
                }
            } else {
                System.out.println("Coordenadas inválidas");
            }
        }
    
    public void barcos(int[]t,String[] coord,String[]sentido){
        for(int i=0;i<4;i++){
            System.out.println("Barco "+(i+1));
            System.out.println( "Tamaño: "+t[i]);
            System.out.println("Coordenadas:"+coord[i]);
            System.out.println("sentido:"+sentido[i]);
        }
    }
}