package ejercicio4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) throws IOException {
        // pedir por pantalla tantas personas como se quiera
        // al final de cada persona preguntar si se quiere introducir otra [s/n]
        // guardar las Personas introducidas en una lista de tipo List
        List<Persona> personas = new ArrayList<Persona>();

        Scanner teclado = new Scanner(System.in);
        Persona persona = null;
        char continuar = 'S';

        System.out.print("Quieres introducir una persona? [S/N]: ");
        continuar = teclado.nextLine().toUpperCase().charAt(0);

        while (continuar == 'S') {
            persona = new Persona();
            System.out.println("Introduce DNI: ");
            persona.setDni(teclado.nextLine());
            System.out.println("Introduce Nombre: ");
            persona.setNombre(teclado.nextLine());
            System.out.println("Introduce Apellidos: ");
            persona.setApellidos(teclado.nextLine());
            System.out.println("Introduce Edad: ");
            persona.setEdad(teclado.nextInt());
            // hay que limpiar el buffer de teclado
            teclado.nextLine();

            personas.add(persona);

            System.out.println("Hasta ahora has introducido " + personas.size() + " personas.");

            System.out.print("Quieres introducir otra persona? [S/N]: ");
            continuar = teclado.nextLine().toUpperCase().charAt(0);
        }

        teclado.close();

        // for each...
        for (Persona personaActual : personas) {
            System.out.println(personaActual.toString());
        }

        // meter las personas en un file

        ObjectOutputStream escritor = null;
        String pathFichero = "src//ejercicio4//persona.dat";

        try {
            escritor = new ObjectOutputStream(new FileOutputStream(pathFichero));

            for (Persona personaActual : personas) {
                escritor.writeObject(personaActual);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (escritor != null)
                escritor.close();
        }
        
    }

}
