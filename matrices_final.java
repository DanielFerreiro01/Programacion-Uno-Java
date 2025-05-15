// Procesamiento de ventas mensuales en base a secuencias de datos separados por ceros
public class matrices_final {

    // Constantes del programa
    final static int MAXFILAS = 3; // cantidad de meses (filas de la matriz)
    final static int MAXCOL = 15;  // cantidad de días (columnas)
    final static int N = 3;        // tamaño del arreglo 'meses'
    final static int X = 200;      // valor mínimo promedio de ventas por secuencia
    final static int SEP = 0;      // valor separador entre secuencias

    public static void main(String[] args) {
        // Matriz de ventas mensuales por día (secuencias separadas por ceros)
        int[][] ventasMensuales = {
                {0, 0, 150, 200, 165, 0, 154, 352, 240, 256, 0, 900, 750, 0, 0},
                {0, 940, 105, 265, 845, 215, 0, 245, 65, 48, 0, 741, 125, 541, 0},
                {0, 851, 543, 625, 845, 914, 0, 754, 184, 0, 637, 917, 0, 0, 0}
        };

        // Meses a evaluar (1-based index). El 0 final indica fin de datos.
        int[] meses = {1, 3, 0};

        System.out.println("📊 Matriz original de ventas mensuales:");
        mostrar_matriz(ventasMensuales);
        System.out.println();

        System.out.println("📈 Procesamiento de ventas con promedio mayor a $" + X + ":");
        procesar_ventas_meses(ventasMensuales, meses);
        System.out.println();

        System.out.println("🧾 Matriz resultante (con secuencias eliminadas si no cumplen condición):");
        mostrar_matriz(ventasMensuales);
    }

    // Recorre los meses indicados y procesa sus ventas diarias
    public static void procesar_ventas_meses(int[][] mat, int[] arr) {
        int pos = 0;
        while (pos < N && arr[pos] != 0) {
            int mes = arr[pos];
            int count = procesar_ventas_diarias(mat[mes - 1]);
            System.out.println(" - Mes " + mes + ": " + count + " secuencia(s) con promedio > $" + X);
            pos++;
        }
    }

    // Procesa las secuencias de un mes: cuenta y elimina según promedio
    public static int procesar_ventas_diarias(int[] arr) {
        int ini = 0, fin = -1, count = 0;
        while (ini < MAXCOL) {
            ini = buscar_inicio(arr, fin + 1);
            if (ini < MAXCOL) {
                fin = buscar_fin(arr, ini);
                if (es_mayor(arr, ini, fin)) {
                    count++;
                } else {
                    eliminar_secuencia(arr, ini, fin);
                    fin = ini;
                }
            }
        }
        return count;
    }

    // Evalúa si el promedio de una secuencia supera X
    public static boolean es_mayor(int[] arr, int ini, int fin) {
        int tamanio = fin - ini + 1, sum = 0;
        for (int pos = ini; pos <= fin; pos++) {
            sum += arr[pos];
        }
        return sum / tamanio > X;
    }

    // Elimina una secuencia moviendo los elementos hacia la izquierda
    public static void eliminar_secuencia(int[] arr, int ini, int fin) {
        int tamanio = fin - ini + 1;
        while (tamanio > 0) {
            corrimiento_izquierda(arr, ini);
            tamanio--;
        }
    }

    // Desplaza todos los elementos hacia la izquierda desde una posición dada
    public static void corrimiento_izquierda(int[] arr, int pos) {
        while (pos < MAXCOL - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
        arr[MAXCOL - 1] = SEP; // Reemplaza el último valor con el separador
    }

    // Busca el inicio de una secuencia (diferente de 0)
    public static int buscar_inicio(int[] arr, int pos) {
        while (pos < MAXCOL && arr[pos] == SEP) {
            pos++;
        }
        return pos;
    }

    // Busca el fin de una secuencia (hasta el próximo 0)
    public static int buscar_fin(int[] arr, int pos) {
        while (pos < MAXCOL && arr[pos] != SEP) {
            pos++;
        }
        return pos - 1;
    }

    // Imprime la matriz de forma ordenada
    public static void mostrar_matriz(int[][] mat) {
        for (int fila = 0; fila < MAXFILAS; fila++) {
            System.out.print("Mes " + (fila + 1) + ": ");
            for (int columna = 0; columna < MAXCOL; columna++) {
                System.out.print(mat[fila][columna] + (columna < MAXCOL - 1 ? " | " : ""));
            }
            System.out.println();
        }
    }
}
