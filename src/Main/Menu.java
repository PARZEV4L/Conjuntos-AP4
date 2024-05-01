/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Utilidades.LDocentes;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Menu {

    @SuppressWarnings("static-access")
    public void menu() {
        LDocentes ld = new LDocentes();
        int op = 0;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "----------Menu Conjuntos Docentes----------\n"
                    + "1.Listar y contar por Docentes.\n"
                    + "2.Listar y contar docentes de tiempo completo y a la vez que sean de catedra.\n"
                    + "3.Listar y contar los profesores que son ocasionales y a la vez de catedra.\n"
                    + "4.Listar y contar profesores que tengan las 3 condiciones. (Catedra, completo y ocasional)\n"
                    + "5.Cantidad de hombre y mujeres por cada tipo de contrato.\n"
                    + "6.Listar y contar profesores por cada facultad.\n"
                    + "7.Ingresar Docente.\n"
                    + "8 .Adicionar otra funcion.\n"
                    + "0.Salir.\n"));
            switch (op) {
                case 1:
                    menu2(ld);
                    break;
                case 2:
                    ld.InterseccionCompletoCatedra();
                    break;

                case 3:
                    ld.InterseccionOcCT();
                    break;

                case 4:
                    ld.InterseccionGlobal();
                    break;
                case 5:
                    ld.Contrato();
                    break;
                case 6:
                    ld.Facultad(ld.Union());
                    break;

                case 7:
                    ld.Ingresar();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias por confiar en nosotros...\n");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Digite correctamente la opcion\n");
                    break;
            }

        } while (op != 0);

    }

    private void menu2(LDocentes x) {
        int op = 0;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "----------Menu Conjuntos Docentes----------\n"
                    + "1.Listar y contar por Docentes de tiempo completo solamente.\n"
                    + "2.Listar y contar los profesores que son de catedra solamente.\n"
                    + "3.Listar y contar los profesores que son ocasionales solamente.\n"
                    + "4.Listar y contar el total de profesores.\n"
                    + "0.Salir\n"));
            switch (op) {
                case 1:
                    x.conjuntoExclusivo(1);
                    break;
                case 2:
                    x.conjuntoExclusivo(2);
                    break;
                case 3:
                    x.conjuntoExclusivo(3);
                    break;
                case 4:
                    x.mostrar(4);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Regresando....\n");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Digite correctamente la opcion\n");
                    break;
            }

        } while (op != 0);

    }
}
