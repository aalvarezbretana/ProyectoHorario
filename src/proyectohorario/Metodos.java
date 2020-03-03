/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohorario;

import libreriaproyecto.PedirDatos;
import empleado.Empleado;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author aalvarezbretana
 */
public class Metodos {

    public Empleado crearEmpleado() {
        Empleado e = new Empleado(PedirDatos.pedirString("Nombre:"), PedirDatos.pedirString("Primer apellido:"), PedirDatos.pedirString("Segundo apellido:"), PedirDatos.pedirInt("Numero horas:"));
        return e;
    }

    public void mostrar(ArrayList<Empleado> plantilla) {
        if (plantilla.isEmpty()) {
            throw new NullPointerException("El ArrayList está vacío");
        } else {
            Collections.sort(plantilla);
            Iterator it = plantilla.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }
    }
  
    public String[][] crearHorario(String[][] horario, ArrayList<Empleado> plantilla) {
        for (int i = 0; i < horario.length; i++) {
            for (int j = 0; j < horario[i].length; j++) {
                horario[i][j] = plantilla.get(0).getNombre();
            }
        }
        return horario;
    }
      public void amosarHorario(String[][] horario, String[] horas, String[] dias) {
        System.out.print("Horas/Días");
        for (int i = 0; i < dias.length; i++) {
            System.out.print("   " + dias[i]);
        }
        for (int f = 0; f < horario.length; f++) {
            System.out.print("\n " + horas[f]);
            for (int c = 0; c < horario[f].length; c++) {
                System.out.print("       " + horario[f][c] + "  ");
            }
        }
    }

}
