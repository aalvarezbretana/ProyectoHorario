package proyectohorario;

import empleado.Empleado;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author aalvarezbretana
 */
public class ProyectoHorario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Metodos obx = new Metodos();
        ArrayList<Empleado> plantilla = new ArrayList();
        String[][] horario = new String[16][7];
        String[] horas = {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00",
            "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00",
            "22:00", "23:00", "24:00"};
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes",
            "Sábado", "Domingo"};
        ArrayList<Integer> horasMax = new ArrayList();
        int resposta;
        do {
            System.out.println("\nQué quieres hacer?"
                    + "\n 1.-Añadir empleado."
                    + "\n 2.-Añadir empleados por fichero"
                    + "\n 3.-Mostrar empleados."
                    + "\n 4.-Dar empleados de baja."
                    + "\n 5.-Crear horario."
                    + "\n 6.-Mostrar horario."
                    + "\n 7.-Imprimir horario."
                    + "\n 0.-Salir.");
            Scanner sc = new Scanner(System.in);
            resposta = sc.nextInt();
            switch (resposta) {
                case 1:
                    plantilla.add(obx.crearEmpleado());
                    break;
                case 2:
                    try {
                        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Aviso. "
                                + "Esto borrará todos los elementos del ArrayList"
                                + "\n1 - Aceptar\n2 - Rechazar"));
                        if (opcion == 1) {
                            File f = new File("empleados.txt");
                            obx.lerEmpleados(f, plantilla);
                        }
                    } catch (FileNotFoundException ex) {
                        System.out.println("Error. Archivo no encontrado");
                    } catch (NullPointerException ex) {
                        System.err.println("Error. El archivo no existe");
                    }
                    break;
                case 3:
                    try {
                        obx.mostrar(plantilla);
                    } catch (NullPointerException ex) {
                        System.err.println("Error. " + ex.getMessage());
                    }
                    break;
                case 4:
                    try {
                        obx.borrarEmpleados(plantilla);
                    } catch (NullPointerException ex) {
                        System.err.println("Error. " + ex.getMessage());
                    }
                    break;
                case 5:
                    obx.crearHorario(horario, plantilla, dias, horas, horasMax);
                    break;

                case 6:
                    obx.amosarHorario(horario, horas, dias);
                    break;

                case 7:
                    obx.imprimir("horario.txt", horario, horas, dias);
                    break;
            }
        } while (resposta != 0);
    }
}
