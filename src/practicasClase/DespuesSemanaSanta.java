package practicasClase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DespuesSemanaSanta {
    public static void main(String[] args) {
        //lista de Staffs meter 10 elem
        List<Staff> listaStaff = new ArrayList<Staff>();

        for (int i=0; i<10; i++) {
            listaStaff.add(new Staff("Pedro"));
        }

        System.out.println(listaStaff.size());

        Set<Staff> setStaff = new HashSet<Staff >();

        for (int i=0; i<10; i++) {
            setStaff.add(new Staff("Pedro"));
        }
        System.out.println(setStaff.size());
    }

}
// crear clase con los atributos
// un contador de objetos de la clase
// una cadena de caracteres nombre
// clase nombre: staff

class Staff {
    String cadena = null;
    private static int contador = 0;

    // constructor

    public Staff(String cadena) {
        this.cadena = cadena;
        contador++;
    }

    // getters y setters

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Staff.contador = contador;
    }

}