# Examen Práctico de Desarrollo 
## Examen Base – Desarrollar en Java (Consola)

<img width="1392" alt="Captura de Pantalla 2022-04-13 a la(s) 11 33 17 p m" src="https://user-images.githubusercontent.com/56992179/163314267-526b6be8-4fda-4a06-8463-b999b263b9d0.png">

1. Has una clase llamada **Persona** que siga las siguientes condiciones:
- Sus atributos son: **nombre, edad, NSS (Numero de Seguro Social), sexo** (H hombre, M mujer), **peso y altura**. No
queremos que se accedan directamente a ellos. Piensa que modificador de acceso es el más adecuado, también su tipo.
Si quieres añadir algún atributo puedes hacerlo.
- Por defecto, todos los atributos menos el NSS serán valores por defecto según su tipo (0 números, cadena vacía para
String, etc.). Sexo será hombre por defecto, usa una constante para ello.
- Se implementará:
 - Un constructor con todos los atributos como parámetro. 
- Los métodos que se implementaran son:
 - **calcularIMC()**: calculara si la persona está en su peso ideal (peso en kg/(Estatura^2 en m)), devuelve un -1 si está por debajo de su peso ideal, un 0 si está en su peso ideal y un 1 si tiene sobrepeso. Te recomiendo que uses constantes para devolver estos valores.

>#

 - **esMayorDeEdad()**: indica si es mayor de edad, devuelve un booleano.
 - **comprobarSexo(char sexo)**: comprueba que el sexo introducido es correcto. Devolver el valor en booleano. No
 será visible al exterior.
 - **toString()**: devuelve toda la información del objeto.
 - **generaNSS()**: genera una expresión de 8 caracteres con números y letras al azar. Este método será invocado
cuando se construya el objeto. Puedes dividir el método en partes para que te sea más fácil.No será visible al exterior. o Métodos set de cada parámetro, excepto de NSS.
Ahora, crea una pantalla que haga lo siguiente:
- Pide por formulario el nombre, la edad, sexo, peso y altura.
- Deberá comprobar si está en su peso ideal, tiene sobrepeso o por debajo de su peso ideal con un mensaje.
- Indicar si es mayor de edad.
- Por último, mostrar toda la información ingresada. 

Puedes usar métodos, para que te sea más fácil.
