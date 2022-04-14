package Persona;

public class Persona {

    /**
     * Sexo por defecto
     */
    private final static char SEXO_DEF = 'H';
 
    /**
     * El peso de la persona esta por debajo del peso ideal
     */
    public static final int INFRAPESO = -1;
 
    /**
     * El peso de la persona esta en su peso ideal
     */
    public static final int PESO_IDEAL = 0;
 
    /**
     * El peso de la persona esta por encima del peso ideal
     */
    public static final int SOBREPESO = 1;
 
    //Atributos

    private String nombre;
    private int edad;
    private int NSS;
	private char letraNSS;
    private char sexo;
    private double peso;
    private double altura;
  
    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.NSS	= generaNSS();
		letraNSS	= generaletraNSS();
        this.sexo = sexo;
        comprobarSexo();
    }

    private void comprobarSexo() {
        if (sexo != 'H' && sexo != 'M') {
            this.sexo = SEXO_DEF;
        }
    }
 
	private int generaNSS(){
		return (int)(Math.random()*100000000);
	}
	
	private char generaletraNSS(){
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		return letras.charAt(this.NSS%23);
	}
 
    //Métodos publicos

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
 
    /**
     * Índice de masa corporal
     *
     * -1: la persona esta por debajo de su peso ideal
     * 0: la persona esta en su peso ideal
     * 1: la persona esta por encima de su peso ideal
     */
    public int calcularIMC() {
        //Calculamos el peso de la persona
        double pesoActual = peso / (Math.pow(altura, 2));
        //Segun el peso, devuelve un codigo
        if (pesoActual >= 20 && pesoActual <= 25) {
            return PESO_IDEAL;
        } else if (pesoActual < 20) {
            return INFRAPESO;
        } else {
            return SOBREPESO;
        }
    }

    public boolean esMayorDeEdad() {
        boolean mayor = false;
        if (edad >= 18) {
            mayor = true;
        }
        return mayor;
    }

    public String toString() {
        String sexo;
        if (this.sexo == 'H') {
            sexo = "hombre";
        } else {
            sexo = "mujer";
        }
        return "Informacion de la persona:\n"
                + "Nombre: " + nombre + "\n"
                + "Sexo: " + sexo + "\n"
                + "Edad: " + edad + " años\n"
                + "NSS : " + this.NSS + this.letraNSS + "\n"
                + "Peso: " + peso + " kg\n"
                + "Altura: " + altura + " metros\n";
    }
 
}

