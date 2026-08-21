import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Curso> cursos =
            new ArrayList<>();

    static ArbolCursos arbol =
            new ArbolCursos();

    static GrafoCursos grafo =
            new GrafoCursos();

    static HistorialAcciones historial =
            new HistorialAcciones();

    static Scanner sc =
            new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {

            mostrarMenu();

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    agregarCurso();
                    break;

                case 2:
                    mostrarCursos();
                    break;

                case 3:
                    eliminarCurso();
                    break;

                case 4:
                    inscribirEstudiante();
                    break;

                case 5:
                    bajaEstudiante();
                    break;

                case 6:
                    insertarCursosArbol();
                    break;

                case 7:
                    buscarCursoArbol();
                    break;

                case 8:
                    arbol.mostrarInorden();
                    break;

                case 9:
                    crearRelacion();
                    break;

                case 10:
                    grafo.mostrarGrafo();
                    grafo.mostrarRelaciones();
                    break;

                case 11:
                    bubbleDirecto();
                    break;

                case 12:
                    bubbleInverso();
                    break;

                case 13:
                    insercion();
                    break;

                case 14:
                    seleccion();
                    break;

                case 15:
                    busquedaSecuencial();
                    break;

                case 16:
                    busquedaBinaria();
                    break;

                case 17:
                    historial.mostrar();
                    break;

                case 18:
                    compararBusquedas();
                    break;

                case 19:
                    System.out.println(
                            "Saliendo del sistema..."
                    );
                    break;

                default:
                    System.out.println(
                            "Opción inválida."
                    );
            }

        } while (opcion != 19);
    }

    // ==========================================
    // MENÚ
    // ==========================================

    public static void mostrarMenu() {

        System.out.println(
                "\n=============================================="
        );

        System.out.println(
                "     SISTEMA DE GESTIÓN DE CURSOS UTC 3.0"
        );

        System.out.println(
                "=============================================="
        );

        System.out.println("1. Agregar curso");
        System.out.println("2. Mostrar cursos");
        System.out.println("3. Eliminar curso");
        System.out.println("4. Inscribir estudiante");
        System.out.println("5. Dar de baja estudiante");
        System.out.println("6. Insertar cursos en árbol binario");
        System.out.println("7. Buscar curso en árbol binario");
        System.out.println("8. Mostrar recorrido inorden del árbol");
        System.out.println("9. Crear relación entre cursos");
        System.out.println("10. Mostrar grafo o matriz de adyacencia");
        System.out.println("11. Ordenar cursos con Bubble Sort directo");
        System.out.println("12. Ordenar cursos con Bubble Sort inverso");
        System.out.println("13. Ordenar cursos con inserción directa");
        System.out.println("14. Ordenar cursos con selección directa");
        System.out.println("15. Búsqueda secuencial");
        System.out.println("16. Búsqueda binaria");
        System.out.println("17. Mostrar historial de acciones");
        System.out.println("18. Comparar pasos de búsqueda");
        System.out.println("19. Salir");
    }

    // ==========================================
    // AGREGAR CURSO
    // ==========================================

    public static void agregarCurso() {

        System.out.print("ID del curso: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (buscarPorId(id) != null) {

            System.out.println(
                    "Error: el ID ya existe."
            );

            return;
        }

        System.out.print("Clave: ");
        String clave = sc.nextLine();

        if (buscarPorClave(clave) != null) {

            System.out.println(
                    "Error: la clave ya existe."
            );

            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Docente: ");
        String docente = sc.nextLine();

        System.out.print("Cupo máximo: ");
        int cupo = sc.nextInt();
        sc.nextLine();

        if (cupo <= 0) {

            System.out.println(
                    "El cupo debe ser mayor que cero."
            );

            return;
        }

        Curso nuevo = new Curso(
                id,
                clave,
                nombre,
                docente,
                cupo
        );

        cursos.add(nuevo);

        grafo.agregarCurso(nuevo);

        historial.agregar(
                "Se agregó el curso: "
                + nombre
        );

        System.out.println(
                "Curso agregado correctamente."
        );
    }

    // ==========================================
    // MOSTRAR CURSOS
    // ==========================================

    public static void mostrarCursos() {

        if (cursos.isEmpty()) {

            System.out.println(
                    "No existen cursos registrados."
            );

            return;
        }

        System.out.println(
                "\n===== CURSOS REGISTRADOS ====="
        );

        for (Curso curso : cursos) {

            curso.mostrarInfo();
        }
    }

    // ==========================================
    // BUSCAR ID
    // ==========================================

    public static Curso buscarPorId(int id) {

        for (Curso curso : cursos) {

            if (curso.getIdCurso() == id) {

                return curso;
            }
        }

        return null;
    }

    // ==========================================
    // BUSCAR CLAVE
    // ==========================================

    public static Curso buscarPorClave(String clave) {

        for (Curso curso : cursos) {

            if (curso.getClave()
                    .equalsIgnoreCase(clave)) {

                return curso;
            }
        }

        return null;
    }

    // ==========================================
    // ELIMINAR
    // ==========================================

    public static void eliminarCurso() {

        System.out.print("ID del curso: ");
        int id = sc.nextInt();
        sc.nextLine();

        Curso curso = buscarPorId(id);

        if (curso == null) {

            System.out.println(
                    "Curso no encontrado."
            );

            return;
        }

        cursos.remove(curso);

        historial.agregar(
                "Se eliminó el curso: "
                + curso.getNombre()
        );

        System.out.println(
                "Curso eliminado correctamente."
        );
    }

    // ==========================================
    // INSCRIBIR
    // ==========================================

    public static void inscribirEstudiante() {

        System.out.print("ID del curso: ");
        int id = sc.nextInt();
        sc.nextLine();

        Curso curso = buscarPorId(id);

        if (curso == null) {

            System.out.println(
                    "Curso no encontrado."
            );

            return;
        }

        if (curso.inscribir()) {

            System.out.println(
                    "Estudiante inscrito correctamente."
            );

            historial.agregar(
                    "Se inscribió un estudiante en "
                    + curso.getNombre()
            );

        } else {

            System.out.println(
                    "El curso está lleno."
            );
        }
    }

    // ==========================================
    // BAJA
    // ==========================================

    public static void bajaEstudiante() {

        System.out.print("ID del curso: ");
        int id = sc.nextInt();
        sc.nextLine();

        Curso curso = buscarPorId(id);

        if (curso == null) {

            System.out.println(
                    "Curso no encontrado."
            );

            return;
        }

        if (curso.baja()) {

            System.out.println(
                    "Baja realizada correctamente."
            );

            historial.agregar(
                    "Se dio de baja un estudiante de "
                    + curso.getNombre()
            );

        } else {

            System.out.println(
                    "No hay estudiantes inscritos."
            );
        }
    }

    // ==========================================
    // ÁRBOL
    // ==========================================

    public static void insertarCursosArbol() {

        if (cursos.isEmpty()) {

            System.out.println(
                    "No existen cursos registrados."
            );

            return;
        }

        for (Curso curso : cursos) {

            arbol.insertar(curso);
        }

        System.out.println(
                "Cursos insertados en el árbol."
        );

        historial.agregar(
                "Se insertaron cursos en el árbol binario"
        );
    }

    public static void buscarCursoArbol() {

        System.out.print("ID a buscar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Curso curso = arbol.buscar(id);

        if (curso != null) {

            System.out.println(
                    "Curso encontrado en el árbol:"
            );

            curso.mostrarInfo();

        } else {

            System.out.println(
                    "Curso no encontrado en el árbol."
            );
        }
    }

    // ==========================================
    // GRAFO
    // ==========================================

    public static void crearRelacion() {

        if (cursos.size() < 2) {

            System.out.println(
                    "Se necesitan al menos 2 cursos."
            );

            return;
        }

        System.out.print("ID del curso origen: ");
        int origen = sc.nextInt();

        System.out.print("ID del curso destino: ");
        int destino = sc.nextInt();

        sc.nextLine();

        if (origen == destino) {

            System.out.println(
                    "No se puede relacionar un curso consigo mismo."
            );

            return;
        }

        if (grafo.crearRelacion(origen, destino)) {

            System.out.println(
                    "Relación creada correctamente."
            );

            historial.agregar(
                    "Se creó una relación entre "
                    + origen
                    + " y "
                    + destino
            );

        } else {

            System.out.println(
                    "No se pudo crear la relación."
            );
        }
    }

    // ==========================================
    // ORDENAMIENTOS
    // ==========================================

    public static void bubbleDirecto() {

        Ordenamientos.bubbleSortDirecto(cursos);

        System.out.println(
                "\nCursos ordenados con Bubble Sort directo:"
        );

        Ordenamientos.mostrarCursos(cursos);

        historial.agregar(
                "Se ejecutó Bubble Sort directo"
        );
    }

    public static void bubbleInverso() {

        Ordenamientos.bubbleSortInverso(cursos);

        System.out.println(
                "\nCursos ordenados con Bubble Sort inverso:"
        );

        Ordenamientos.mostrarCursos(cursos);

        historial.agregar(
                "Se ejecutó Bubble Sort inverso"
        );
    }

    public static void insercion() {

        Ordenamientos.insercionDirecta(cursos);

        System.out.println(
                "\nCursos ordenados con inserción directa:"
        );

        Ordenamientos.mostrarCursos(cursos);

        historial.agregar(
                "Se ejecutó inserción directa"
        );
    }

    public static void seleccion() {

        Ordenamientos.seleccionDirecta(cursos);

        System.out.println(
                "\nCursos ordenados con selección directa:"
        );

        Ordenamientos.mostrarCursos(cursos);

        historial.agregar(
                "Se ejecutó selección directa"
        );
    }

    // ==========================================
    // BÚSQUEDA SECUENCIAL
    // ==========================================

    public static void busquedaSecuencial() {

        System.out.print("ID a buscar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Curso resultado =
                Busquedas.busquedaSecuencial(
                        cursos,
                        id
                );

        if (resultado != null) {

            System.out.println(
                    "Curso encontrado:"
            );

            resultado.mostrarInfo();

        } else {

            System.out.println(
                    "Curso no encontrado."
            );
        }
    }

    // ==========================================
    // BÚSQUEDA BINARIA
    // ==========================================

    public static void busquedaBinaria() {

        if (cursos.isEmpty()) {

            System.out.println(
                    "No existen cursos."
            );

            return;
        }

        // La búsqueda binaria necesita
        // los datos ordenados.
        Ordenamientos.bubbleSortDirecto(cursos);

        System.out.print(
                "ID a buscar: "
        );

        int id = sc.nextInt();
        sc.nextLine();

        Curso resultado =
                Busquedas.busquedaBinaria(
                        cursos,
                        id
                );

        if (resultado != null) {

            System.out.println(
                    "Curso encontrado:"
            );

            resultado.mostrarInfo();

        } else {

            System.out.println(
                    "Curso no encontrado."
            );
        }

        historial.agregar(
                "Se ejecutó búsqueda binaria"
        );
    }

    // ==========================================
    // COMPARACIÓN DE PASOS
    // ==========================================

    public static void compararBusquedas() {

        if (cursos.isEmpty()) {

            System.out.println(
                    "No existen cursos."
            );

            return;
        }

        Ordenamientos.bubbleSortDirecto(cursos);

        System.out.print(
                "ID a buscar: "
        );

        int id = sc.nextInt();
        sc.nextLine();

        int pasosSecuencial =
                Busquedas.pasosSecuencial(
                        cursos,
                        id
                );

        int pasosBinaria =
                Busquedas.pasosBinaria(
                        cursos,
                        id
                );

        Curso curso =
                Busquedas.busquedaBinaria(
                        cursos,
                        id
                );

        if (curso == null) {

            System.out.println(
                    "El curso no fue encontrado."
            );

        } else {

            System.out.println(
                    "\n===== COMPARACIÓN DE BÚSQUEDAS ====="
            );

            System.out.println(
                    "Curso encontrado: "
                    + curso.getNombre()
            );

            System.out.println(
                    "Pasos búsqueda secuencial: "
                    + pasosSecuencial
            );

            System.out.println(
                    "Pasos búsqueda binaria: "
                    + pasosBinaria
            );
        }

        historial.agregar(
                "Se compararon búsqueda secuencial y binaria"
        );
    }
}