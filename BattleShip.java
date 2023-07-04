import java.io.*;
public class BattleShip {
    static BufferedReader libro=new BufferedReader(new InputStreamReader(System.in));
    static int t,opc_barco=0;
    public static void main(String[] args) throws IOException {
    
        //aca se pondra todo el codigo principal del proyecto
        Jugador player =new Jugador();
        coordenadas c = new coordenadas();
        Barco boat = new Barco();
        
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
        player.Tablero(player.table1);//llamado al metodo para crear tablero
        
        //Barco
        for(int i=0;i<4;i++){
            try{
                System.out.println("Colocar barco "+(i+1)+": \n1-Horizontal(hacia a la derecha)\n2-Vertical(hacia abajo)");
                opc_barco=Integer.parseInt(libro.readLine());
            }catch(Exception e){

            }//fina try catch
            switch(opc_barco){
                case 1:
                    try{
                        boat.size1=boat.TamañoBarco(boat.ilustracion,boat.size1,i);
                        c.coor(i,c.coordenadas1,c.x,c.y);//Llamado la metodo de pedir coordenadas
                        c.x=c.coordenadasx(c.coordenadas1,i,c.x);
                        c.y=c.coordenadasy(c.coordenadas1,i,c.y);
                        i=player.BarcoH(player.table1,boat.size1,c.x,c.y,i);//llamado al metodo para guardar barco en horizontal
                        player.MostrarTablero(player.table1);//llamado al metodo para mostrar tablero
                    }catch(Exception e){
                        System.out.println("Favor introducir dato correctamente");
                        i--;
                    }
                    break;
                case 2:
                    try{
                        boat.size1=boat.TamañoBarco(boat.ilustracion,boat.size1,i);
                        c.coor(i,c.coordenadas1,c.x,c.y);//Llamado la metodo de pedir coordenadas
                        c.x=c.coordenadasx(c.coordenadas1,i,c.x);
                        c.y=c.coordenadasy(c.coordenadas1,i,c.y);
                        i=player.BarcoV(player.table1,boat.size1,c.x,c.y,i);//llamado al metodo para guardar barco en horizontal
                        player.MostrarTablero(player.table1);//llamado al metodo para mostrar tablero
                    }catch(Exception e){
                        System.out.println("Favor introducir dato correctamente");
                        i--;
                    }
                    break;
                default:
                    System.out.println("Ingrese una opcion valida mostrada");
                    i--;
                    break;
            }opc_barco=0; //Fin del switch
        }//fin del for 
        
        //boat.xyz(boat.size1);
        
        /*Disparo
        System.out.println("Inserte las coordenadas para el disparo!");
        System.out.println("inserte x");
        x=Integer.parseInt(libro.readLine());
        System.out.println("inserte y");
        y=Integer.parseInt(libro.readLine()); 
        obj.Ataque(obj.table1,x,y);//llamado al metodo para atacar
        obj.MostrarTablero(obj.table1);//llamado al metodo para mostrar tablero
        */
    }

}