/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohorario;

import empleado.Empleado;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aalvarezbretana
 */
public class ProyectoHorario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Metodos obx = new Metodos();
        ArrayList<Empleado> plantilla = new ArrayList();
        String[][] horario = new String[17][7];
        String[] horas = {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00",
            "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", 
            "22:00", "23:00", "24:00", "01:00"};
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", 
            "Sábado", "Domingo"};
        ArrayList<Integer> horasMax = new ArrayList();
        int resposta;
        do {
            System.out.println("\nQué quieres hacer?"
                    + "\n 1.-Añadir empleado."
                    + "\n 2.-Mostrar empleados."
                    + "\n 3.-Crear horario."
                    + "\n 4.-Mostrar horario."
                    + "\n 5.-Imprimir horario."
                    + "\n 0.-Salir.");
            Scanner sc = new Scanner(System.in);
            resposta = sc.nextInt();
            switch (resposta) {
                case 1:
                    plantilla.add(obx.crearEmpleado());
                    break;
                case 2:
                    try {
                        obx.mostrar(plantilla);
                    } catch (NullPointerException ex) {
                        System.err.println("Error. " + ex.getMessage());
                    }
                    break;
                case 3:
                    obx.crearHorario(horario, plantilla, dias, horas, horasMax);
                    break;
                case 4:
                    obx.amosarHorario(horario, horas, dias);
                    break;
                case 5:
                    obx.imprimir("horario.txt", horario, horas, dias);
                    break;
            }
        } while (resposta != 0);
    }
}
