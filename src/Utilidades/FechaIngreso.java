package Utilidades;

import com.toedter.calendar.JDateChooser;//--1
import javax.swing.*;//--1
import java.awt.*;//--1
import java.time.LocalDate;//--1
import java.time.Period;//--1
import java.time.ZoneId;//--1
import java.util.concurrent.atomic.AtomicReference;//--1

public class FechaIngreso {//T(n) = 5n+53


    public static LocalDate fecha() {// T(n) = 5n+34
        // Crear un nuevo marco (ventana)
        JFrame frame = new JFrame("Seleccionar fecha");///
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurar el cierre del programa cuando se cierra la
                                                              // ventana
        frame.setSize(300, 200); // Establecer el tamaño del marco

        // Crear un nuevo panel principal con disposición GridBagLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        frame.add(mainPanel);

        // Configurar restricciones para los componentes dentro del panel
        GridBagConstraints constraints = new GridBagConstraints();

        // Crear y agregar una etiqueta al panel
        JLabel label = new JLabel("Seleccione una fecha:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        mainPanel.add(label, constraints);

        // Crear y agregar un JDateChooser (selector de fecha) al panel
        JDateChooser fecha = new JDateChooser();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        mainPanel.add(fecha, constraints);

        // Crear y agregar un botón al panel
        JButton button = new JButton("Guardar fecha");
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        mainPanel.add(button, constraints);
        AtomicReference<LocalDate> edad = new AtomicReference<>();
        // Agregar un listener al botón para manejar eventos de clic
        button.addActionListener(e -> {
            java.util.Date fechaselect = fecha.getDate(); // Obtener la fecha seleccionada del JDateChooser
            if (fechaselect != null) {
                System.out.println("Fecha seleccionada: " + fechaselect);
                edad.set(LocalDate.ofInstant(fechaselect.toInstant(), ZoneId.systemDefault()));

                frame.dispose();

            } else {
                // Imprimir si no se seleccionó ninguna fecha
                System.out.println("No se seleccionó ninguna fecha");
            }
        });

        // Hacer visible el marco
        frame.setVisible(true);
        while (edad.get() == null) {
            try {
                Thread.sleep(100); // Esperar 100 milisegundos antes de volver a verificar
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        return edad.get();
    }

    public static boolean verificar(LocalDate fecha) {//T(n) = 10
        int edad = calcularEdad(fecha); 
        String menor = "([0-9]|1[0-7])";
        String mayor = "(9[0-9]{1,2}|1000)";
        String neg = "^-[0-9]+$";
        String edadStr = Integer.toString(edad);

        if (edadStr.matches(neg) || edadStr.matches(menor) || edadStr.matches(mayor)) {
            return false;
        }
        return true;
    }

    private static int calcularEdad(LocalDate fechaNacimiento) {//T(n) = 2
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaNacimiento, fechaActual).getYears();
    }
}
