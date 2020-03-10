package proyectohorario;

import libreriaproyecto.PedirDatos;
import empleado.Empleado;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author aalvarezbretana
 */
public class Metodos {
Scanner sc;
    PrintWriter esc = null;
    FileWriter arch;

    public Empleado crearEmpleado() {
        Empleado e = new Empleado(PedirDatos.pedirNombre("Nombre:(Max.10 caracteres)"),
                PedirDatos.pedirString("Primer apellido:"),
                PedirDatos.pedirString("Segundo apellido:"),
                PedirDatos.pedirHoras("Número de horas:"));
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

    public void crearHorario(String[][] horario, ArrayList<Empleado> plantilla,
            String[] dias, String[] horas, ArrayList<Integer> horasMax) {
        int aleatorio = (int) Math.floor(Math.random() * (plantilla.size()));
        int numero;
        int num_ale;
        int horasT = horasTotales(plantilla);
        horasMaximas(plantilla, horasMax);
        if (horasT >= 119) {
            for (int k = 0; k < dias.length; k++) {
                do {
                    num_ale = aleatorio;
                    aleatorio = (int) Math.floor(Math.random()
                            * (plantilla.size()));
                } while (num_ale == aleatorio || horasMax.get(aleatorio)
                        == plantilla.get(aleatorio).getNum_horas());
                numero = 0;
                for (int i = 0; i < horas.length; i++) {
                    if (numero == 8 || horasMax.get(aleatorio)
                            == plantilla.get(aleatorio).getNum_horas()) {
                        do {
                            num_ale = aleatorio;
                            aleatorio = (int) Math.floor(Math.random()
                                    * (plantilla.size()));
                            numero = 0;
                        } while (num_ale == aleatorio || horasMax.get(aleatorio)
                                == plantilla.get(aleatorio).getNum_horas());
                    }
                    horario[i][k] = plantilla.get(aleatorio).getNombre();
                    horasMax.set(aleatorio, horasMax.get(aleatorio) + 1);
                    numero++;
                }
            }
            System.out.println("Horario creado");
        } else {
            System.err.println("No se cumplen las horas mínimas "
                    + "para cubrir el horario total semanal(119 horas)");
        }
    }

    public void amosarHorario(String[][] horario, String[] horas, String[] dias) {
        if (horario[0][0] == null) {
            System.err.println("El horario no ha sido creado.");
        } else {
            System.out.print("Horas/Días   ");
            for (int i = 0; i < dias.length; i++) {
                switch (dias[i].length()) {
                    case 1:
                        System.out.print(dias[i] + "          ");
                        break;
                    case 2:
                        System.out.print(dias[i] + "         ");
                        break;
                    case 3:
                        System.out.print(dias[i] + "        ");
                        break;
                    case 4:
                        System.out.print(dias[i] + "       ");
                        break;
                    case 5:
                        System.out.print(dias[i] + "      ");
                        break;
                    case 6:
                        System.out.print(dias[i] + "     ");
                        break;
                    case 7:
                        System.out.print(dias[i] + "    ");
                        break;
                    case 8:
                        System.out.print(dias[i] + "  ");
                        break;
                    case 9:
                        System.out.print(dias[i] + "  ");
                        break;
                }
            }
            for (int f = 0; f < horario.length; f++) {
                System.out.print("\n " + horas[f] + "       ");
                for (int c = 0; c < horario[f].length; c++) {
                    switch (horario[f][c].length()) {
                        case 1:
                            System.out.print(horario[f][c] + "          ");
                            break;
                        case 2:
                            System.out.print(horario[f][c] + "         ");
                            break;
                        case 3:
                            System.out.print(horario[f][c] + "        ");
                            break;
                        case 4:
                            System.out.print(horario[f][c] + "       ");
                            break;
                        case 5:
                            System.out.print(horario[f][c] + "      ");
                            break;
                        case 6:
                            System.out.print(horario[f][c] + "     ");
                            break;
                        case 7:
                            System.out.print(horario[f][c] + "    ");
                            break;
                        case 8:
                            System.out.print(horario[f][c] + "   ");
                            break;
                        case 9:
                            System.out.print(horario[f][c] + "  ");
                            break;
                        case 10:
                            System.out.print(horario[f][c]);
                            break;
                    }
                }
            }
        }
    }

    public void horasMaximas(ArrayList<Empleado> plantilla, ArrayList<Integer> horasMax) {
        horasMax.removeAll(horasMax);
        for (int i = 0; i < plantilla.size(); i++) {
            horasMax.add(0);
        }
    }

    public void imprimir(String ruta, String[][] horario, String[] horas, String[] dias) {
        try {
            arch = new FileWriter(ruta);
            esc = new PrintWriter(arch);
            esc.print("Horas/Días   ");
            for (int i = 0; i < dias.length; i++) {
                switch (dias[i].length()) {
                    case 1:
                        esc.print(dias[i] + "          ");
                        break;
                    case 2:
                        esc.print(dias[i] + "         ");
                        break;
                    case 3:
                        esc.print(dias[i] + "        ");
                        break;
                    case 4:
                        esc.print(dias[i] + "       ");
                        break;
                    case 5:
                        esc.print(dias[i] + "      ");
                        break;
                    case 6:
                        esc.print(dias[i] + "     ");
                        break;
                    case 7:
                        esc.print(dias[i] + "    ");
                        break;
                    case 8:
                        esc.print(dias[i] + "  ");
                        break;
                    case 9:
                        esc.print(dias[i] + "  ");
                        break;
                }
            }
            for (int f = 0; f < horario.length; f++) {
                esc.print("\n " + horas[f] + "       ");
                for (int c = 0; c < horario[f].length; c++) {
                    switch (horario[f][c].length()) {
                        case 1:
                            esc.print(horario[f][c] + "          ");
                            break;
                        case 2:
                            esc.print(horario[f][c] + "         ");
                            break;
                        case 3:
                            esc.print(horario[f][c] + "        ");
                            break;
                        case 4:
                            esc.print(horario[f][c] + "       ");
                            break;
                        case 5:
                            esc.print(horario[f][c] + "      ");
                            break;
                        case 6:
                            esc.print(horario[f][c] + "     ");
                            break;
                        case 7:
                            esc.print(horario[f][c] + "    ");
                            break;
                        case 8:
                            esc.print(horario[f][c] + "   ");
                            break;
                        case 9:
                            esc.print(horario[f][c] + "  ");
                            break;
                        case 10:
                            esc.print(horario[f][c]);
                            break;
                    }
                }
            }
        } catch (IOException ex) {
            System.err.println("Error al escribir el archivo" + ex.getMessage());
        }catch (RuntimeException e){
            System.err.println("Error, el horario no ha sido creado previamente.");
        } finally {
            esc.close();
        }
    }

    public void borrarEmpleados(ArrayList<Empleado> plantilla) throws NullPointerException {
        if (plantilla.isEmpty()) {
            throw new NullPointerException("El ArrayList está vacío.");
        } else {
            sc = new Scanner(System.in);
            System.out.println("Qué empleado desea dar de baja?(Buscar por apellido)");
            String apellido = sc.nextLine();
            for (int i = 0; i < plantilla.size(); i++) {
                if (apellido.equalsIgnoreCase(plantilla.get(i).getApellido1())) {
                    System.out.println(plantilla.get(i).toString());

                }
            }
            System.out.println("Escriba el número de identificación que desea dar de baja.");
            int numero = sc.nextInt();
            for (int i = 0; i < plantilla.size(); i++) {
                if (numero == plantilla.get(i).getId()) {
                    plantilla.remove(i);
                }
            }

        }
    }
public void lerEmpleados(File fich,ArrayList<Empleado>plantilla) throws FileNotFoundException{
if (!fich.exists()) {
        throw new NullPointerException("El ArrayList está vacío.");
    } else {
    if (!plantilla.isEmpty()) {
    plantilla.removeAll(plantilla);
        System.out.println("ArrayList borrado");
    }
    sc = new Scanner(fich).useDelimiter(",\\s*"); //separa con comas
    while(sc.hasNextLine()){
    String nombre=sc.next();
    String apellido=sc.next();
    String apellido2=sc.next();
    int numHoras= Integer.parseInt(sc.next());
    sc.nextLine();
    Empleado empl = new Empleado(nombre,apellido,apellido2,numHoras);
    plantilla.add(empl);
        System.out.println("Empleado añadido al ArrayList");
    }  
    
    

    
}    
}    
}
