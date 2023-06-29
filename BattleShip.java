import java.io.*;


public class BattleShip {
    public static void main(String[] args) throws IOException {
        BufferedReader libro = new BufferedReader(new InputStreamReader(System.in));
        String dato="";
        Boolean fin=false;

        //insertar metodo de ingresar nombres
        //insertar metodo de colocar barcos
        
        System.out.println("Ingrese FIN para terminar el juego.");
        
        while(!fin){
            System.out.println("\n--Turno de (nombre de jugador 1)--");
            System.out.println("Ingrese coordenadas:");
            dato = libro.readLine();
            if(!dato.equals("FIN")){
                //insertar metodo de atacar de jugador 1
                System.out.println("\n--Turno de (nombre de jugador 2)--");
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
