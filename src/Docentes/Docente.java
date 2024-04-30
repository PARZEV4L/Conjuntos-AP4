package Docentes;
import java.time.LocalDate;

public class Docente implements Comparable<Docente>{
    private String Cc;
    private String Nombre;
    private  String Sexo;
    private String Facultad;
    private String Titulo;
    private int AsigDictadas;
    private int HrsDictadas;
    private LocalDate FchNacimiento;

    public Docente() {
    }


    public static boolean validarCedula(String cedula) {
        String patron = "\\d+";
        return cedula.matches(patron);
    }


    public static boolean validarNombre(String nombre) {
        String patron = "[a-zA-Z ]+";
        return nombre.matches(patron);
    }



    public static boolean validarCantidadAsignaturas(String cantidad) {
        String patron = "[1-9]|10";
        return cantidad.matches(patron);
    }


    public static boolean validarCantidadHoras(String horas) {
        String patron = "\\d{1,2}|20";
        return horas.matches(patron);
    }


    public static boolean validarFechaNacimiento(String fecha) {
        String patron = "\\d{4}-\\d{2}-\\d{2}";
        return fecha.matches(patron);
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getFacultad() {
        return Facultad;
    }

    public void setFacultad(String facultad) {
        Facultad = facultad;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public int getAsigDictadas() {
        return AsigDictadas;
    }

    public void setAsigDictadas(int asigDictadas) {
        AsigDictadas = asigDictadas;
    }

    public int getHrsDictadas() {
        return HrsDictadas;
    }

    public void setHrsDictadas(int hrsDictadas) {
        HrsDictadas = hrsDictadas;
    }

    public LocalDate getFchNacimiento() {
        return FchNacimiento;
    }

    public void setFchNacimiento(LocalDate fchNacimiento) {
        FchNacimiento = fchNacimiento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }


    public String getCc() {
        return Cc;
    }

    public void setCc(String cc) {
        Cc = cc;
    }


    @Override
    public int compareTo(Docente otroDocente) {
        return this.Nombre.compareTo(otroDocente.Nombre);
    }

}


