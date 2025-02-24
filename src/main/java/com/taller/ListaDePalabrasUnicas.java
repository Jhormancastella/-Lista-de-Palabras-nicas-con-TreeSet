package com.taller;

import java.util.*;

public class ListaDePalabrasUnicas {
    public static void main(String[] args) {
        // Crear un TreeSet para almacenar las palabras

        TreeSet<String> palabras = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("🌟 BIENVENIDO A TU LISTA DE PALABRAS ÚNICAS 🌟");

        //Pedir al usuario que ingrese varias palabras

        System.out.println("Por favor, ingresa varias palabras (escribe 'fin' para terminar):");
        while (true) {
            System.out.print("Ingresa una palabra: ");
            String palabra = scanner.nextLine();

            // Si el usuario escribe "fin", salimos del bucle
           
            if (palabra.equalsIgnoreCase("fin")) {
                break;
            }

            // Validamos que la palabra no contenga números
           
            if (contieneNumeros(palabra)) {
                System.out.println("❌ Error: No se permiten números en las palabras. Intenta nuevamente.");
                continue; // Volvemos al inicio del bucle
            }

             // Agregamos la palabra al TreeSet
           
             palabras.add(palabra);
        }

        // Mostrar las palabras ordenadas alfabéticamente
       
        System.out.println("\n📝 Palabras ordenadas alfabéticamente:");
        for (String palabra : palabras) {
            System.out.println("- " + palabra);
        }

        // Permitir que el usuario busque palabras en la lista
       
        boolean continuarBusqueda = true;
        while (continuarBusqueda) {
            System.out.println("\n¿Deseas buscar una palabra en la lista? (si/no)");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("si")) {
                System.out.print("Ingresa la palabra que deseas buscar: ");
                String palabraBuscar = scanner.nextLine();

                // Buscamos la palabra en el TreeSet
                if (palabras.contains(palabraBuscar)) {
                    System.out.println("✅ La palabra '" + palabraBuscar + "' está en la lista.");
                } else {
                    System.out.println("❌ La palabra '" + palabraBuscar + "' NO está en la lista.");
                }
            } else if (respuesta.equalsIgnoreCase("no")) {
                continuarBusqueda = false; // Terminamos la búsqueda
            } else {
                System.out.println("❌ Respuesta no válida. Por favor, responde 'si' o 'no'.");
            }
        }

        System.out.println("\n🚀 ¡Gracias por usar tu lista de palabras únicas!");
        scanner.close();
    }

    // Método auxiliar para verificar si una cadena contiene números
    
    private static boolean contieneNumeros(String texto) {
        for (char c : texto.toCharArray()) {
            if (Character.isDigit(c)) {
                return true; // Si encuentra un número, retorna true
            }
        }
        return false; // Si no encuentra números, retorna false
    }
}
