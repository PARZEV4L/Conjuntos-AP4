package Docentes;
import java.time.LocalDate;
import java.util.Objects;

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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Docente docente = (Docente) obj;
        return Objects.equals(Cc, docente.Cc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Cc);
    }

    @Override
    public int compareTo(Docente otroDocente) {
        return this.Nombre.compareTo(otroDocente.Nombre);
    }

}


