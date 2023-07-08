/*
 * Integrantes:
 * - David Zhang
 * - Nicole Bustamante
 * - Anilys Rodriguez
 * - Martin Gomez
 */
import java.io.*;
public class BattleShip {
    public static void main(String[] args) throws IOException {
        //aca se pondra todo el codigo principal del proyecto
        BufferedReader libro=new BufferedReader(new InputStreamReader(System.in));
        Boolean barco=false;
        Boolean fin=false;
        int turnos;
        int opc_barco=0;
        int i=0;
        Jugador player1 = new Jugador(1); //Jugador 1
        Jugador player2 = new Jugador(2);
        Barco boat1 = new Barco(); // Barcos del jugador 1
        Barco boat2 = new Barco();
    
        //Barco jugador 1;
        Limpiar.clean();
        for(i=0;i<4;i++){
                player1.MostrarTablero(player1.table);
                System.out.println("Jugador 1: "+player1.Nombre);
                System.out.println("Colocar barco "+(i+1)+": \n1-Horizontal(hacia a la derecha)\n2-Vertical(hacia abajo)");
                opc_barco=Integer.parseInt(libro.readLine());
                Limpiar.clean();
                barco=false;
            switch(opc_barco){
                case 1:
                        player1.MostrarTablero(player1.table);
                        boat1.size=boat1.TamañoBarco(boat1.ilustracion,boat1.size,i,boat1.nbarco,boat1.barco);//metodo encontrar el tamaño del barco
                        Limpiar.clean();
                        while(!barco){ 
                            System.out.println("Tablero de Barcos del Jugador "+player1.Nombre);
                            player1.MostrarTablero(player1.table);        
                            boat1.coor(boat1.coordenadasbarco,i);//Llamado al metodo de pedir coordenadas
                            Limpiar.clean();
                            barco=player1.BarcoH(player1.table,boat1.size,boat1.x,boat1.y,i,boat1.direccion);//llamado al metodo para guardar barco en horizontal
                        }
                    break;
                case 2:     
                        player1.MostrarTablero(player1.table);                
                        boat1.size=boat1.TamañoBarco(boat1.ilustracion,boat1.size,i,boat1.nbarco,boat1.barco);  
                        Limpiar.clean();                      
                        while(!barco){
                            System.out.println("Tablero de Barcos del Jugador "+player1.Nombre);
                            player1.MostrarTablero(player1.table);                           
                            boat1.coor(boat1.coordenadasbarco,i);//Llamado la metodo de pedir coordenadas
                            Limpiar.clean();
                            barco=player1.BarcoV(player1.table,boat1.size,boat1.x,boat1.y,i,boat1.direccion);//llamado al metodo para guardar barco en vertical 
                        }
                    break;
                default:
                    System.out.println("Ingrese una opcion valida mostrada");
                    i--;
                    break;
            }opc_barco=0; //Fin del switch
        }//fin del for 
        
        
       //barco jugador 2
        Limpiar.clean();
        for(i=0;i<4;i++){
                player1.MostrarTablero(player2.table);
                System.out.println("Jugador 1: "+player2.Nombre);
                System.out.println("Colocar barco "+(i+1)+": \n1-Horizontal(hacia a la derecha)\n2-Vertical(hacia abajo)");
                opc_barco=Integer.parseInt(libro.readLine());
                Limpiar.clean();
                barco=false;
            switch(opc_barco){
                case 1:
                        player2.MostrarTablero(player2.table);
                        boat2.size=boat2.TamañoBarco(boat2.ilustracion,boat2.size,i,boat2.nbarco,boat2.barco);//metodo encontrar el tamaño del barco
                        Limpiar.clean();
                        while(!barco){ 
                            System.out.println("Tablero de Barcos del Jugador "+player2.Nombre);
                            player2.MostrarTablero(player2.table);        
                            boat2.coor(boat2.coordenadasbarco,i);//Llamado al metodo de pedir coordenadas
                            Limpiar.clean();
                            barco=player2.BarcoH(player2.table,boat2.size,boat2.x,boat2.y,i,boat2.direccion);//llamado al metodo para guardar barco en horizontal
                        }
                    break;
                case 2:     
                        player2.MostrarTablero(player2.table);                
                        boat2.size=boat2.TamañoBarco(boat2.ilustracion,boat2.size,i,boat2.nbarco,boat2.barco);  
                        Limpiar.clean();                      
                        while(!barco){
                            System.out.println("Tablero de Barcos del Jugador "+player2.Nombre);
                            player2.MostrarTablero(player2.table);                           
                            boat2.coor(boat2.coordenadasbarco,i);//Llamado la metodo de pedir coordenadas
                            Limpiar.clean();
                            barco=player2.BarcoV(player2.table,boat2.size,boat2.x,boat2.y,i,boat2.direccion);//llamado al metodo para guardar barco en vertical 
                        }
                    break;
                default:
                    System.out.println("Ingrese una opcion valida mostrada");
                    i--;
                    break;
            }opc_barco=0; //Fin del switch
        }//fin del for 
        
        boat1.barcos(boat1.size,boat1.coordenadasbarco,boat1.direccion);
        boat2.barcos(boat2.size,boat2.coordenadasbarco,boat2.direccion);
        /* 
        do {
        System.out.println("ingrese que jugador quiere que vaya primero. El jugador 1 o el jugador 2 ");
        turnos= Integer.parseInt(libro.readLine());
        
                i=0;
                switch (turnos) {
                case 1:
                    System.out.println("Es el turno del jugador 1");
                    System.out.println("Ingrese las coordenadas en las que quiere disparar");
                    System.out.println("tablero de barcos");
                    player.MostrarTablero(player.table1);
                    System.out.println("tablero de disparos");
                    player.MostrarTablero(player.table3);
                    c.coor(c.coordenadas3, i);
                    c.Disparar(player.table2,player.table3, c.coordenadas3,i);
                    System.out.println("tablero de disparos");
                    player.MostrarTablero(player.table3);

                    break;
                case 2:
                    System.out.println("Es el turno del jugador 2 ");
                    System.out.println("Ingrese las coordenadas en las que quiere disparar");
                    System.out.println("tablero de barcos");
                    player.MostrarTablero(player.table2);
                    System.out.println("tablero de disparos");
                    player.MostrarTablero(player.table4);
                    c.coor(c.coordenadas4,i);
                    c.Disparar(player.table1,player.table4, c.coordenadas4,i);
                    System.out.println("tablero de disparos");
                    player.MostrarTablero(player.table4);
                default:
                    System.out.println("La opción insertada en invalida. Ingresar jugador nuevamente");
                    break;
            }
    
    
        }while(!fin);
        boat1.barcos(boat1.size,boat1.coordenadasbarco,boat1.direccion);
        boat2.barcos(boat2.size,boat2.coordenadasbarco,boat2.direccion);
        */
    }// fin del static 
}// fin de la clase 