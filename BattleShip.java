import java.io.*;


public class BattleShip {
    public static void main(String[] args) throws IOException {
        BufferedReader libro = new BufferedReader(new InputStreamReader(System.in));
        String player1, player2;
        String dato="";
        String x;
        int y, i, t;
        boolean valido1, valido2;
        Boolean fin=false;

        System.out.println("--BATTLESHIP--");

        System.out.println("Ingrese nombre del jugador 1:");
        player1=libro.readLine();
        System.out.println("Ingrese nombre del jugador 2:");
        player2=libro.readLine();

        System.out.println("\n--"+player1+", inserte sus barcos--");
        for (i=1; i<5; i++){
            System.out.println("Barco "+i);
            valido1=false;
            while(!valido1){
                System.out.println("Ingrese tamaño del barco:");
                t = Integer.parseInt(libro.readLine());
                if(0<t && t<5){
                    System.out.println("Ingrese coordenadas:");
                    dato = libro.readLine();
                    try {    
                        x=dato.substring(0, 1);
                        y=Integer.parseInt(dato.substring(1));
                        if ((x.matches("[A-J]*"))&&(0<y && y<11)){
                            //insertar metodo de colocar barcos de jugador 1
                            System.out.println("x:"+x);
                            System.out.println("y:"+y);
                            System.out.println("tamaño:"+t);
                            valido1=true;
                        }else{
                            System.out.println("Valores invalidos.");
                        }
                    } catch (Exception e) {
                        System.out.println("Dato incorrecto.");
                    }
                }else{
                    System.out.println("Ingrese tamaño valido.");
                }
            }
        }


        System.out.println("\n--"+player2+", inserte sus barcos--");
        for (i=1; i<5; i++){
            System.out.println("Barco "+i);
            valido2=false;
            while(!valido2){
                System.out.println("Ingrese tamaño del barco:");
                t = Integer.parseInt(libro.readLine());
                if(0<t && t<5){
                    System.out.println("Ingrese coordenadas:");
                    dato = libro.readLine();
                    try {    
                        x=dato.substring(0, 1);
                        y=Integer.parseInt(dato.substring(1));
                        if ((x.matches("[A-J]*"))&&(0<y && y<11)){
                            //insertar metodo de colocar barcos de jugador 1
                            System.out.println("x:"+x);
                            System.out.println("y:"+y);
                            System.out.println("tamaño:"+t);
                            valido2=true;
                        }else{
                            System.out.println("Valores invalidos.");
                        }
                    } catch (Exception e) {
                        System.out.println("Dato incorrecto.");
                    }
                }else{
                    System.out.println("Ingrese tamaño valido.");
                }
            }
        }
        
        System.out.println("\nIngrese FIN para terminar el juego.");
        
        while(!fin){
            valido1=false;
            while(!valido1){
                System.out.println("\n--Turno de "+player1+"--");
                System.out.println("Ingrese coordenadas:");
                dato = libro.readLine();
                if(!dato.equals("FIN")){
                    try {    
                        x=dato.substring(0, 1);
                        y=Integer.parseInt(dato.substring(1));
                        if ((x.matches("[A-J]*"))&&(0<y && y<11)){
                            System.out.println("x:"+x);
                            System.out.println("y:"+y);
                            valido1=true;
                            //insertar metodo de atacar de jugador 1
                            valido2=false;
                            while(!valido2){
                                System.out.println("\n--Turno de "+player2+"--");
                                System.out.println("Ingrese coordenadas:");
                                dato = libro.readLine();
                                if(dato.equals("FIN")){
                                    fin=true;
                                    valido2=true;
                                    System.out.println(player1+" GANA");
                                    //insertar metodo de mostrar lista de barcos
                                } else{
                                    try {    
                                        x=dato.substring(0, 1);
                                        y=Integer.parseInt(dato.substring(1));
                                        if ((x.matches("[A-J]*"))&&(0<y && y<11)){
                                            System.out.println("x:"+x);
                                            System.out.println("y:"+y);
                                            valido2=true;
                                            //insertar metodo de atacar de jugador 2
                                        }else{
                                            System.out.println("Valores invalidos");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Dato incorrecto");
                                    }
                                }
                            }
                        }else{
                            System.out.println("Valores invalidos");
                        }
                    } catch (Exception e) {
                        System.out.println("Dato incorrecto");
                    }
                }else{
                    fin=true;
                    valido1=true;
                    System.out.println(player2+" GANA");
                    //insertar metodo de mostrar lista de barcos
                }
            }
        }
    }
}
