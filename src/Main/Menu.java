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
    public void menu() { //T(n)= + 3n^2 238n + 292
        LDocentes ld = new LDocentes();//---1
        int op = 0;//---1

        do {//(n + 1)
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "----------Menu Conjuntos Docentes----------\n"
                    + "1.Listar y contar por Docentes.\n"
                    + "2.Listar y contar docentes de tiempo completo y a la vez que sean de catedra.\n"
                    + "3.Listar y contar los profesores que son ocasionales y a la vez de catedra.\n"
                    + "4.Listar y contar profesores que tengan las 3 condiciones. (Catedra, completo y ocasional)\n"
                    + "5.Cantidad de hombre y mujeres por cada tipo de contrato.\n"
                    + "6.Listar y contar profesores por cada facultad.\n"
                    + "7.Ingresar Docente.\n"
                    + "8.Listar y contar profesores por cada Titulo.\n"
                    + "0.Salir.\n"));//---n
            switch (op) {//---n
                case 1://---n
                    menu2(ld);//T(n)= 90n +170
                    break;//---n
                case 2://---n
                    ld.InterseccionCompletoCatedra();//13n+27
                    break;//---n

                case 3://---n
                    ld.InterseccionOcCT();//13n+27
                    break;//---n

                case 4://---n
                    ld.InterseccionGlobal();//11n+24
                    break;//---n
                case 5://---n
                    ld.Contrato();//15n+7
                    break;//---n
                case 6://---n
                    ld.Facultad(ld.Union());//3n^2+12n+11
                    break;//---n

                case 7://---n
                    ld.Ingresar();//45n+8
                    break;//---n

                case 8://---n
                    ld.Titulo(ld.Union());//7n+11 + 6n+4
                    break;//---n
                    
                case 0://---n
                    JOptionPane.showMessageDialog(null, "Gracias por confiar en nosotros...\n");//---n
                    break;//---n

                default://---n
                    JOptionPane.showMessageDialog(null, "Digite correctamente la opcion\n");//---n
                    break;//---n
            }

        } while (op != 0);

    }

    private void menu2(LDocentes x) { //T(n)= 90n +170
        int op = 0;//---1

        do {//(n+1)
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "----------Menu Conjuntos Docentes----------\n"
                    + "1.Listar y contar por Docentes de tiempo completo solamente.\n"
                    + "2.Listar y contar los profesores que son de catedra solamente.\n"
                    + "3.Listar y contar los profesores que son ocasionales solamente.\n"
                    + "4.Listar y contar el total de profesores.\n"
                    + "0.Salir\n"));//---n
            switch (op) {//---n
                case 1://---n
                    x.conjuntoExclusivo(1);//T(n) = 30n+56
                    break;//---n
                case 2://---n
                    x.conjuntoExclusivo(2);//T(n) = 30n+56
                    break;//--n
                case 3://--n
                    x.conjuntoExclusivo(3);//T(n) = 30n+56
                    break;//--n
                case 4://--n
                    x.mostrar(4);//18n + 56
                    break;//--n
                case 0://--n
                    JOptionPane.showMessageDialog(null, "Regresando....\n");//--n
                    break;//--n
                default://--n
                    JOptionPane.showMessageDialog(null, "Digite correctamente la opcion\n");//--n
                    break;//--n
            }

        } while (op != 0);

    }
}
