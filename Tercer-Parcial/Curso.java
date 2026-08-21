public class Curso {

    private int idCurso;
    private String clave;
    private String nombre;
    private String docente;
    private int cupoMaximo;
    private int numeroInscritos;

    // Constructor
    public Curso(int idCurso, String clave, String nombre,
                 String docente, int cupoMaximo) {

        this.idCurso = idCurso;
        this.clave = clave;
        this.nombre = nombre;
        this.docente = docente;
        this.cupoMaximo = cupoMaximo;
        this.numeroInscritos = 0;
    }

    // Getters
    public int getIdCurso() {
        return idCurso;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocente() {
        return docente;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public int getNumeroInscritos() {
        return numeroInscritos;
    }

    // Inscribir estudiante
    public boolean inscribir() {

        if (numeroInscritos < cupoMaximo) {
            numeroInscritos++;
            return true;
        }

        return false;
    }

    // Dar de baja estudiante
    public boolean baja() {

        if (numeroInscritos > 0) {
            numeroInscritos--;
            return true;
        }

        return false;
    }

    // Mostrar informacion
    public void mostrarInfo() {

        System.out.println("----------------------------");
        System.out.println("ID: " + idCurso);
        System.out.println("Clave: " + clave);
        System.out.println("Nombre: " + nombre);
        System.out.println("Docente: " + docente);
        System.out.println("Cupo maximo: " + cupoMaximo);
        System.out.println("Inscritos: " + numeroInscritos);
        System.out.println("----------------------------");
    }
}