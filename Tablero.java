public class Tablero{
    //METODO CREAR TABLERO
    public void CrearTablero(String table[][]){
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table.length;j++){
                table[i][j]="-";
            }
        }
    }

    // METODO PARA IMPRIMIR EL TABLERO (poner en archivo tablero)
    public void MostrarTablero(String[][] tablero) {
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        System.out.println("  ╔═══════════════════════════╗");
        System.out.println("  \u2551 1  2  3  4  5  6  7  8  9 \u2551");
        System.out.println("  ╠═══════════════════════════╣");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(letras[i] + " \u2551");
            
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(" " + tablero[i][j] + " ");
            }
            
            System.out.println("\u2551");
        }
        
        System.out.println("  ╚═══════════════════════════╝");
    }
}
