import java.util.Scanner;

public class ListaDoble {

    private NodoDoble inicio;
    private NodoDoble fin;

    // AGREGAR AL FINAL
    public void agregar(Curso curso) {

        NodoDoble nuevo = new NodoDoble(curso);

        if (inicio == null) {

            inicio = nuevo;
            fin = nuevo;
            return;
        }

        fin.siguiente = nuevo;
        nuevo.anterior = fin;
        fin = nuevo;
    }

    // MOSTRAR DE INICIO A FIN
    public void mostrarInicioFin() {

        if (inicio == null) {

            System.out.println("La lista doble está vacía.");
            return;
        }

        NodoDoble actual = inicio;

        while (actual != null) {

            actual.curso.mostrarInfo();
            actual = actual.siguiente;
        }
    }

    // MOSTRAR DE FIN A INICIO
    public void mostrarFinInicio() {

        if (fin == null) {

            System.out.println("La lista doble está vacía.");
            return;
        }

        NodoDoble actual = fin;

        while (actual != null) {

            actual.curso.mostrarInfo();
            actual = actual.anterior;
        }
    }

    // NAVEGADOR CARRUSEL
    public void navegador() {

        if (inicio == null) {

            System.out.println("No hay cursos para navegar.");
            return;
        }

        Scanner sc = new Scanner(System.in);

        NodoDoble actual = inicio;

        int opcion;

        do {

            System.out.println("\n===== NAVEGADOR DE CURSOS =====");

            actual.curso.mostrarInfo();

            System.out.println("\n1. Avanzar al siguiente curso");
            System.out.println("2. Regresar al curso anterior");
            System.out.println("3. Salir");

            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    if (actual.siguiente != null) {

                        actual = actual.siguiente;

                    } else {

                        System.out.println("Ya estás en el último curso.");
                    }

                    break;

                case 2:

                    if (actual.anterior != null) {

                        actual = actual.anterior;

                    } else {

                        System.out.println("Ya estás en el primer curso.");
                    }

                    break;

                case 3:

                    System.out.println("Saliendo del navegador...");
                    break;

                default:

                    System.out.println("Opción inválida.");
            }

        } while (opcion != 3);
    }
}