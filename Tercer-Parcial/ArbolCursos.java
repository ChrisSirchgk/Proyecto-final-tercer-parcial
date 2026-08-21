public class ArbolCursos {

    private NodoArbolCurso raiz;

    public ArbolCursos() {
        raiz = null;
    }

    // ==========================================
    // Insertar Curso
    // ==========================================

    public void insertar(Curso curso) {

        raiz = insertarRecursivo(raiz, curso);
    }

    private NodoArbolCurso insertarRecursivo(
            NodoArbolCurso nodo,
            Curso curso) {

        if (nodo == null) {
            return new NodoArbolCurso(curso);
        }

        if (curso.getIdCurso() < nodo.curso.getIdCurso()) {

            nodo.izquierda =
                    insertarRecursivo(nodo.izquierda, curso);

        } else if (curso.getIdCurso() > nodo.curso.getIdCurso()) {

            nodo.derecha =
                    insertarRecursivo(nodo.derecha, curso);
        }

        return nodo;
    }

    // ==========================================
    // Buscar Curso
    // ==========================================

    public Curso buscar(int idCurso) {

        NodoArbolCurso resultado =
                buscarRecursivo(raiz, idCurso);

        if (resultado != null) {
            return resultado.curso;
        }

        return null;
    }

    private NodoArbolCurso buscarRecursivo(
            NodoArbolCurso nodo,
            int idCurso) {

        if (nodo == null) {
            return null;
        }

        if (idCurso == nodo.curso.getIdCurso()) {
            return nodo;
        }

        if (idCurso < nodo.curso.getIdCurso()) {

            return buscarRecursivo(
                    nodo.izquierda,
                    idCurso
            );

        } else {

            return buscarRecursivo(
                    nodo.derecha,
                    idCurso
            );
        }
    }

    // ==========================================
    // Rec. Inorden
    // ==========================================

    public void mostrarInorden() {

        if (raiz == null) {

            System.out.println("El arbol esta vacio.");
            return;
        }

        System.out.println("\n===== Rec. Inorden =====");

        inorden(raiz);
    }

    private void inorden(NodoArbolCurso nodo) {

        if (nodo != null) {

            inorden(nodo.izquierda);

            nodo.curso.mostrarInfo();

            inorden(nodo.derecha);
        }
    }
}