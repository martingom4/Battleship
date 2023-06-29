import java.io.*;


public class BattleShip {
    public static void main(String[] args) throws IOException {
                BufferedReader libro = new BufferedReader(new InputStreamReader(System.in));
        String player1, player2;
        String dato="";
        Boolean fin=false;

        System.out.println("--BATTLESHIP--");

        System.out.println("Ingrese nombre del jugador 1:");
        player1=libro.readLine();
        System.out.println("Ingrese nombre del jugador 2:");
        player2=libro.readLine();
        
        System.out.println("\n--"+player1+", inserte sus barcos--");
        //insertar metodo de colocar barcos de jugador 1
        System.out.println("\n--"+player2+", inserte sus barcos--");
        //insertar metodo de colocar barcos de jugador 2
        
        System.out.println("\nIngrese FIN para terminar el juego.");
        
        while(!fin){
            System.out.println("\n--Turno de "+player1+"--");
            System.out.println("Ingrese coordenadas:");
            dato = libro.readLine();
            if(!dato.equals("FIN")){
                //insertar metodo de atacar de jugador 1
                System.out.println("\n--Turno de "+player2+"--");
                System.out.println("Ingrese coordenadas:");
                dato = libro.readLine();
                if(dato.equals("FIN")){
                    fin=true;
                    System.out.println("(nombre de jugador 1) GANA");
                    //insertar metodo de mostrar lista de barcos
                } else{
                    //insertar metodo de atacar de jugador 2
                }
            }else{
                fin=true;
                System.out.println("(nombre de jugador 2) GANA");
                //insertar metodo de mostrar lista de barcos
            }
        }
    }
}
