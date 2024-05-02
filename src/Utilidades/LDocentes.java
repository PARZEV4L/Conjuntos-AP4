package Utilidades;

import Docentes.Docente;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class LDocentes {

    private TreeSet<Docente> Catedra;
    private TreeSet<Docente> Ocasional;
    private TreeSet<Docente> Completo;

    private ArrayList<Docente> arrayCatedra;
    private ArrayList<Docente> arrayOcasional;
    private ArrayList<Docente> arrayCompleto;
    private String sfichero = "src/Archivos/Docentes.txt";

    private String[] opcionesDocentes = {"Docente de Tiempo Completo", "Docente Ocasional", "Docente de Catedra"};

    public LDocentes() {
        this.CargarDatos();
    }

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

    public void Ingresar() {
        int op = 0;
        int op3 = 0;
        int op2 = 0;
        do {
            Docente x = IngresoDoc();
            String res = (String) JOptionPane.showInputDialog(null, "Cual es el tipo de docente", "Docentes",
                    JOptionPane.PLAIN_MESSAGE, null, opcionesDocentes, opcionesDocentes[0]);
            switch (res) {
                case "Docente de Tiempo Completo":
                    Completo.add(x);
                    op2 = JOptionPane.showConfirmDialog(null, "Es tambien docente ocasional?", "Tipo de docente",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    op3 = JOptionPane.showConfirmDialog(null, "Es tambien docente de catedra?", "Tipo de docente",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (op3 == 0 && op2 == 0) {
                        Catedra.add(x);
                        Ocasional.add(x);
                    } else if (op2 != 0 && op3 == 0) {
                        Catedra.add(x);
                    } else if (op3 != 0 && op2 == 0) {
                        Ocasional.add(x);
                    }

                    break;

                case "Docente Ocasional":
                    Ocasional.add(x);
                    op2 = JOptionPane.showConfirmDialog(null, "Es tambien docente de tiempo completo?",
                            "Tipo de docente",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    op3 = JOptionPane.showConfirmDialog(null, "Es tambien docente de catedra?", "Tipo de docente",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (op3 == 0 && op2 == 0) {
                        Catedra.add(x);
                        Completo.add(x);
                    } else if (op2 != 0 && op3 == 0) {
                        Catedra.add(x);
                    } else if (op3 != 0 && op2 == 0) {
                        Completo.add(x);
                    }
                    break;

                case "Docente de Catedra":
                    op2 = JOptionPane.showConfirmDialog(null, "Es tambien docente de tiempo completo?",
                            "Tipo de docente",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    op3 = JOptionPane.showConfirmDialog(null, "Es tambien docente ocasional?", "Tipo de docente",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (op3 == 0 && op2 == 0) {
                        Ocasional.add(x);
                        Completo.add(x);
                    } else if (op2 != 0 && op3 == 0) {
                        Ocasional.add(x);
                    } else if (op3 != 0 && op2 == 0) {
                        Completo.add(x);
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Intente de nuevo");
                    break;
            }
            JOptionPane.showMessageDialog(null, "Se ha ingresado al docente");

            op = JOptionPane.showConfirmDialog(null, "Desea ingresar otro docente?", "Ingresar",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        } while (op == 0);
    }

    private LocalDate fecha() {

        LocalDate x = FechaIngreso.fecha();

        if (FechaIngreso.verificar(x)) {
            JOptionPane.showMessageDialog(null, "Es mayor de edad");
        }
        while (!FechaIngreso.verificar(x)) {
            JOptionPane.showMessageDialog(null, "No esta en el rango de edad para trabajar");
            x = FechaIngreso.fecha();
        }
        return x;
    }

    private Docente IngresoDoc() {
        String[] sex = {"Masculino", "Femenimno"};
        String[] facultades = {"Ingenieria", "Deportes", "Comunicación", "Administracion", "Idiomas",
            "Ciencias Basicas"};
        String[] titulo = {"Pregrado", "Especialista", "maestria", "Doctorado"};
        Docente x = new Docente();
        x.setCc(ingresoCc());
        x.setNombre(IngresoNombre());

        x.setSexo((String) JOptionPane.showInputDialog(null, "Cual es el sexo del docente?", "Docentes",
                JOptionPane.PLAIN_MESSAGE, null, sex, sex[0]));

        String seleccion = (String) JOptionPane.showInputDialog(null, "Selecciona la facultad del docente:",
                "Facultades", JOptionPane.QUESTION_MESSAGE, null, facultades, facultades[0]);
        x.setFacultad(seleccion);

        String titul = (String) JOptionPane.showInputDialog(null, "Selecciona el titulo del docente:",
                "Titulo del docente", JOptionPane.QUESTION_MESSAGE, null, titulo, titulo[0]);

        x.setTitulo(titul);
        x.setAsigDictadas(IngresoAsig());
        x.setHrsDictadas(ingresoHoras());
        x.setFchNacimiento(fecha());
        return x;

    }

    private String ingresoCc() {
        String regex = "^\\d+$";
        String cc = JOptionPane.showInputDialog(null, "Ingrese una cedula sin comas o puntos y solo con digitos.");

        while (!cc.matches(regex)) {
            cc = JOptionPane.showInputDialog(null,
                    "(ERROR, intentar de nuevo) Ingrese una cedula sin comas o puntos y solo con digitos.");
        }
        return cc;
    }

    private String IngresoNombre() {
        String nom = JOptionPane.showInputDialog(null, "Nombre completo del docente");
        String patron = "[a-zA-Z ]+";

        while (!nom.matches(patron)) {
            nom = JOptionPane.showInputDialog(null,
                    "(ERROR, intentar de nuevo) Ingrese una cedula sin comas o puntos y solo con digitos.");
        }
        return nom;
    }

    private int IngresoAsig() {
        String patron = "[1-9]|10";
        String asig = JOptionPane.showInputDialog(null, "Ingrese el numero de asignaturas que dicta (1-10)");
        while (!asig.matches(patron)) {
            asig = JOptionPane.showInputDialog(null,
                    "(ERROR, intentar de nuevo) Ingrese el numero de asignaturas que dicta (1-10)");
        }
        return Integer.parseInt(asig);
    }

    private int ingresoHoras() {
        String patron = "\\d{1,2}|20";
        String hours = JOptionPane.showInputDialog(null, "Ingrese el numero de horas que dicta (1-20)");
        while (!hours.matches(patron)) {
            hours = JOptionPane.showInputDialog(null,
                    "(ERROR, intentar de nuevo) Ingrese el numero de horas que dicta (1-20)");
        }
        return Integer.parseInt(hours);
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
                TreeSet<Docente> x = new TreeSet<>();
                x.addAll(Catedra);
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

        String s = "";
        String[] vectDoc = {"de Tiempo Completo ", "de Catedra ", "de Ocasional ", " "};
        s += " Docentes " + vectDoc[op - 1] + "\n\n";
        Iterator<Docente> itrx = x.iterator();
        for (Docente docente : x) {
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
        s += "En total son: " + x.size() + " Docentes " + vectDoc[op - 1];
        return s;
    }

    // Esta funcion recibe un conjunto y el titulo de el, ya sea de intersecciones o
    // no
    private static String auxMostrar(TreeSet<Docente> x, String titleConjunto) {
        String s = "";
        s += titleConjunto + "\n";
        s += "En total son: " + x.size() + "\n\n";
        Iterator<Docente> itrx = x.iterator();
        for (Docente docente : x) {
            docente = itrx.next();
            s += "\nCc: " + docente.getCc() + "\n"
                    + "Nombre: " + docente.getNombre() + "\n"
                    + "Genero: " + docente.getSexo() + "\n"
                    + "Facultad: " + docente.getFacultad() + "\n"
                    + "Titulo: " + docente.getTitulo() + "\n"
                    + "Cantidad de asignaturas que dicta: " + docente.getAsigDictadas() + "\n"
                    + "Cantidad de horas dictadas semanalmente: " + docente.getHrsDictadas() + "\n"
                    + "Fecha de nacimiento: " + docente.getFchNacimiento()
                    + "\n";
        }
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
        jmostrar( auxMostrar(Catedra, vectDoc[op-1]));
       
    }

    @SuppressWarnings("rawtypes")
    private TreeSet Interseccion(TreeSet<Docente> A, TreeSet<Docente> B, TreeSet<Docente> C) {
        TreeSet<Docente> inters = new TreeSet<>(A);
        inters.retainAll(B);
        inters.removeAll(C);
        return inters;
    }

    public void InterseccionCompletoCatedra() {
        
     TreeSet<Docente> inter = Interseccion(Completo, Catedra,Ocasional);
        String s = auxMostrar(inter, "Docentes que son Tiempo Completo y de Catedra");
        jmostrar(s);
        
    }

    public void InterseccionOcCT() {
        @SuppressWarnings("unchecked")
        TreeSet<Docente> inter = Interseccion(Ocasional, Catedra,Completo);
        String s = auxMostrar(inter, "Docentes que son Ocasionales y de Catedra");
        jmostrar(s);
    }

    public void InterseccionGlobal() {
        TreeSet<Docente> interseccion = new TreeSet<Docente>(Completo);
        interseccion.retainAll(Ocasional);
        interseccion.retainAll(Catedra);
        String s = auxMostrar(interseccion, "Docentes que son de tiempo completo, Catedra y ocasional");
        jmostrar(s);
    }

    public void Contrato() {
        int[] Mujeres = new int[3], Hombres = new int[3];
        for (Docente profesor : Completo) {
            if ((profesor.getSexo()).contains("Femenino")) {
                Mujeres[0]++;
            } else {
                Hombres[0]++;
            }
        }
        for (Docente profesor : Ocasional) {
            if ((profesor.getSexo()).contains("Femenino")) {
                Mujeres[1]++;
            } else {
                Hombres[1]++;
            }
        }
        for (Docente profesor : Catedra) {
            if ((profesor.getSexo()).contains("Femenino")) {
                Mujeres[2]++;
            } else {
                Hombres[2]++;
            }
        }
        String s = "Cantidad de Hombres y mujeres por tipo de contrato: \n";
        s = "Tiempo Completo: \n    Hombres: " + Hombres[0] + "\n    Mujeres: " + Mujeres[0]
                + "\nOcacional: \n    Hombres: " + Hombres[1] + "\n    Mujeres: " + Mujeres[1]
                + "\nCatedra: \n    Hombres: " + Hombres[2] + "\n    Mujeres: " + Mujeres[2];

        jmostrar(s);
    }

    public TreeSet<Docente> Union() {
        TreeSet<Docente> union = new TreeSet<>(Completo);
        union.addAll(Ocasional);
        union.addAll(Catedra);
        return union;
    }

    public static void Facultad(TreeSet<Docente> docentes) {
        Map<String, TreeSet<Docente>> docentesPorFacultad = new HashMap<>();
        for (Docente docente : docentes) {
            String facultad = docente.getFacultad();
            docentesPorFacultad.putIfAbsent(facultad, new TreeSet<>());
            docentesPorFacultad.get(facultad).add(docente);
        }
        String s = "";
        for (Map.Entry<String, TreeSet<Docente>> entry : docentesPorFacultad.entrySet()) {
            s += "Facultad " + entry.getKey() + " con " + entry.getValue().size() + " docentes de los cuales son: "
                    + auxMostrar(entry.getValue(), "\n" + entry.getKey());
            s += "\n-----------------------------\n";
        }
        jmostrar(s);
    }
    
      public static void Titulo(TreeSet<Docente> docentes) {
        Map<String, TreeSet<Docente>> docentesPorTitulo = new HashMap<>();
        for (Docente docente : docentes) {
            String Titulo = docente.getTitulo();
            docentesPorTitulo.putIfAbsent(Titulo, new TreeSet<>());
            docentesPorTitulo.get(Titulo).add(docente);
        }
        String s = "";
        for (Map.Entry<String, TreeSet<Docente>> entry : docentesPorTitulo.entrySet()) {
            s += "Titulo " + entry.getKey() + " con " + entry.getValue().size() + " docentes de los cuales son: "
                    + auxMostrar(entry.getValue(), "\n" + entry.getKey());
            s += "\n-----------------------------\n";
        }
        jmostrar(s);
    }
}
