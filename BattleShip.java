import java.io.*;

public class BattleShip {
    static BufferedReader libro=new BufferedReader(new InputStreamReader(System.in));
    static int t,opc_barco=0;
    public static void main(String[] args) throws IOException {

    
        //aca se pondra todo el codigo principal del proyecto
        Jugador player =new Jugador();
        coordenadas c = new coordenadas();
        Barco boat = new Barco();
        
        int barco=0;
        String player1, player2;
        String dato="";
        Boolean fin=false;
        /* 

    BufferedReader libro=new BufferedReader(new InputStreamReader(System.in));
        //aca se pondra todo el codigo principal del proyecto
        Jugador obj =new Jugador();
        
        int x,y,t;
        obj.Tablero(obj.table1);//llamado al metodo para crear tablero
        /*String player1, player2;
        String dato="";
        Boolean fin=false;
        prueba desde afuera 3


        //se ingresan los nombres de los jugadoes
        System.out.println("---BATTLESHIPS---");
        System.out.println("Ingrese jugador 1:");
        player1 = libro.readLine();
        System.out.println("Ingrese jugador 2:");
        player2 = libro.readLine();

        //inicia el juego
        while(!fin){
            System.out.println("\n--Turno de "+player1+"--");
            dato = libro.readLine();
            if(!dato.equals("FIN")){
                System.out.println("\n--Turno de "+player2+"--");
                dato = libro.readLine();
                if(dato.equals("FIN")){
                    fin=true;
                }
            }else{
                fin=true;
            }
        }*/

        player.Tablero(player.table1);//llamado al metodo para crear tablero
        
        //Barco
        for(int i=0;i<4;i++){
            try{
                System.out.println("Colocar barco "+(i+1)+": \n1-Horizontal(hacia a la derecha)\n2-Vertical(hacia abajo)");
                opc_barco=Integer.parseInt(libro.readLine());
            }catch(Exception e){

            }//fina try catch
            switch(opc_barco){
                case 1:
                        boat.size1=boat.TamañoBarco(boat.ilustracion,boat.size1,i);//metodo encontrar el tamaño del barco
                        c.coor(c.coordenadas1,i);//Llamado al metodo de pedir coordenadas
                        System.out.println("dato i:"+i);
                        player.table1=player.BarcoH(player.table1,boat.size1,c.x,c.y,i,boat.direccion1);//llamado al metodo para guardar barco en horizontal
                        player.MostrarTablero(player.table1);//llamado al metodo para mostrar tablero
                    
                    break;
                case 2:
                        boat.size1=boat.TamañoBarco(boat.ilustracion,boat.size1,i);
                        c.coor(c.coordenadas1,i);//Llamado la metodo de pedir coordenadas
                        player.table1=player.BarcoV(player.table1,boat.size1,c.x,c.y,i,boat.direccion1);//llamado al metodo para guardar barco en horizontal
                        player.MostrarTablero(player.table1);//llamado al metodo para mostrar tablero
                    
                    break;
                default:
                    System.out.println("Ingrese una opcion valida mostrada");
                    i--;
                    break;
            }opc_barco=0; //Fin del switch
        }//fin del for 
        boat.barcos(boat.size1,c.coordenadas1,boat.direccion1);
    }
}