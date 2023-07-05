//
import java.io.*;
public class BattleShip {
    public static void main(String[] args) throws IOException {
        //aca se pondra todo el codigo principal del proyecto
        BufferedReader libro=new BufferedReader(new InputStreamReader(System.in));
        Jugador player =new Jugador();
        Coordenadas c = new Coordenadas();
        Barco boat = new Barco();
        Boolean barco=false;
        Boolean fin=false;
        int turnos;
        int opc_barco=0;
        int i=0;
        
        player.Tablero(player.table1);//llamado al metodo para crear tablero del jugador 1
        player.Tablero(player.table2);//llamado al metodo para crear tablero del jugador 2
        player.Tablero(player.table3);// se llama al metodo de tablero para disparo del jugador 1
        player.Tablero(player.table4);// se llama al metodo de tablero para disparo del jugador 2
        player.Nombres();
        
        //Barco jugador 1;
        System.out.println("Jugador 1: "+player.player1);
        Limpiar.clean();
        for(i=0;i<4;i++){
            
                System.out.println("Colocar barco "+(i+1)+": \n1-Horizontal(hacia a la derecha)\n2-Vertical(hacia abajo)");
                opc_barco=Integer.parseInt(libro.readLine());
                Limpiar.clean();
                barco=false;
            switch(opc_barco){
                case 1:
                        
                        boat.size1=boat.TamañoBarco(boat.ilustracion1,boat.size1,i,boat.nbarco1,boat.barco1);//metodo encontrar el tamaño del barco
                        Limpiar.clean();
                        while(!barco){ 
                            player.MostrarTablero(player.table1);        
                            c.coor(c.coordenadas1,i);//Llamado al metodo de pedir coordenadas
                            barco=player.BarcoH(player.table1,boat.size1,c.x,c.y,i,boat.direccion1);//llamado al metodo para guardar barco en horizontal
                            player.MostrarTablero(player.table1);//llamado al metodo para mostrar tablero
                            
                        }
                    break;
                case 2:                     
                    boat.size1=boat.TamañoBarco(boat.ilustracion1,boat.size1,i,boat.nbarco1,boat.barco1);  
                        Limpiar.clean();                      
                        while(!barco){
                            player.MostrarTablero(player.table1);                           
                            c.coor(c.coordenadas1,i);//Llamado la metodo de pedir coordenadas
                            barco=player.BarcoV(player.table1,boat.size1,c.x,c.y,i,boat.direccion1);//llamado al metodo para guardar barco en vertical 
                            player.MostrarTablero(player.table1);//llamado al metodo para mostrar tablero
                        }
                    break;
                default:
                    System.out.println("Ingrese una opcion valida mostrada");
                    i--;
                    break;
            }opc_barco=0; //Fin del switch
        }//fin del for 
        boat.barcos(boat.size1,c.coordenadas1,boat.direccion1); 

       //barco jugador 2
        System.out.println("Jugador 2: "+player.player2);
        for(i=0;i<4;i++){
                System.out.println("Colocar barco "+(i+1)+": \n1-Horizontal(hacia a la derecha)\n2-Vertical(hacia abajo)");
                opc_barco=Integer.parseInt(libro.readLine());
                Limpiar.clean();
                barco=false;
            switch(opc_barco){
                case 1:
                        boat.size2=boat.TamañoBarco(boat.ilustracion2,boat.size2,i,boat.nbarco2,boat.barco2);//metodo encontrar el tamaño del barco
                        Limpiar.clean();
                        while(!barco){
                            player.MostrarTablero(player.table2); 
                            c.coor(c.coordenadas2,i);//Llamado al metodo de pedir coordenadas
                            barco=player.BarcoH(player.table2,boat.size2,c.x,c.y,i,boat.direccion2);//llamado al metodo para guardar barco en horizontal
                            player.MostrarTablero(player.table2);//llamado al metodo para mostrar tablero
                        }
                    break;
                case 2:
                        boat.size2=boat.TamañoBarco(boat.ilustracion2,boat.size2,i,boat.nbarco2,boat.barco2);//metodo encontrar el tamaño del barco
                        Limpiar.clean();
                        while(!barco){
                            player.MostrarTablero(player.table2); 
                            c.coor(c.coordenadas2,i);//Llamado al metodo de pedir coordenadas
                            barco=player.BarcoV(player.table2,boat.size2,c.x,c.y,i,boat.direccion2);//llamado al metodo para guardar barco en horizontal
                            player.MostrarTablero(player.table2);//llamado al metodo para mostrar tablero
                        }
                    break;
                default:
                    System.out.println("Ingrese una opcion valida mostrada");
                    i--;
                    break;
            }opc_barco=0; //Fin del switch
        }//fin del for 
        boat.barcos(boat.size2,c.coordenadas2,boat.direccion2); 

        do {
        System.out.println("ingrese que jugador quiere que vaya primero el jugador 1 o el jugador 2 ");
        turnos= Integer.parseInt(libro.readLine());
        
            
                switch (turnos) {
                case 1:
                    System.out.println("Es el turno del jugador 1");
                    System.out.println("Ingrese las coordenadas en las que quiere disparar");
                    player.MostrarTablero(player.table3);
                    c.coor(c.coordenadas1, i);
                    c.Disparar(player.table2, c.coordenadas1,i);

                    break;
                case 2:
                    System.out.println("Es el turno del jugador 2 ");
                    System.out.println("Ingrese las coordenadas en las que quiere disparar");
                    player.MostrarTablero(player.table3);
                    c.coor(c.coordenadas2,i);
                    c.Disparar(player.table1, c.coordenadas2,i);
                    
                default:

                    break;
            }
    
    
        }while(fin);


    }// fin del static 
}// fin de la clase 