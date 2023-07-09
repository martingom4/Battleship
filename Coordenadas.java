public class Coordenadas {
        String dato="";
        int x, y, i, t;
        Barco boat = new Barco();
        String[]coordenadas1=new String[4];//arreglo que guarda las coordenadas
        String[]coordenadas2=new String[4];
        String[]coordenadas3=new String[4];
        String[]coordenadas4=new String[4];
         
        
       

    public int coordenadasy(String coordenada[], int i)  {
    int num;
    int y;
    try {
        if (coordenada[i] != null) {  // Verificar si la cadena no es nula
            num = Integer.parseInt(coordenada[i].substring(1));
            if (num > 0 && num < 11) {
                y = num - 1;
            } else {
                y = -1;
            }
        } else {
            y = -1;
        }
    } catch (Exception e) {
        y = -1;
    }
    return y;
}
    public int coordenadasx(String coordenada[],int i){
        String letra;
        int x;
        letra=coordenada[i].substring(0, 1).toUpperCase();
        if(letra.equals("A") || letra.equals("a")){
            x=0;
        }else if(letra.equals("B") || letra.equals("b")){
            x=1;
        }else if(letra.equals("C") || letra.equals("c")){
            x=2;
        }else if(letra.equals("D") || letra.equals("d")){
            x=3;
        }else if(letra.equals("E") || letra.equals("e")){
            x=4;
        }else if(letra.equals("F") || letra.equals("f")){
            x=5;
        }else if(letra.equals("G") || letra.equals("g")){
            x=6;
        }else if(letra.equals("H") || letra.equals("h")){
            x=7;
        }else if(letra.equals("I") || letra.equals("i")){
            x=8;
        }else if(letra.equals("J") || letra.equals("j")){
            x=9;
        }else{
            x=-1;
        }
        return x;
    }
     public String[] guardarcoords(String dato, String[]coordenada,int i){
        coordenada[i]=dato;
        x=coordenadasx(coordenada,i);
        y=coordenadasy(coordenada,i);
        return coordenada;
        
    }
    //metodo para disparar 
   

    //metodo para verificar que los barcos se han hundido
   
    public boolean todosBarcosHundidos(String[][] table) {
    for (int i = 0; i < table.length; i++) {
        for (int j = 0; j < table[0].length; j++) {
            if (table[i][j].equals("0")) {
                return false; // si se hundido uno, retornara false
            }
        }
    }
    return true; // no hay barcos hundidos, retorna verdadero
}
   
}