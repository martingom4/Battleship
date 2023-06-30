import java.io.*;
public class BattleShip {
    static BufferedReader libro=new BufferedReader(new InputStreamReader(System.in));
    static int x,y,t,opc_barco;
    public static void main(String[] args) throws IOException {
    
        //aca se pondra todo el codigo principal del proyecto
        Jugador obj =new Jugador();
        
        int barco=0;
        String player1, player2;
        String dato="";
        Boolean fin=false;
        /* 
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
        obj.Tablero(obj.table1);//llamado al metodo para crear tablero

        //Barco
        while(barco<4){
            System.out.println("Colocar barco: \n1-Horizontal(hacia a la derecha)\n2-Vertical(hacia abajo)");
            opc_barco=Integer.parseInt(libro.readLine());
            switch(opc_barco){
            case 1:
                BattleShip.coordenadas();//Llamado la metodo de pedir coordenadas
                obj.BarcoH(obj.table1,t,x,y);//llamado al metodo para guardar barco en horizontal
                obj.MostrarTablero(obj.table1);//llamado al metodo para mostrar tablero
                break;
            case 2:
                BattleShip.coordenadas();//Llamado la metodo de pedir coordenadas
                obj.BarcoV(obj.table1,t,x,y);//llamado al metodo para guardar barco en horizontal
                obj.MostrarTablero(obj.table1);//llamado al metodo para mostrar tablero
                break;
            default:
                System.out.println("Ingrese una opcion valida mostrada");
                break;
            }
        }
        
        //Disparo
        System.out.println("inserte x");
        x=Integer.parseInt(libro.readLine());
        System.out.println("inserte y");
        y=Integer.parseInt(libro.readLine()); 
        obj.Ataque(obj.table1,x,y);//llamado al metodo para atacar
        obj.MostrarTablero(obj.table1);//llamado al metodo para mostrar tablero
        
    }

    public static void coordenadas()throws IOException{
        System.out.println("inserte las coordenadas de la fila");
                        x=Integer.parseInt(libro.readLine());
                    System.out.println("inserte las coordenadas de la columna");
                        y=Integer.parseInt(libro.readLine());
                    System.out.println("inserte tamaño del barco");
                        t=Integer.parseInt(libro.readLine());
    }
}