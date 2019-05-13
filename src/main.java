import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static void main (String[]args) {
        String toSplit = "";
        String[] parts = new String[3];
        ArrayList<Route> routes = new ArrayList<>();
        HashMap<String, Integer> cities = new HashMap<>();
        Integer current = 0;
        int[][] matrix;

        try {
            File file = new File("C:\\Users\\garoz\\Desktop\\2019\\Estructura de datos\\ultimaHDT\\src\\distancias.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null) {
                toSplit = st;
                parts = toSplit.split(",");
                routes.add(new Route(parts[0], parts[1], Integer.valueOf(parts[2])));
            }
        } catch (FileNotFoundException e) {
            System.out.print("No se encontró el archivo");
        } catch (IOException e) {
            System.out.println("Algo más salió maln favor intentar nuevamente");
        }

        for (Route r : routes) {
            if (!cities.containsKey(r.getSource())) {
                cities.put(r.getSource(), current);
                current++;
            }
            if (!cities.containsKey(r.getDestination())) {
                cities.put(r.getDestination(), current);
                current++;
            }
        }

        matrix = new int[cities.size()][cities.size()];
        for (Route r : routes) {
            matrix[cities.get(r.getSource())][cities.get(r.getDestination())] = r.getLength();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == null) {
                    matrix[i][j] = 0;
                }
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(matrix[i][j].toString());
            }
            System.out.println("\n");
        }

        FloydAlgorithm algorithm = new FloydAlgorithm(matrix.length);
        algorithm.floydwarshall(matrix);
    }
}
