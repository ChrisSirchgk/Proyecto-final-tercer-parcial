import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class SistemaCursos {

    static ArrayList<Curso> cursos = new ArrayList<>();
    static Stack<String> historial = new Stack<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n===== SISTEMA UTC =====");
            System.out.println("1. Agregar curso");
            System.out.println("2. Mostrar cursos");
            System.out.println("3. Buscar curso por clave");
            System.out.println("4. Inscribir estudiante");
            System.out.println("5. Dar de baja estudiante");
            System.out.println("6. Eliminar curso");
            System.out.println("7. Mostrar historial");
            System.out.println("8. Generar reporte de cursos ordenados por inscritos");
            System.out.println("9. Salir");

            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {
                case 1:
                    agregarCurso();
                    break;
                case 2:
                    mostrarCursos();
                    break;
                case 3:
                    buscarCurso();
                    break;
                case 4:
                    inscribirEstudiante();
                    break;
                case 5:
                    bajaEstudiante();
                    break;
                case 6:
                    eliminarCurso();
                    break;
                case 7:
                    mostrarHistorial();
                    break;
                case 8:
                    generarReporte();
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while(opcion != 9);
    }

    // Agregar curso
    public static void agregarCurso() {
        System.out.print("Clave: ");
        String clave = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Docente: ");
        String docente = sc.nextLine();

        System.out.print("Cupo maximo: ");
        int cupo = sc.nextInt();
        sc.nextLine();

        Curso nuevo = new Curso(clave, nombre, docente, cupo);
        cursos.add(nuevo);

        historial.push("Se agrego el curso " + nombre);

        System.out.println("Curso agregado");
    }

    // Mostrar cursos
    public static void mostrarCursos() {
        if(cursos.isEmpty()) {
            System.out.println("No hay cursos");
            return;
        }

        for(Curso c : cursos) {
            c.mostrarInfo();
        }
    }

    // Buscar curso
    public static void buscarCurso() {
        System.out.print("Ingrese clave: ");
        String clave = sc.nextLine();

        for(Curso c : cursos) {
            if(c.getClave().equalsIgnoreCase(clave)) {
                c.mostrarInfo();
                return;
            }
        }

        System.out.println("Curso no encontrado");
    }

    // Inscribir estudiante
    public static void inscribirEstudiante() {
        System.out.print("Clave del curso: ");
        String clave = sc.nextLine();

        for(Curso c : cursos) {
            if(c.getClave().equalsIgnoreCase(clave)) {

                if(c.inscribir()) {
                    System.out.println("Estudiante inscrito");
                    historial.push("Se inscribio un estudiante en " + c.getNombre());
                } else {
                    System.out.println("Curso lleno");
                }

                return;
            }
        }

        System.out.println("Curso no encontrado");
    }

    // Dar de baja estudiante
    public static void bajaEstudiante() {
        System.out.print("Clave del curso: ");
        String clave = sc.nextLine();

        for(Curso c : cursos) {
            if(c.getClave().equalsIgnoreCase(clave)) {

                if(c.baja()) {
                    System.out.println("Baja realizada");
                    historial.push("Se dio de baja un estudiante en " + c.getNombre());
                } else {
                    System.out.println("No hay inscritos");
                }

                return;
            }
        }

        System.out.println("Curso no encontrado");
    }

    // Eliminar curso
    public static void eliminarCurso() {
        System.out.print("Clave del curso: ");
        String clave = sc.nextLine();

        for(int i = 0; i < cursos.size(); i++) {
            if(cursos.get(i).getClave().equalsIgnoreCase(clave)) {

                historial.push("Se elimino el curso " + cursos.get(i).getNombre());

                cursos.remove(i);

                System.out.println("Curso eliminado");
                return;
            }
        }

        System.out.println("Curso no encontrado");
    }

    // Mostrar historial
    public static void mostrarHistorial() {
        if(historial.isEmpty()) {
            System.out.println("Sin historial");
            return;
        }

        System.out.println("===== HISTORIAL =====");

        for(String accion : historial) {
            System.out.println(accion);
        }
    }

    // Generar reporte de cursos ordenados por inscritos
    public static void generarReporte() {

        if(cursos.isEmpty()) {
            System.out.println("No hay cursos registrados");
            return;
        }

        // Ordenar de mayor a menor por inscritos
        for(int i = 0; i < cursos.size() - 1; i++) {
            for(int j = 0; j < cursos.size() - 1 - i; j++) {

                if(cursos.get(j).getInscritos() < cursos.get(j + 1).getInscritos()) {

                    Curso temp = cursos.get(j);
                    cursos.set(j, cursos.get(j + 1));
                    cursos.set(j + 1, temp);
                }
            }
        }

        // Mostrar reporte
        System.out.println("\n===== REPORTE DE CURSOS =====");
        System.out.println("Cursos ordenados por inscritos");
        System.out.println();

        for(Curso c : cursos) {
            System.out.println("Curso: " + c.getNombre());
            System.out.println("Clave: " + c.getClave());
            System.out.println("Inscritos: " + c.getInscritos());
            System.out.println("----------------------------");
        }

        historial.push("Se genero reporte de cursos");
    }
}