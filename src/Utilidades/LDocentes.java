package Utilidades;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

import Docentes.Docente;
import javax.swing.*;
import java.time.LocalDate;


public class LDocentes {

    private TreeSet<Docente> Catedra;
    private TreeSet<Docente> Ocasional;
    private TreeSet<Docente> Completo;

    private ArrayList<Docente> arrayCatedra;
    private ArrayList<Docente> arrayOcasional;
    private ArrayList<Docente> arrayCompleto;
    private String sfichero = "src/Archivos/Docentes.txt";

    public void CargarDatos() {
        this.arrayCatedra = new ArrayList<>();
        this.arrayOcasional = new ArrayList<>();
        this.arrayCompleto = new ArrayList<>();
        File fichero = new File(sfichero);
        Scanner s = null;

        try {

            s = new Scanner(fichero);
            int op = 0;

            while (s.hasNextLine()) {
                String linea = s.nextLine();
                String[] cortarString = linea.split(";");

                op = Integer.parseInt(cortarString[0]);
                Docente docente = new Docente();
                docente.setCc(cortarString[1]);
                docente.setNombre(cortarString[2]);
                docente.setSexo(cortarString[3]);
                docente.setFacultad(cortarString[4]);
                docente.setAsigDictadas(Integer.parseInt(cortarString[5]));
                docente.setHrsDictadas(Integer.parseInt(cortarString[6]));
                docente.setFchNacimiento(LocalDate.parse(cortarString[7]));
                docente.setTitulo(cortarString[8]);
                switch (op) {
                    case 1:

                        break;

                    case 2:

                        break;

                    case 3:

                        break;
                }

            }
            JOptionPane.showMessageDialog(null, "Se han cargado los datos");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (s != null)
                    s.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public void IngresarDocente(){
        
    }

    public static String ingresotD() {
        int opcion;
        boolean salir = false;
        while (!salir) {
            String[] options = { "Docente de Tiempo Completo", "Docente Ocasional", "Docente de Catedra" };
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Tipos de docentes",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            switch (opcion) {
                case 0:
                    return "Docente de Planta";

                case 1:
                    return "Docente Ocasional";

                case 2:
                    return "Docente de Catedra";
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
            }
        }

        return null;
    }

}
