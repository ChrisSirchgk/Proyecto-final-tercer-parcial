public class Curso {
    private String clave;
    private String nombre;
    private String docente;
    private int cupoMaximo;
    private int inscritos;

    // Constructor
    public Curso(String clave, String nombre, String docente, int cupoMaximo) {
        this.clave = clave;
        this.nombre = nombre;
        this.docente = docente;
        this.cupoMaximo = cupoMaximo;
        this.inscritos = 0;
    }

    // Getters
    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public int getInscritos() {
        return inscritos;
    }

    // Inscribir estudiante
    public boolean inscribir() {
        if (inscritos < cupoMaximo) {
            inscritos++;
            return true;
        }
        return false;
    }

    // Dar de baja
    public boolean baja() {
        if (inscritos > 0) {
            inscritos--;
            return true;
        }
        return false;
    }

    public void mostrarInfo() {
        System.out.println("---------------------------");
        System.out.println("Clave: " + clave);
        System.out.println("Nombre: " + nombre);
        System.out.println("Docente: " + docente);
        System.out.println("Cupo Maximo: " + cupoMaximo);
        System.out.println("Inscritos: " + inscritos);
    }
}