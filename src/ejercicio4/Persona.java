package ejercicio4;

public class Persona {
     // esta clase la tendras que haber definido antes
    // minimo 4 atributos y un constructor para inicializar el objeto
    // Atributos:
    // dni, nombre, apellidos, edad
    // private
    // constructor
    // getter y setter
    // atributos

    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;

    // constructores

    public Persona(String dni, String nombre, String apellidos, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Persona(){
        dni=null;
        nombre=null;
        apellidos=null;
        edad=-1;
    }

    // getters y setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona [dni = " + dni + ", nombre = " + nombre + ", apellidos = " + apellidos + ", edad = " + edad + "]";
    }

    
}

