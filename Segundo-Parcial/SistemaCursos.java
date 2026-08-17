import java.util.Scanner;
import java.util.Stack;

public class SistemaCursos {

    static ListaEnlazada listaCursos = new ListaEnlazada();

    static ListaDoble listaDoble = new ListaDoble();

    static Stack<String> historial = new Stack<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {

            System.out.println("\n==============================================");
            System.out.println("     SISTEMA DE GESTIÓN DE CURSOS UTC 2.0");
            System.out.println("==============================================");

            System.out.println("1. Agregar curso");
            System.out.println("2. Mostrar cursos");
            System.out.println("3. Buscar curso por clave");
            System.out.println("4. Eliminar curso");
            System.out.println("5. Inscribir estudiante");
            System.out.println("6. Dar de baja estudiante");
            System.out.println("7. Mostrar cursos de inicio a fin");
            System.out.println("8. Mostrar cursos de fin a inicio");
            System.out.println("9. Navegador de cursos");
            System.out.println("10. Contar cursos usando recursividad");
            System.out.println("11. Buscar curso usando recursividad");
            System.out.println("12. Mostrar historial");
            System.out.println("13. Salir");

            System.out.print("\nSeleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    agregarCurso();
                    break;

                case 2:
                    listaCursos.mostrar();
                    break;

                case 3:
                    buscarCurso();
                    break;

                case 4:
                    eliminarCurso();
                    break;

                case 5:
                    inscribirEstudiante();
                    break;

                case 6:
                    bajaEstudiante();
                    break;

                case 7:
                    listaDoble.mostrarInicioFin();
                    break;

                case 8:
                    listaDoble.mostrarFinInicio();
                    break;

                case 9:
                    listaDoble.navegador();
                    break;

                case 10:
                    contarCursos();
                    break;

                case 11:
                    buscarCursoRecursivo();
                    break;

                case 12:
                    mostrarHistorial();
                    break;

                case 13:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 13);
    }

    // =========================================
    // AGREGAR CURSO
    // =========================================

    public static void agregarCurso() {

        System.out.print("Clave: ");
        String clave = sc.nextLine();

        // VALIDAR CLAVE REPETIDA
        if (listaCursos.buscar(clave) != null) {

            System.out.println("Error: la clave ya existe.");
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

            System.out.println("El cupo debe ser mayor a cero.");
            return;
        }

        Curso nuevo = new Curso(
                clave,
                nombre,
                docente,
                cupo
        );

        // Agregar a la lista simple
        listaCursos.agregar(nuevo);

        // Agregar a la lista doble
        listaDoble.agregar(nuevo);

        historial.push("Se agregó el curso: " + nombre);

        System.out.println("Curso agregado correctamente.");
    }

    // =========================================
    // BUSCAR CURSO
    // =========================================

    public static void buscarCurso() {

        System.out.print("Ingrese la clave del curso: ");
        String clave = sc.nextLine();

        Curso curso = listaCursos.buscar(clave);

        if (curso != null) {

            System.out.println("Curso encontrado:");
            curso.mostrarInfo();

        } else {

            System.out.println("Curso no encontrado.");
        }
    }

    // =========================================
    // ELIMINAR CURSO
    // =========================================

    public static void eliminarCurso() {

        System.out.print("Ingrese la clave del curso: ");
        String clave = sc.nextLine();

        Curso curso = listaCursos.buscar(clave);

        if (curso == null) {

            System.out.println("Curso no encontrado.");
            return;
        }

        boolean eliminado = listaCursos.eliminar(clave);

        if (eliminado) {

            historial.push("Se eliminó el curso: "
                    + curso.getNombre());

            System.out.println("Curso eliminado correctamente.");

            System.out.println(
                    "Nota: el curso eliminado permanece en la lista doble "
                    + "para mantener el módulo de navegación."
            );
        }
    }

    // =========================================
    // INSCRIBIR ESTUDIANTE
    // =========================================

    public static void inscribirEstudiante() {

        System.out.print("Ingrese la clave del curso: ");
        String clave = sc.nextLine();

        Curso curso = listaCursos.buscar(clave);

        if (curso == null) {

            System.out.println("Curso no encontrado.");
            return;
        }

        if (curso.inscribir()) {

            System.out.println("Estudiante inscrito correctamente.");

            historial.push(
                    "Se inscribió un estudiante en: "
                    + curso.getNombre()
            );

        } else {

            System.out.println("El curso está lleno.");
        }
    }

    // =========================================
    // DAR DE BAJA
    // =========================================

    public static void bajaEstudiante() {

        System.out.print("Ingrese la clave del curso: ");
        String clave = sc.nextLine();

        Curso curso = listaCursos.buscar(clave);

        if (curso == null) {

            System.out.println("Curso no encontrado.");
            return;
        }

        if (curso.baja()) {

            System.out.println("Baja realizada correctamente.");

            historial.push(
                    "Se dio de baja un estudiante de: "
                    + curso.getNombre()
            );

        } else {

            System.out.println(
                    "No se puede realizar la baja. "
                    + "El curso no tiene estudiantes inscritos."
            );
        }
    }

    // =========================================
    // CONTAR CURSOS RECURSIVAMENTE
    // =========================================

    public static void contarCursos() {

        int total = listaCursos.contarRecursivo();

        System.out.println(
                "Total de cursos registrados: " + total
        );
    }

    // =========================================
    // BUSCAR RECURSIVAMENTE
    // =========================================

    public static void buscarCursoRecursivo() {

        System.out.print("Ingrese la clave del curso: ");
        String clave = sc.nextLine();

        Curso curso = listaCursos.buscarRecursivo(clave);

        if (curso != null) {

            System.out.println("Curso encontrado recursivamente:");

            curso.mostrarInfo();

        } else {

            System.out.println(
                    "Curso no encontrado mediante recursividad."
            );
        }
    }

    // =========================================
    // HISTORIAL
    // =========================================

    public static void mostrarHistorial() {

        if (historial.isEmpty()) {

            System.out.println("No hay acciones registradas.");
            return;
        }

        System.out.println("\n===== HISTORIAL DE ACCIONES =====");

        for (String accion : historial) {

            System.out.println(accion);
        }
    }
}