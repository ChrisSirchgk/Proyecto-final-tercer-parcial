import java.util.Stack;

public class HistorialAcciones {

    private Stack<String> historial;

    public HistorialAcciones() {

        historial = new Stack<>();
    }

    // Agregar acción
    public void agregar(String accion) {

        historial.push(accion);
    }

    // Mostrar historial
    public void mostrar() {

        if (historial.isEmpty()) {

            System.out.println(
                    "No hay acciones registradas."
            );

            return;
        }

        System.out.println(
                "\n===== HISTORIAL DE ACCIONES ====="
        );

        for (int i = historial.size() - 1;
             i >= 0;
             i--) {

            System.out.println(
                    historial.get(i)
            );
        }
    }
}