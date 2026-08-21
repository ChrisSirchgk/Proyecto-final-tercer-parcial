import java.util.ArrayList;

public class GrafoCursos {

    private ArrayList<Curso> cursos;
    private int[][] matriz;

    public GrafoCursos() {

        cursos = new ArrayList<>();
        matriz = new int[0][0];
    }

    // ==========================================
    // AGREGAR CURSO AL GRAFO
    // ==========================================

    public void agregarCurso(Curso curso) {

        if (buscarIndice(curso.getIdCurso()) != -1) {
            return;
        }

        cursos.add(curso);

        actualizarMatriz();
    }

    // ==========================================
    // ACTUALIZAR MATRIZ
    // ==========================================

    private void actualizarMatriz() {

        int nuevoTamano = cursos.size();

        int[][] nuevaMatriz =
                new int[nuevoTamano][nuevoTamano];

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                nuevaMatriz[i][j] = matriz[i][j];
            }
        }

        matriz = nuevaMatriz;
    }

    // ==========================================
    // CREAR RELACIÓN
    // ==========================================

    public boolean crearRelacion(int idOrigen, int idDestino) {

        int origen = buscarIndice(idOrigen);
        int destino = buscarIndice(idDestino);

        if (origen == -1 || destino == -1) {
            return false;
        }

        matriz[origen][destino] = 1;

        return true;
    }

    // ==========================================
    // BUSCAR ÍNDICE
    // ==========================================

    private int buscarIndice(int idCurso) {

        for (int i = 0; i < cursos.size(); i++) {

            if (cursos.get(i).getIdCurso() == idCurso) {
                return i;
            }
        }

        return -1;
    }

    // ==========================================
    // MOSTRAR GRAFO
    // ==========================================

    public void mostrarGrafo() {

        if (cursos.isEmpty()) {

            System.out.println("No existen cursos en el grafo.");
            return;
        }

        System.out.println("\n===== MATRIZ DE ADYACENCIA =====");

        System.out.print("       ");

        for (Curso curso : cursos) {

            System.out.printf("%6d",
                    curso.getIdCurso());
        }

        System.out.println();

        for (int i = 0; i < cursos.size(); i++) {

            System.out.printf("%6d",
                    cursos.get(i).getIdCurso());

            for (int j = 0; j < cursos.size(); j++) {

                System.out.printf("%6d",
                        matriz[i][j]);
            }

            System.out.println();
        }

        System.out.println("\n1 = existe relación");
        System.out.println("0 = no existe relación");
    }

    // ==========================================
    // MOSTRAR RELACIONES
    // ==========================================

    public void mostrarRelaciones() {

        if (cursos.isEmpty()) {

            System.out.println("No existen cursos.");
            return;
        }

        System.out.println("\n===== RELACIONES ENTRE CURSOS =====");

        boolean existe = false;

        for (int i = 0; i < cursos.size(); i++) {

            for (int j = 0; j < cursos.size(); j++) {

                if (matriz[i][j] == 1) {

                    System.out.println(
                            cursos.get(i).getNombre()
                            + " -> "
                            + cursos.get(j).getNombre()
                    );

                    existe = true;
                }
            }
        }

        if (!existe) {
            System.out.println("No existen relaciones.");
        }
    }
}