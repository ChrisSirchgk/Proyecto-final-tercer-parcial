import java.util.ArrayList;

public class Busquedas {

    // ==========================================
    // BÚSQUEDA SECUENCIAL
    // ==========================================

    public static Curso busquedaSecuencial(
            ArrayList<Curso> cursos,
            int idBuscado) {

        for (Curso curso : cursos) {

            if (curso.getIdCurso() == idBuscado) {

                return curso;
            }
        }

        return null;
    }

    // ==========================================
    // BÚSQUEDA SECUENCIAL CON PASOS
    // ==========================================

    public static int pasosSecuencial(
            ArrayList<Curso> cursos,
            int idBuscado) {

        int pasos = 0;

        for (Curso curso : cursos) {

            pasos++;

            if (curso.getIdCurso() == idBuscado) {

                return pasos;
            }
        }

        return pasos;
    }

    // ==========================================
    // BÚSQUEDA BINARIA
    // ==========================================

    public static Curso busquedaBinaria(
            ArrayList<Curso> cursos,
            int idBuscado) {

        int inicio = 0;
        int fin = cursos.size() - 1;

        while (inicio <= fin) {

            int medio = (inicio + fin) / 2;

            int idMedio =
                    cursos.get(medio).getIdCurso();

            if (idMedio == idBuscado) {

                return cursos.get(medio);
            }

            if (idBuscado < idMedio) {

                fin = medio - 1;

            } else {

                inicio = medio + 1;
            }
        }

        return null;
    }

    // ==========================================
    // BÚSQUEDA BINARIA CON PASOS
    // ==========================================

    public static int pasosBinaria(
            ArrayList<Curso> cursos,
            int idBuscado) {

        int inicio = 0;
        int fin = cursos.size() - 1;

        int pasos = 0;

        while (inicio <= fin) {

            pasos++;

            int medio = (inicio + fin) / 2;

            int idMedio =
                    cursos.get(medio).getIdCurso();

            if (idMedio == idBuscado) {

                return pasos;
            }

            if (idBuscado < idMedio) {

                fin = medio - 1;

            } else {

                inicio = medio + 1;
            }
        }

        return pasos;
    }
}