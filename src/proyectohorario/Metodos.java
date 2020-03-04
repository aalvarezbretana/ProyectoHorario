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

    public void mostrar(ArrayList<Empleado> plantilla) throws NullPointerException {
        if (plantilla.isEmpty()) {
            throw new NullPointerException("El ArrayList está vacío.");
        } else {
            Collections.sort(plantilla);
            Iterator it = plantilla.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }
    }

    public int horasTotales(ArrayList<Empleado> plantilla) {
        int acumulador = 0;
        for (int i = 0; i < plantilla.size(); i++) {
            acumulador = acumulador + plantilla.get(i).getNum_horas();
        }
        return acumulador;
    }

    public void crearHorario(String[][] horario, ArrayList<Empleado> plantilla, String[] dias, String[] horas) {
        int aleatorio = (int) Math.floor(Math.random() * (plantilla.size()));
        int numero = 0;
        int num_ale;
        int horasT = horasTotales(plantilla);
        if (horasT >= 119) {
            for (int k = 0; k < dias.length; k++) {
                do {
                    num_ale = aleatorio;
                    aleatorio = (int) Math.floor(Math.random() * (plantilla.size()));
                    numero = 0;
                } while (num_ale == aleatorio);
                numero = 0;
                for (int i = 0; i < horas.length; i++) {
                    if (numero == 8) {
                        do {
                            num_ale = aleatorio;
                            aleatorio = (int) Math.floor(Math.random() * (plantilla.size()));
                            numero = 0;
                        } while (num_ale == aleatorio);
                    }
                    horario[i][k] = plantilla.get(aleatorio).getNombre();
                    numero++;
                }
            }
            amosarHorario(horario, horas, dias);

        } else {
            System.out.println("No se cumplen las minimas horas para cubrir el horario total semanal");
        }
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
