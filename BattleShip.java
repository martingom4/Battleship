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
        Tablero board = new Tablero();
        Boolean barco=false;
        String dato ="";
        int opc_barco=0;
        int i=0;
        boolean valido;
        boolean valido2;
        
        board.CrearTablero(player.table1);//llamado al metodo para crear tablero del jugador 1
        board.CrearTablero(player.table2);//llamado al metodo para crear tablero del jugador 2
        board.CrearTablero(player.table3);// se llama al metodo de tablero para disparo del jugador 1
        board.CrearTablero(player.table4);// se llama al metodo de tablero para disparo del jugador 2
        
        System.out.println("----------------------------------");
        System.out.println("Bienvenido al juego Battleship");
        System.out.println("----------------------------------");
        player.Nombres();

        
        // Limpiar pantalla
        Limpiar.clean();

        //Barco jugador 1;
        System.out.println("Es el turno de poner los barcos al Jugador 1: "+player.player1);
        libro.readLine();
        Limpiar.clean();
        for(i=0;i<4;i++){
            valido=false;
            while(!valido){
                try{
                    System.out.println("Colocar barco "+(i+1)+": \n1-Horizontal(hacia a la derecha)\n2-Vertical(hacia abajo) \n");
                    opc_barco=Integer.parseInt(libro.readLine());
                    Limpiar.clean();
                    barco=false;
                    switch(opc_barco){
                        case 1: 
                            board.MostrarTablero(player.table1);  
                            boat.size1=boat.TamañoBarco(boat.ilustracion1,boat.size1,i,boat.nbarco1,boat.barco1);//metodo encontrar el tamaño del barco
                            Limpiar.clean();
                            while(!barco){ 
                                board.MostrarTablero(player.table1);
                                valido2=false;
                                while(!valido2){
                                    System.out.println("Ingrese coordenadas en formato alfanumerico:");
                                    dato = libro.readLine();
                                    if (dato.isEmpty()) {
                                        System.out.println("Debe ingresar coordenadas.");
                                    } else {
                                        c.guardarcoords(dato, c.coordenadas1, i);
                                        if (c.x == -1 || c.y == -1) {
                                            System.out.println("Valores inválidos.");
                                        } else {
                                            valido2 = true;
                                        }
                                    }// fin del else 
                                    
                                }// fin del while  interno   
                                barco=player.BarcoH(player.table1,boat.size1,c.x,c.y,i,boat.direccion1);//llamado al metodo para guardar barco en horizontal
                                board.MostrarTablero(player.table1);//llamado al metodo para mostrar tablero
                                libro.readLine();
                                Limpiar.clean();
                                
                            }// fin del while  interno 
                            break;
                        case 2:
                            board.MostrarTablero(player.table1);                   
                            boat.size1=boat.TamañoBarco(boat.ilustracion1,boat.size1,i,boat.nbarco1,boat.barco1);  
                            Limpiar.clean();                      
                            while(!barco){
                                board.MostrarTablero(player.table1);                           
                                valido2=false;
                                while(!valido2){
                                    System.out.println("Ingrese coordenadas en formato alfanumerico:");
                                    dato = libro.readLine();
                                    if (dato.isEmpty()) {
                                        System.out.println("Debe ingresar coordenadas.");
                                    } else {
                                        c.guardarcoords(dato, c.coordenadas1, i);
                                        if (c.x == -1 || c.y == -1) {
                                            System.out.println("Valores inválidos.");
                                        } else {
                                            valido2 = true;
                                        }
                                    }//fin del else 
                                } //fin del while interno 
                                barco=player.BarcoV(player.table1,boat.size1,c.x,c.y,i,boat.direccion1);//llamado al metodo para guardar barco en vertical 
                                board.MostrarTablero(player.table1);//llamado al metodo para mostrar tablero
                                libro.readLine();
                                Limpiar.clean();
                            }//fin del while externo
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
            System.out.println("Es el turno de poner los barcos al Jugador 2: "+player.player2);
            libro.readLine();
            Limpiar.clean();
            for(i=0;i<4;i++){
                valido=false;
                while(!valido){
                    try{
                        System.out.println("Colocar barco "+(i+1)+": \n1-Horizontal(hacia a la derecha)\n2-Vertical(hacia abajo)\n");
                        opc_barco=Integer.parseInt(libro.readLine());
                        Limpiar.clean();
                        barco=false;
                            switch(opc_barco){
                            case 1:
                            board.MostrarTablero(player.table2);
                            boat.size2=boat.TamañoBarco(boat.ilustracion2,boat.size2,i,boat.nbarco2,boat.barco2);//metodo encontrar el tamaño del barco
                            Limpiar.clean();
                            while(!barco){
                                board.MostrarTablero(player.table2);
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
                                board.MostrarTablero(player.table2);//llamado al metodo para mostrar tablero
                                libro.readLine();
                                Limpiar.clean();
                            }
                                break;
                            case 2:
                            board.MostrarTablero(player.table2);
                            boat.size2=boat.TamañoBarco(boat.ilustracion2,boat.size2,i,boat.nbarco2,boat.barco2);//metodo encontrar el tamaño del barco
                            Limpiar.clean();
                            while(!barco){
                                board.MostrarTablero(player.table2); 
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
                                board.MostrarTablero(player.table2);//llamado al metodo para mostrar tablero
                                libro.readLine();
                                Limpiar.clean();
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
                    }//fin try catch

                }//fin while
            }//fin del for del barco jugador 2
            

     
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
                Limpiar.clean();  
                try {
                    
                
                if (turno == 1) { //turno del jugador 1
                    
                    System.out.println("Es turno del jugador: " + pJugador + ". Prepárate");
                    libro.readLine();
                    Limpiar.clean();
                    System.out.println("Tablero de disparos");
                    board.MostrarTablero(player.table3);
                    System.out.println("Estos son tus barcos");
                    board.MostrarTablero(player.table1);
                    valido2=false;
                    while(!valido2){
                        System.out.println("Si quieres rendirte pon EXIT");
                        System.out.println("Ingrese coordenadas:");
                        dato = libro.readLine();
                        if(!dato.equalsIgnoreCase("EXIT")){
                            c.guardarcoords(dato, c.coordenadas3,i);//Llamado al metodo de pedir coordenadas
                            if(c.x==-1 || c.y==-1){
                                System.out.println("Valores invalidos.");
                            }else{
                                valido2=player.Disparar(player.table2, player.table3, c.coordenadas3, i);
                                System.out.println("Tablero de disparos");
                                board.MostrarTablero(player.table3); 
                            }    
                        }else{ //si el jugador 1 se rinde
                            FindelJuego=true;
                            System.out.println("El ganador es \n"+ player.player2);
                            boat.ListaBarcos(boat.size2, c.coordenadas2, boat.direccion2);
                            System.out.println("Y los barcos de "+ player.player1 + " son");
                            boat.ListaBarcos(boat.size1, c.coordenadas1, boat.direccion1);
                            break;
                        }
                      
                        
                    } 
                    libro.readLine();
                       
                }// Fin del if 
                else { //turno del jugador 2
                    System.out.println("Es turno del jugador: " + pJugador + ". Prepárate");
                    libro.readLine();
                    Limpiar.clean();
                    System.out.println("Tablero de disparos");
                    board.MostrarTablero(player.table4);
                    System.out.println("Estos son tus barcos");
                    board.MostrarTablero(player.table2);
                    valido2=false;
                    while(!valido2){
                        System.out.println("Si quieres rendirte pon EXIT");
                        System.out.println("Ingrese coordenadas:");
                        dato = libro.readLine();
                        if(!dato.equalsIgnoreCase("EXIT")){
                            c.guardarcoords(dato, c.coordenadas4,i);//Llamado al metodo de pedir coordenadas
                            if(c.x==-1 || c.y==-1){
                                System.out.println("Valores invalidos.");
                            }else{
                                valido2=player.Disparar(player.table1, player.table4, c.coordenadas4, i);
                                System.out.println("Tablero de disparos");
                                board.MostrarTablero(player.table4);
                                
                            }
                           
                        }else{ //si el jugador 2 se rinde
                            FindelJuego=true;
                            System.out.println("El ganador es \n"+ player.player1);
                            boat.ListaBarcos(boat.size1, c.coordenadas1, boat.direccion1);
                            System.out.println("Y los barcos de "+ player.player2 + " son");
                            boat.ListaBarcos(boat.size2, c.coordenadas2, boat.direccion2);
                            break;
                        }
                        // Limpiar.clean();
                    } 
                    libro.readLine();
                }// fin del else
                 } catch (Exception e) {
                    System.out.println("ingrese una coordenada valida");
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
                    boat.ListaBarcos(boat.size1, c.coordenadas1, boat.direccion1);
                    System.out.println("Los barcos de" +player.player1 + " eran");
                    boat.ListaBarcos(boat.size1, c.coordenadas1, boat.direccion1);
                    FindelJuego = true;

                }
                if (c.todosBarcosHundidos(player.table2)) {
                    System.out.println("Todos los barcos del jugador 2 se han hundido");
                    System.out.println("GANADOR -> Jugador 1: " + pJugador);
                    boat.ListaBarcos(boat.size2, c.coordenadas2, boat.direccion2);
                    System.out.println("Los barcos de " +player.player2 + " eran");
                    boat.ListaBarcos(boat.size2, c.coordenadas2, boat.direccion2);
                    FindelJuego = true;
                }

            
        } while (!FindelJuego);

        
    }// fin del static 

    
}// fin de la clase 