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
        BufferedReader libro=new BufferedReader(new InputStreamReader(System.in));
        
        Jugador player =new Jugador();
        Coordenadas c = new Coordenadas();
        Barco boat = new Barco();
        Tablero board = new Tablero();
        
        String dato ="";
        int opc_barco=0;
        int i=0;
        int turno = 1; // Empieza el juego con el turno del jugador 1
        Boolean FindelJuego=false;
        Boolean barco=false;
        boolean valido;
        boolean valido2;
        

        board.CrearTablero(player.table1);//llamado al metodo para crear tablero del jugador 1
        board.CrearTablero(player.table2);//llamado al metodo para crear tablero del jugador 2
        board.CrearTablero(player.table3);// se llama al metodo de tablero para disparo del jugador 1
        board.CrearTablero(player.table4);// se llama al metodo de tablero para disparo del jugador 2
        
        //Limpiar pantalla
        Limpiar.clean();

        System.out.println("----------------------------------");
        System.out.println("Bienvenido al juego Battleship");
        System.out.println("----------------------------------");
        
        player.IngresarNombres(); //Se ingresan los nombres de los jugadores

        Limpiar.clean();

        //Jugador 1 coloca sus barcos;
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
                        case 1: //barco en horizontal
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
                                        c.GuardarCoords(dato, c.coordenadas1, i);
                                        if (c.x == -1 || c.y == -1) {
                                            System.out.println("Valores inválidos.");
                                        } else {
                                            valido2 = true;
                                        } //fin de if else
                                    }// fin de if else 
                                    
                                }//fin del while valido2   
                                barco=boat.BarcoH(player.table1,boat.size1,c.x,c.y,i,boat.direccion1);//llamado al metodo para guardar barco en horizontal
                                board.MostrarTablero(player.table1);//llamado al metodo para mostrar tablero
                                libro.readLine();
                                Limpiar.clean();
                                
                            }// fin del while barco 
                            break;

                        case 2: //barco en vertical
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
                                        c.GuardarCoords(dato, c.coordenadas1, i);
                                        if (c.x == -1 || c.y == -1) {
                                            System.out.println("Valores inválidos.");
                                        } else {
                                            valido2 = true;
                                        } //fin de if else
                                    }//fin de if else 
                                } //fin del while valido2 
                                barco=boat.BarcoV(player.table1,boat.size1,c.x,c.y,i,boat.direccion1);//llamado al metodo para guardar barco en vertical 
                                board.MostrarTablero(player.table1);//llamado al metodo para mostrar tablero
                                libro.readLine();
                                Limpiar.clean();
                            }//fin del while barco
                            break;
                        default:
                            System.out.println("Ingrese una opcion valida mostrada");
                            i--;
                            break;
                    }opc_barco=0; //fin de switch
                    valido=true;
                }catch (Exception e){
                    System.out.println("Ingrese dato valido");
                }//fin try catch
            }//fin de while valido
        }//fin del for de barcos jugador 1
    
        libro.readLine();
        Limpiar.clean();

        //Jugador 2 coloca sus barcos
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
                        case 1: //barco en horicontal
                            board.MostrarTablero(player.table2);
                            boat.size2=boat.TamañoBarco(boat.ilustracion2,boat.size2,i,boat.nbarco2,boat.barco2);//metodo encontrar el tamaño del barco
                            Limpiar.clean();
                            while(!barco){
                                board.MostrarTablero(player.table2);
                                valido2=false; 
                                while(!valido2){
                                    System.out.println("Ingrese coordenadas:");
                                    dato = libro.readLine();
                                    if (dato.isEmpty()) {
                                        System.out.println("Debe ingresar coordenadas.");
                                    } else {
                                        c.GuardarCoords(dato, c.coordenadas2, i);
                                        if (c.x == -1 || c.y == -1) {
                                            System.out.println("Valores inválidos.");
                                        } else {
                                            valido2 = true;
                                        } //fin de if else
                                    }//fin de if else 
                                }//fin de while valido2
                                barco=boat.BarcoH(player.table2,boat.size2,c.x,c.y,i,boat.direccion2);//llamado al metodo para guardar barco en horizontal
                                board.MostrarTablero(player.table2);//llamado al metodo para mostrar tablero
                                libro.readLine();
                                Limpiar.clean();
                            }//fin de while barco
                            break;

                        case 2: //barco en vertical
                        board.MostrarTablero(player.table2);
                        boat.size2=boat.TamañoBarco(boat.ilustracion2,boat.size2,i,boat.nbarco2,boat.barco2);//metodo encontrar el tamaño del barco
                        Limpiar.clean();
                        while(!barco){
                            board.MostrarTablero(player.table2); 
                            valido2=false;
                            while(!valido2){
                                System.out.println("Ingrese coordenadas:");
                                dato = libro.readLine();
                                if (dato.isEmpty()) {
                                    System.out.println("Debe ingresar coordenadas.");
                                } else {
                                    c.GuardarCoords(dato, c.coordenadas2, i);
                                    if (c.x == -1 || c.y == -1) {
                                        System.out.println("Valores inválidos.");
                                    } else {
                                        valido2 = true;
                                    } //fin de if else
                                }//fin de if else 
                            } //fin de while valido 2
                            barco=boat.BarcoV(player.table2,boat.size2,c.x,c.y,i,boat.direccion2);//llamado al metodo para guardar barco en horizontal
                            board.MostrarTablero(player.table2);//llamado al metodo para mostrar tablero
                            libro.readLine();
                            Limpiar.clean();
                        }//fin de while barco
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

            }//fin while valido
        }//fin del for de barcos jugador 2

        Limpiar.clean();

        do {
            String pJugador = "";
            if (turno == 1) {
                pJugador = player.player1;
            } else {
                pJugador = player.player2;
            }//fin de if else
            
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
                        if (dato.isEmpty()) {
                            System.out.println("Debe ingresar coordenadas.");
                        }else if(!dato.equalsIgnoreCase("EXIT")){
                            c.GuardarCoords(dato, c.coordenadas3,i);//Llamado al metodo de pedir coordenadas
                            if(c.x==-1 || c.y==-1){
                                System.out.println("Valores invalidos.");
                            }else{
                                valido2=player.Disparar(player.table2, player.table3, c.coordenadas3, i);
                                System.out.println("Tablero de disparos");
                                board.MostrarTablero(player.table3); 
                            }//fin de if else
                        }else{ //si el jugador 1 se rinde
                            FindelJuego=true;
                            System.out.println("El ganador es \n"+ player.player2);
                            boat.ListaBarcos(boat.size2, c.coordenadas2, boat.direccion2);
                            System.out.println("Y los barcos de "+ player.player1 + " son");
                            boat.ListaBarcos(boat.size1, c.coordenadas1, boat.direccion1);
                            break;
                        }//fin de if else
                    }//fin de while valido2 
                    libro.readLine();       
                }// Fin de turno jugador 1 1

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
                        if (dato.isEmpty()) {
                            System.out.println("Debe ingresar coordenadas.");
                        }else if(!dato.equalsIgnoreCase("EXIT")){
                            c.GuardarCoords(dato, c.coordenadas4,i);//Llamado al metodo de pedir coordenadas
                            if(c.x==-1 || c.y==-1){
                                System.out.println("Valores invalidos.");
                            }else{
                                valido2=player.Disparar(player.table1, player.table4, c.coordenadas4, i);
                                System.out.println("Tablero de disparos");
                                board.MostrarTablero(player.table4);   
                            }//fin de if else
                        }else{ //si el jugador 2 se rinde
                            FindelJuego=true;
                            System.out.println("El ganador es \n"+ player.player1);
                            boat.ListaBarcos(boat.size1, c.coordenadas1, boat.direccion1);
                            System.out.println("Y los barcos de "+ player.player2 + " son");
                            boat.ListaBarcos(boat.size2, c.coordenadas2, boat.direccion2);
                            break;
                        }//fin de if else
                    }//fin de while valido2
                    libro.readLine();
                }// fin de turno jugador 2

            } catch (Exception e) {
                System.out.println("ingrese una coordenada valida");
            } //fin de try catch  

            if (turno == 1) {
                turno = 2; // turno al jugador 2
            } else {
                turno = 1; // turno al jugador 1
            }//fin de if else

            //Verificar si se hundieron todos los barcos de jugador 1
            if (boat.TodosBarcosHundidos(player.table1)) {
                System.out.println("Todos los barcos del jugador 1 se han hundido");
                System.out.println("GANADOR -> Jugador 2: " + pJugador);
                boat.ListaBarcos(boat.size1, c.coordenadas1, boat.direccion1);
                System.out.println("Los barcos de" +player.player1 + " eran");
                boat.ListaBarcos(boat.size1, c.coordenadas1, boat.direccion1);
                FindelJuego = true;
            }//fin de if

            //Verificar si se hundieron todos los barcos de jugador 2
            if (boat.TodosBarcosHundidos(player.table2)) {
                System.out.println("Todos los barcos del jugador 2 se han hundido");
                System.out.println("GANADOR -> Jugador 1: " + pJugador);
                boat.ListaBarcos(boat.size2, c.coordenadas2, boat.direccion2);
                System.out.println("Los barcos de " +player.player2 + " eran");
                boat.ListaBarcos(boat.size2, c.coordenadas2, boat.direccion2);
                FindelJuego = true;
            }//fin de if

            
        } while (!FindelJuego); //fin de do while

        
    }// fin del static 

    
}// fin de la clase 