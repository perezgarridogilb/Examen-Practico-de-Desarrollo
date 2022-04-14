package Persona;

import java.util.Locale;
import java.util.Scanner;
 
public class PersonaApp_Scanner {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        sc.useLocale(Locale.US);

        System.out.println("Introduce el nombre");
        String nombre = sc.next();
 
        System.out.println("Introduce la edad");
        int edad = sc.nextInt();
 
        System.out.println("Introduce el sexo");
        char sexo = sc.next().charAt(0);
 
        System.out.println("Introduce el peso");
        double peso = sc.nextDouble();
 
        System.out.println("Introduce la altura");
        double altura = sc.nextDouble();

        Persona personaQ = new Persona(nombre, edad, sexo, peso, altura);

        System.out.println("\nPersona\n");
        MuestraMensajePeso(personaQ);
        MuestraMayorDeEdad(personaQ);
        System.out.println(personaQ.toString());
    }
 
    public static void MuestraMensajePeso(Persona p) {
        int IMC = p.calcularIMC();
        switch (IMC) {
            case Persona.PESO_IDEAL:
                System.out.println("La persona esta en su peso ideal");
                break;
            case Persona.INFRAPESO:
                System.out.println("La persona esta por debajo de su peso ideal");
                break;
            case Persona.SOBREPESO:
                System.out.println("La persona esta por encima de su peso ideal");
                break;
        }
    }
 
    public static void MuestraMayorDeEdad(Persona p) {
 
        if (p.esMayorDeEdad()) {
            System.out.println("La persona es mayor de edad");
        } else {
            System.out.println("La persona no es mayor de edad");
        }
    }
 
}