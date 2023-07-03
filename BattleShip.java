import java.io.*;


public class BattleShip {
    public static void main(String[] args) throws IOException {
        Coordenadas coords=new Coordenadas();

        BufferedReader libro = new BufferedReader(new InputStreamReader(System.in));
        String player1, player2;
        String dato="";
        int x, y, i, t;
        boolean valido1, valido2;
        Boolean fin=false;

        System.out.println("--BATTLESHIP--");

        System.out.println("Ingrese nombre del jugador 1:");
        player1=libro.readLine();
        System.out.println("Ingrese nombre del jugador 2:");
        player2=libro.readLine();

        System.out.println("\n--"+player1+", coloque sus barcos--");
        for (i=1; i<5; i++){
            System.out.println("Barco "+i);
            valido1=false;
            valido2=false;
            while(!valido1){
                try{
                    System.out.println("Ingrese tamaño del barco:");
                    t = Integer.parseInt(libro.readLine());
                    if(0<t && t<5){
                        valido1=true;
                        while(!valido2){
                            System.out.println("Ingrese coordenadas:");
                            dato = libro.readLine();
                            x=coords.coordenadasx(dato);
                            y=coords.coordenadasy(dato);
                            if(x==-1 || y==-1){
                                System.out.println("Valores invalidos.");
                            }else{
                                valido2=true;
                                //insertar metodo de colocar barcos de jugador 1
                            }
                        }
                    }else{
                        System.out.println("Ingrese tamaño valido.");
                    }
                }catch(Exception e){
                    System.out.println("Ingrese valores numericos");
                }
            }
        }

        System.out.println("\n--"+player2+", coloque sus barcos--");
        for (i=1; i<5; i++){
            System.out.println("Barco "+i);
            valido1=false;
            valido2=false;
            while(!valido1){
                try{
                    System.out.println("Ingrese tamaño del barco:");
                    t = Integer.parseInt(libro.readLine());
                    if(0<t && t<5){
                        valido1=true;
                        while(!valido2){
                            System.out.println("Ingrese coordenadas:");
                            dato = libro.readLine();
                            x=coords.coordenadasx(dato);
                            y=coords.coordenadasy(dato);
                            if(x==-1 || y==-1){
                                System.out.println("Valores invalidos.");
                            }else{
                                valido2=true;
                                //insertar metodo de colocar barcos de jugador 2
                            }
                        }
                    }else{
                        System.out.println("Ingrese tamaño valido.");
                    }
                }catch(Exception e){
                    System.out.println("Ingrese valores numericos");
                }
            }
        }

        System.out.println("\nIngrese FIN para terminar el juego.");
        
        while(!fin){
            valido1=false;
            valido2=false;
            while(!valido1){
                System.out.println("\n--Turno de "+player1+"--");
                System.out.println("Ingrese coordenadas:");
                dato = libro.readLine();
                if(!dato.equals("FIN")){
                    x=coords.coordenadasx(dato);
                    y=coords.coordenadasy(dato);
                    if(x==-1 || y==-1){
                        System.out.println("Valores invalidos.");
                    }else{
                        valido1=true;
                        //insertar metodo de atacar
                        while(!valido2){
                            System.out.println("\n--Turno de "+player2+"--");
                            System.out.println("Ingrese coordenadas:");
                            dato = libro.readLine();
                            if(!dato.equals("FIN")){
                                x=coords.coordenadasx(dato);
                                y=coords.coordenadasy(dato);
                                if(x==-1 || y==-1){
                                    System.out.println("Valores invalidos.");
                                }else{
                                    valido2=true;
                                    //insertar metodo de atacar
                                }
                            }else{
                                fin=true;
                                valido2=true;
                                System.out.println(player1+" GANA");
                                //insertar metodo de mostrar lista de barcos
                            }
                        }
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
