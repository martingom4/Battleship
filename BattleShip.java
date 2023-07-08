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
        Jugador player =new Jugador();
        Coordenadas c = new Coordenadas();
        Barco boat = new Barco();
        Boolean barco=false;
        String dato ="";
        int opc_barco=0;
        int i=0;
        boolean valido;
        boolean valido2;
        
        player.Tablero(player.table1);//llamado al metodo para crear tablero del jugador 1
        player.Tablero(player.table2);//llamado al metodo para crear tablero del jugador 2
        player.Tablero(player.table3);// se llama al metodo de tablero para disparo del jugador 1
        player.Tablero(player.table4);// se llama al metodo de tablero para disparo del jugador 2
        
        System.out.println("----------------------------------");
        System.out.println("Bienvenido al juego Battleship");
        System.out.println("----------------------------------");
        player.Nombres();
        
        
        // Limpiar pantalla
        Limpiar.clean();

        //Barco jugador 1;
        System.out.println("Jugador 1: "+player.player1);
        for(i=0;i<4;i++){
            valido=false;
            while(!valido){
                try{
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
                                valido2=false;
                                while(!valido2){
                                    System.out.println("Ingrese coordenadas:");
                                    dato = libro.readLine();
                                    c.guardarcoords(dato, c.coordenadas1,i);//Llamado al metodo de pedir coordenadas
                                    if(c.x==-1 || c.y==-1){
                                        System.out.println("Valores invalidos.");
                                    }else{
                                        valido2=true;
                                    }
                                }      
                                barco=player.BarcoH(player.table1,boat.size1,c.x,c.y,i,boat.direccion1);//llamado al metodo para guardar barco en horizontal
                                player.MostrarTablero(player.table1);//llamado al metodo para mostrar tablero
                                
                            }
                            break;
                        case 2:                     
                            boat.size1=boat.TamañoBarco(boat.ilustracion1,boat.size1,i,boat.nbarco1,boat.barco1);  
                            Limpiar.clean();                      
                            while(!barco){
                                player.MostrarTablero(player.table1);                           
                                valido2=false;
                                while(!valido2){
                                    System.out.println("Ingrese coordenadas:");
                                    dato = libro.readLine();
                                    c.guardarcoords(dato, c.coordenadas1,i);//Llamado al metodo de pedir coordenadas
                                    if(c.x==-1 || c.y==-1){
                                        System.out.println("Valores invalidos.");
                                    }else{
                                        valido2=true;
                                    }
                                } 
                                barco=player.BarcoV(player.table1,boat.size1,c.x,c.y,i,boat.direccion1);//llamado al metodo para guardar barco en vertical 
                                player.MostrarTablero(player.table1);//llamado al metodo para mostrar tablero
                            }
                            break;
                        default:
                            System.out.println("Ingrese una opcion valida mostrada");
                            i--;
                            break;
                    }opc_barco=0; //Fin del switch
                    valido=true;
                }catch (Exception e){
                    System.out.println("Ingrese dato valido");
                }
            }
        }//fin del for 

    
        // Limpiar pantalla
        Limpiar.clean();

       //barco jugador 2
        System.out.println("Jugador 2: "+player.player2);
        for(i=0;i<4;i++){
            valido=false;
            while(!valido){
                try{
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
                                    valido2=false; 
                                    while(!valido2){
                                        System.out.println("Ingrese coordenadas:");
                                        dato = libro.readLine();
                                        c.guardarcoords(dato, c.coordenadas2,i);//Llamado al metodo de pedir coordenadas
                                        if(c.x==-1 || c.y==-1){
                                            System.out.println("Valores invalidos.");
                                        }else{
                                            valido2=true;
                                        }
                                    } 
                                    barco=player.BarcoH(player.table2,boat.size2,c.x,c.y,i,boat.direccion2);//llamado al metodo para guardar barco en horizontal
                                    player.MostrarTablero(player.table2);//llamado al metodo para mostrar tablero
                                }
                            break;
                        case 2:
                                boat.size2=boat.TamañoBarco(boat.ilustracion2,boat.size2,i,boat.nbarco2,boat.barco2);//metodo encontrar el tamaño del barco
                                Limpiar.clean();
                                while(!barco){
                                    player.MostrarTablero(player.table2); 
                                    valido2=false;
                                    while(!valido2){
                                        System.out.println("Ingrese coordenadas:");
                                        dato = libro.readLine();
                                        c.guardarcoords(dato, c.coordenadas2,i);//Llamado al metodo de pedir coordenadas
                                        if(c.x==-1 || c.y==-1){
                                            System.out.println("Valores invalidos.");
                                        }else{
                                            valido2=true;
                                        }
                                    } 
                                    barco=player.BarcoV(player.table2,boat.size2,c.x,c.y,i,boat.direccion2);//llamado al metodo para guardar barco en horizontal
                                    player.MostrarTablero(player.table2);//llamado al metodo para mostrar tablero
                                }
                            break;
                        default:
                            System.out.println("Ingrese una opcion valida mostrada");
                            i--;
                            break;
                    }opc_barco=0; //Fin del switch
                    valido=true;
                }catch(Exception e){
                    System.out.println("Ingrese dato valido");
                }
            }
        }//fin del for 

     
        Limpiar.clean();
        int turno = 1; // Empieza el juego con el turno del jugador 1
        Boolean FindelJuego=false;

        do {
            String pJugador = "";
            if (turno == 1) {
                pJugador = player.player1;
            } else {
                pJugador = player.player2;
            }

            

            i = 0;
               
                
                if (turno == 1) { //turno del jugador 1
                    System.out.println("Es turno del jugador: " + pJugador + ". Prepárate");
                    System.out.println("Tablero de disparos");
                    player.MostrarTablero(player.table3);
                    System.out.println("Estos son tus barcos");
                    player.MostrarTablero(player.table1);
                    valido2=false;
                    while(!valido2){
                        System.out.println("Ingrese coordenadas:");
                        dato = libro.readLine();
                        if(!dato.equals("FIN")){
                            c.guardarcoords(dato, c.coordenadas3,i);//Llamado al metodo de pedir coordenadas
                            if(c.x==-1 || c.y==-1){
                                System.out.println("Valores invalidos.");
                            }else{
                                valido2=c.Disparar(player.table2, player.table3, c.coordenadas3, i);
                                System.out.println("Tablero de disparos");
                                player.MostrarTablero(player.table3);  
                            }
                        }else{ //si el jugador 1 se rinde
                            FindelJuego=true;
                            System.out.println("El ganador es \n"+ player.player2);
                            boat.barco(boat.size2, c.coordenadas2, boat.direccion2);
                            System.out.println("Y los barcos de "+ player.player1 + "son");
                            boat.barco(boat.size1, c.coordenadas1, boat.direccion1);
                            break;
                        }
                        
                    } 
                       
                       
                }else { //turno del jugador 2
                    System.out.println("Es turno del jugador: " + pJugador + ". Prepárate");
                    System.out.println("Tablero de disparos");
                    player.MostrarTablero(player.table4);
                    System.out.println("Estos son tus barcos");
                    player.MostrarTablero(player.table2);
                    valido2=false;
                    while(!valido2){
                        System.out.println("Ingrese coordenadas:");
                        dato = libro.readLine();
                        if(!dato.equals("FIN")){
                            c.guardarcoords(dato, c.coordenadas4,i);//Llamado al metodo de pedir coordenadas
                            if(c.x==-1 || c.y==-1){
                                System.out.println("Valores invalidos.");
                            }else{
                                valido2=c.Disparar(player.table1, player.table4, c.coordenadas4, i);
                                System.out.println("Tablero de disparos");
                                player.MostrarTablero(player.table4);
                            }
                        }else{ //si el jugador 2 se rinde
                            FindelJuego=true;
                            System.out.println("El ganador es \n"+ player.player1);
                            boat.barco(boat.size1, c.coordenadas1, boat.direccion1);
                            System.out.println("Y los barcos de "+ player.player2 + "son");
                            boat.barco(boat.size2, c.coordenadas2, boat.direccion2);
                            break;
                        }
                    } 
                    

                }
                
                if (turno == 1) {
                    turno = 2; // turno al jugador 2
                } else {
                    turno = 1; // turno al jugador 1
                }

                //que barco se hundio 
                if (c.todosBarcosHundidos(player.table1)) {
                    System.out.println("Todos los barcos del jugador 1 se han hundido");
                    System.out.println("GANADOR -> Jugador 2: " + pJugador);
                    boat.barco(boat.size1, c.coordenadas1, boat.direccion1);
                    FindelJuego = true;
                }
                if (c.todosBarcosHundidos(player.table2)) {
                    System.out.println("Todos los barcos del jugador 2 se han hundido");
                    System.out.println("GANADOR -> Jugador 1: " + pJugador);
                    boat.barco(boat.size2, c.coordenadas2, boat.direccion2);
                    FindelJuego = true;
                }

            
        } while (!FindelJuego);


        //boat.barcos(boat.size1,c.coordenadas1,boat.direccion1);
        //boat.barcos(boat.size2,c.coordenadas2,boat.direccion2); 
        
    }// fin del static 

    
}// fin de la clase 