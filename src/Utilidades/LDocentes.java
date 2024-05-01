package Utilidades;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import Docentes.Docente;
import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

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
        Catedra = new TreeSet<>();
        Ocasional = new TreeSet<>();
        Completo = new TreeSet<>();

        File fichero = new File(sfichero);
        Scanner s = null;

        try {

            s = new Scanner(fichero);
            int op = 0;

            while (s.hasNextLine()) {
                String linea = s.nextLine();
                String[] cortarString = linea.split(";");

                if (cortarString.length >= 9) {
                    op = Integer.parseInt(cortarString[0]);
                    Docente docente = new Docente();
                    docente.setCc(cortarString[1]);
                    docente.setNombre(cortarString[2]);
                    docente.setSexo(cortarString[3]);
                    docente.setFacultad(cortarString[4]);
                    if (!cortarString[5].isEmpty()) {
                        docente.setAsigDictadas(Integer.parseInt(cortarString[5]));
                    }
                    if (!cortarString[6].isEmpty()) {
                        docente.setHrsDictadas(Integer.parseInt(cortarString[6]));
                    }
                    docente.setFchNacimiento(LocalDate.parse(cortarString[7]));
                    docente.setTitulo(cortarString[8]);
                    switch (op) {
                        case 1:
                            arrayCompleto.add(docente);
                            Completo.add(docente);
                            break;
                        case 2:
                            arrayOcasional.add(docente);
                            Ocasional.add(docente);
                            break;
                        case 3:
                            arrayCatedra.add(docente);
                            Catedra.add(docente);
                            break;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Se han cargado los datos");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public void IngresarDocente() {

    }

    public static String ingresotD() {
        int opcion;
        boolean salir = false;
        while (!salir) {
            String[] options = {"Docente de Tiempo Completo", "Docente Ocasional", "Docente de Catedra"};
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

    public void mostrar(int op) {
        String s = "";
        switch (op) {
            case 1:
                s = auxMostrar(Completo, op);
                break;
            case 2:
                s = auxMostrar(Ocasional, op);

                break;
            case 3:
                s = auxMostrar(Catedra, op);

                break;
            case 4:
                TreeSet<Docente> x = Catedra;
                x.addAll(Completo);
                x.addAll(Ocasional);
                  s = auxMostrar(x, op);
                break;
            default:
                break;
        }
        jmostrar(s);

    }

    private static String auxMostrar(TreeSet<Docente> x, int op) {
        int contador = 0;
        String s = "";
        String[] vectDoc = {"de Tiempo Completo ", "de Catedra ", "de Ocasional ", " "};
        s += " Docentes " + vectDoc[op-1] + "\n\n";
        Iterator<Docente> itrx = x.iterator();
        for (Docente docente : x) {
            contador += 1;
            docente = itrx.next();
            s += "Cc: " + docente.getCc() + ", "
                    + "Nombre: " + docente.getNombre() + ", "
                    + "Genero: " + docente.getSexo() + ", "
                    + "Facultad: " + docente.getFacultad() + ", "
                    + "Titulo: " + docente.getTitulo() + ", "
                    + "Cantidad de asignaturas que dicta: " + docente.getAsigDictadas() + ", "
                    + "Cantidad de horas dictadas semanalmente: " + docente.getHrsDictadas() + ", "
                    + "Fecha de nacimiento: " + docente.getFchNacimiento()
                    + "\n";
        }
        s += "En total son: " + contador + " Docentes " + vectDoc[op-1];
        return s;
    }

    public static void jmostrar(String s) {
        int p = 500, t = 300;
        JTextArea textArea = new JTextArea(s);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize(new Dimension(p, t));
        JOptionPane.showMessageDialog(null, scrollPane, "Docentes", 1);

    }

    public void conjuntoExclusivo(int op) {
        String[] vectDoc = {"Tiempo Completo solamente", "Catedra solamente", "Ocasional solamente"};
        String s = "";
        TreeSet<Docente> Tdocente = new TreeSet<>();
        TreeSet<Docente> TAuxDocente = new TreeSet<>();
        switch (op) {
            case 1:

                Tdocente.addAll(Catedra);
                Tdocente.addAll(Ocasional);
                TAuxDocente = Completo;
                TAuxDocente.removeAll(Tdocente);

                break;

            case 2:

                Tdocente.addAll(Completo);
                Tdocente.addAll(Ocasional);
                TAuxDocente = Catedra;
                TAuxDocente.removeAll(Tdocente);

                break;

            case 3:

                Tdocente.addAll(Completo);
                Tdocente.addAll(Catedra);
                TAuxDocente = Ocasional;
                TAuxDocente.removeAll(Tdocente);

                break;
            default:
                break;

        }
        int contador = 0;
        s += vectDoc[op-1] + "\n";
        for (Docente docente : TAuxDocente) {
            contador += 1;
            s += "Cc: " + docente.getCc() + ", "
                    + "Nombre: " + docente.getNombre() + ", "
                    + "Genero: " + docente.getSexo() + ", "
                    + "Facultad: " + docente.getFacultad() + ", "
                    + "Titulo: " + docente.getTitulo() + ", "
                    + "Cantidad de asignaturas que dicta: " + docente.getAsigDictadas() + ", "
                    + "Cantidad de horas dictadas semanalmente: " + docente.getHrsDictadas() + ", "
                    + "Fecha de nacimiento: " + docente.getFchNacimiento()
                    + "\n";
        }
        s += "En total son: " + contador + " Docentes de " + vectDoc[op-1];
        jmostrar(s);
    }

    public  void InterseccionCompletoCatedra(){
        String s = "";
        TreeSet<Docente> Interseccion = Completo;
        
        Interseccion.retainAll(Catedra);
         
          int contador = 0;
        for (Docente docente : Interseccion) {
            contador += 1;
            s += "Cc: " + docente.getCc() + ", "
                    + "Nombre: " + docente.getNombre() + ", "
                    + "Genero: " + docente.getSexo() + ", "
                    + "Facultad: " + docente.getFacultad() + ", "
                    + "Titulo: " + docente.getTitulo() + ", "
                    + "Cantidad de asignaturas que dicta: " + docente.getAsigDictadas() + ", "
                    + "Cantidad de horas dictadas semanalmente: " + docente.getHrsDictadas() + ", "
                    + "Fecha de nacimiento: " + docente.getFchNacimiento()
                    + "\n";
        }
        s += "En total son: " + contador;
        jmostrar(s);
        
    }
}
