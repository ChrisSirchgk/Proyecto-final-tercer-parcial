public class ListaEnlazada {

    private Nodo cabeza;

    // AGREGAR CURSO
    public void agregar(Curso curso) {

        Nodo nuevo = new Nodo(curso);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        actual.siguiente = nuevo;
    }

    // MOSTRAR CURSOS
    public void mostrar() {

        if (cabeza == null) {
            System.out.println("No hay cursos registrados.");
            return;
        }

        Nodo actual = cabeza;

        while (actual != null) {

            actual.curso.mostrarInfo();
            actual = actual.siguiente;
        }
    }

    // BUSCAR CURSO
    public Curso buscar(String clave) {

        Nodo actual = cabeza;

        while (actual != null) {

            if (actual.curso.getClave().equalsIgnoreCase(clave)) {
                return actual.curso;
            }

            actual = actual.siguiente;
        }

        return null;
    }

    // ELIMINAR CURSO
    public boolean eliminar(String clave) {

        if (cabeza == null) {
            return false;
        }

        // Si el curso está en el primer nodo
        if (cabeza.curso.getClave().equalsIgnoreCase(clave)) {

            cabeza = cabeza.siguiente;
            return true;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null) {

            if (actual.siguiente.curso.getClave()
                    .equalsIgnoreCase(clave)) {

                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    // ==============================
    // RECURSIVIDAD 1
    // CONTAR CURSOS
    // ==============================

    public int contarRecursivo() {

        return contarDesde(cabeza);
    }

    private int contarDesde(Nodo nodo) {

        if (nodo == null) {
            return 0;
        }

        return 1 + contarDesde(nodo.siguiente);
    }

    // ==============================
    // RECURSIVIDAD 2
    // BUSCAR CURSO
    // ==============================

    public Curso buscarRecursivo(String clave) {

        return buscarDesde(cabeza, clave);
    }

    private Curso buscarDesde(Nodo nodo, String clave) {

        if (nodo == null) {
            return null;
        }

        if (nodo.curso.getClave().equalsIgnoreCase(clave)) {
            return nodo.curso;
        }

        return buscarDesde(nodo.siguiente, clave);
    }
}