/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleado;

/**
 *
 * @author aalvarezbretana
 */
public class Empleado implements Comparable {

    String nombre;
    String apellido1;
    String apellido2;
    int num_horas;
    private int n_id;
    public static int id = 1;

    public Empleado() {
        n_id = id;
        id++;
    }

    public Empleado(String nombre, String apellido1, String apellido2, int num_horas) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.num_horas = num_horas;
        n_id = id;
        id++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getNum_horas() {
        return num_horas;
    }

    public void setNum_horas(int num_horas) {
        this.num_horas = num_horas;
    }

    public int getId() {
        return n_id;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", primer apellido: " + apellido1 
                + ", segundo apellido: " + apellido2 
                + ", horas: " + num_horas + ", número de identificación: "
                + n_id +'.';
    }

    @Override
    public int compareTo(Object o) {
        Empleado plantilla = (Empleado) o;
        if (this.apellido1.compareToIgnoreCase(plantilla.apellido1) == 0) {
            if (this.apellido2.compareToIgnoreCase(plantilla.apellido2) == 0) {
                if (this.nombre.compareToIgnoreCase(plantilla.nombre) == 0) {
                    return 0;
                } else if (this.nombre.compareToIgnoreCase(plantilla.nombre) > 0) {
                    return 1;
                } else {
                    return -1;
                }

            } else if (this.apellido2.compareToIgnoreCase(plantilla.apellido2) > 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (this.apellido1.compareToIgnoreCase(plantilla.apellido1) > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
