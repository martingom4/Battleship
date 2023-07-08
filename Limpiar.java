class Limpiar {
    public static void clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        try {
            Thread.sleep(200); // Agregar un retraso de 1 segundo
        } catch (InterruptedException e) {
            // Manejar la excepción si se interrumpe la pausa
            e.printStackTrace();
        }
    }
}
