package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Estadisticas> statList = new ArrayList<>();
        readCSV(statList);
        int seleccion = 0;
        System.out.println("");
        System.out.println("Bienvenido a OpenData");
        do {
            System.out.println("");
            System.out.println("Selecciona una opcion del menu para consultar datos");
            System.out.println("1. Partidos en el que el equipo Local ha marcado mas de 1 (Filter)");
            System.out.println("2. Mostrar el nombre de los Equipos Locales (Map)");
            System.out.println("3. Equipo local con el menor de derrotas (Min)");
            System.out.println("4. Equipo local con el maximo de derrotas (Max)");
            System.out.println("5. Ordenar por las partidas perdidas de los equipos (Sort)");
            System.out.println("6. Cuantos partidos han jugado los Equipos locales (Count)");
            System.out.println("7. Mostrar el nombre de los Equipos Locales sin repeticiones (Distinct)");
            System.out.println("8. Ver CSV");
            System.out.println("9. Salir");
            seleccion = scanner.nextInt();
            switch (seleccion) {
                case 1 -> statList.stream().filter(p -> p.getGoals_home() > 1).forEach(System.out::println);
                case 2 -> statList.stream().map(Estadisticas::getHometeam).forEach(System.out::println);
                case 3 -> System.out.println(statList.stream().min(Estadisticas::compareTo));
                case 4 -> System.out.println(statList.stream().max(Estadisticas::compareTo));
                case 5 -> {
                    statList.sort(Estadisticas::compareTo);
                    System.out.println(statList);
                }
                case 6 -> System.out.println(statList.stream().map(Estadisticas::getHometeam).count());
                case 7 -> statList.stream().map(Estadisticas::getHometeam).distinct().forEach(System.out::println);
                case 8 -> statList.forEach(System.out::println);
                case 9 -> System.out.println("Adios...");
                default -> System.out.println("Introduce un numero entre 1-8");
            }
        } while (seleccion != 9);
    }

    private static void readCSV(List<Estadisticas> statList) throws IOException {
        File file = new File("estadistiques.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine();
        String line;
        line = br.readLine();
        try {
            while (line != null) {
                String[] data = line.split(",");
                for (int i = 0; i < 1; i++) {
                    statList.add(new Estadisticas(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]), Integer.parseInt(data[8])));
                }
                line = br.readLine();
                System.out.println("------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


