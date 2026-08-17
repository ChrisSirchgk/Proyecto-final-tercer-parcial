public class NodoDoble {

    Curso curso;
    NodoDoble anterior;
    NodoDoble siguiente;

    public NodoDoble(Curso curso) {

        this.curso = curso;
        this.anterior = null;
        this.siguiente = null;
    }
}