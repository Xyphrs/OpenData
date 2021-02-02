package com.company;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final String path = "https://opendata.arcgis.com/datasets/ace07e97d10a4ab28b336dd67e42c5c6_0.csv";


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
            System.out.println("1. Mostrar la informacion de todos los campos en los cuales la id no sea menor a 7(Filter)");
            System.out.println("2. Mostrar el nombre de las zonas (Map)");
            System.out.println("3. ID mas baja (Min)");
            System.out.println("4. ID mas alta (Max)");
            System.out.println("5. Ordenar por id, de mayor a menor (Sort)");
            System.out.println("6. Cuantas zonas hay en el fichero csv (Count)");
            System.out.println("7. Mostrar el nombre de las zonas sin repeticiones (Distinct)");
            System.out.println("8. Ver CSV");
            System.out.println("9. Salir");
            seleccion = scanner.nextInt();
            switch (seleccion) {
                case 1 -> statList.stream().filter(p -> p.getObjectid() > 7f).forEach(System.out::println);
                case 2 -> statList.stream().map(Estadisticas::getZona).forEach(System.out::println);
                case 3 -> System.out.println(statList.stream().min(Estadisticas::compareTo));
                case 4 -> System.out.println(statList.stream().max(Estadisticas::compareTo));
                case 5 -> {
                    statList.sort(Estadisticas::compareTo);
                    System.out.println(statList);
                }
                case 6 -> System.out.println(statList.stream().map(Estadisticas::getZona).count());
                case 7 -> statList.stream().map(Estadisticas::getZona).distinct().forEach(System.out::println);
                case 8 -> statList.forEach(System.out::println);
                case 9 -> System.out.println("Adios...");
                default -> System.out.println("Introduce un numero entre 1-8");
            }
        } while (seleccion != 9);
    }

    private static void readCSV(List<Estadisticas> statList) throws IOException {
        URL url = new URL(path);

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        br.readLine();
        String line;
        line = br.readLine();
        try {
            while (line != null) {
                String[] data = line.split(",");
                for (int i = 0; i < 1; i++) {
                    statList.add(new Estadisticas(Integer.parseInt(data[0]), data[1], Float.parseFloat(data[2]), Float.parseFloat(data[3]), Float.parseFloat(data[4])));
                }
                line = br.readLine();
                System.out.println("------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


