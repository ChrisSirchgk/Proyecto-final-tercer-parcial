public class NodoArbolCurso {

    Curso curso;

    NodoArbolCurso izquierda;
    NodoArbolCurso derecha;

    public NodoArbolCurso(Curso curso) {

        this.curso = curso;
        this.izquierda = null;
        this.derecha = null;
    }
}