import java.io.*;


public class BattleShip {
    public static void main(String[] args) throws IOException {
    BufferedReader libro=new BufferedReader(new InputStreamReader(System.in));
        //aca se pondra todo el codigo principal del proyecto
        Jugador obj =new Jugador();
        
        int x,y,t;

        obj.Tablero(obj.table1);
        for(int i=0;i<2;i++){
            System.out.println("inserte las coordenadas de la fila");
            x=Integer.parseInt(libro.readLine());
            System.out.println("inserte las coordenadas de la columna");
            y=Integer.parseInt(libro.readLine());
            System.out.println("inserte tamaño del barco");
            t=Integer.parseInt(libro.readLine());
            obj.BarcoH(obj.table1,t,x,y);
        }
        obj.MostrarTablero(obj.table1);

        System.out.println("inserte x");
        x=Integer.parseInt(libro.readLine());
        System.out.println("inserte y");
        y=Integer.parseInt(libro.readLine());
        obj.Ataque(obj.table1,x,y);
        obj.MostrarTablero(obj.table1);
        
    }
}
