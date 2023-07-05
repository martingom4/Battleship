public class Disparo {
    void Disparar(String[][] table, int x, int y) {
        if (table[x][y].equals(" ")) {
            System.out.println(" ");
            table[x][y] = "-";
        } else if (table[x][y].equals(" ")) {
            System.out.println(" ");
            table[x][y] = "";
        } else if (table[x][y].equals(" ") || table[x][y].equals("-")) {
            System.out.println(" ");
        }
    }
}