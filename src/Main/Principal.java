package Main;

import java.time.LocalDate;
import Utilidades.FechaIngreso;
import Utilidades.LDocentes;

public class Principal {


    public static void main(String[] args) {
      //  LocalDate x = FechaIngreso.fecha();
            LDocentes ld = new LDocentes();
  
            ld.CargarDatos();
            ld.mostrar(1);
           // ld.conjuntoExclusivo(1);
            ld.InterseccionCompletoCatedra();
    }
    
}
