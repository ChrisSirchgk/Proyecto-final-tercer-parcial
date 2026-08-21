import java.util.ArrayList;

public class Ordenamientos {

    // ==========================================
    // BUBBLE SORT DIRECTO
    // MENOR A MAYOR
    // ==========================================

    public static void bubbleSortDirecto(
            ArrayList<Curso> cursos) {

        for (int i = 0; i < cursos.size() - 1; i++) {

            for (int j = 0;
                 j < cursos.size() - 1 - i;
                 j++) {

                if (cursos.get(j).getIdCurso()
                        > cursos.get(j + 1).getIdCurso()) {

                    Curso temporal = cursos.get(j);

                    cursos.set(j, cursos.get(j + 1));

                    cursos.set(j + 1, temporal);
                }
            }
        }
    }

    // ==========================================
    // BUBBLE SORT INVERSO
    // MAYOR A MENOR
    // ==========================================

    public static void bubbleSortInverso(
            ArrayList<Curso> cursos) {

        for (int i = 0; i < cursos.size() - 1; i++) {

            for (int j = 0;
                 j < cursos.size() - 1 - i;
                 j++) {

                if (cursos.get(j).getIdCurso()
                        < cursos.get(j + 1).getIdCurso()) {

                    Curso temporal = cursos.get(j);

                    cursos.set(j, cursos.get(j + 1));

                    cursos.set(j + 1, temporal);
                }
            }
        }
    }

    // ==========================================
    // INSERCIÓN DIRECTA
    // ==========================================

    public static void insercionDirecta(
            ArrayList<Curso> cursos) {

        for (int i = 1; i < cursos.size(); i++) {

            Curso actual = cursos.get(i);

            int j = i - 1;

            while (j >= 0 &&
                    cursos.get(j).getIdCurso()
                    > actual.getIdCurso()) {

                cursos.set(j + 1, cursos.get(j));

                j--;
            }

            cursos.set(j + 1, actual);
        }
    }

    // ==========================================
    // SELECCIÓN DIRECTA
    // ==========================================

    public static void seleccionDirecta(
            ArrayList<Curso> cursos) {

        for (int i = 0; i < cursos.size() - 1; i++) {

            int posicionMenor = i;

            for (int j = i + 1;
                 j < cursos.size();
                 j++) {

                if (cursos.get(j).getIdCurso()
                        < cursos.get(posicionMenor).getIdCurso()) {

                    posicionMenor = j;
                }
            }

            Curso temporal = cursos.get(i);

            cursos.set(i, cursos.get(posicionMenor));

            cursos.set(posicionMenor, temporal);
        }
    }

    // ==========================================
    // MOSTRAR LISTA
    // ==========================================

    public static void mostrarCursos(
            ArrayList<Curso> cursos) {

        if (cursos.isEmpty()) {

            System.out.println("No existen cursos.");

            return;
        }

        for (Curso curso : cursos) {

            System.out.println(
                    "ID: " + curso.getIdCurso()
                    + " | "
                    + curso.getNombre()
            );
        }
    }
}