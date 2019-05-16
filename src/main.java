import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static Integer[] findCenter(Integer[][] matrix){
        Integer currentCenter = 1000;
        Integer[] currentCoordinates = new Integer[2];

        for (int i = 0; i < matrix.length; i++){
            Integer currentBiggest = 0;
            Integer[] cBCoordinates = new Integer[2];
            for (int j = 0; j <matrix.length; j++){
                if (matrix[j][i] > currentBiggest){
                    currentBiggest = matrix[j][i];
                    cBCoordinates[0] = j;
                    cBCoordinates[1] = i;
                }
            }
            if (currentBiggest < currentCenter){
                currentCenter = currentBiggest;
                currentCoordinates = cBCoordinates;
            }
        }
        return currentCoordinates;
    }
    public static void main (String[]args) {
        String toSplit = "";
        String[] parts = new String[3];
        ArrayList<Route> routes = new ArrayList<>();
        HashMap<String, Integer> cities = new HashMap<>();
        Integer current = 0;
        Integer[][] matrix;

        try {
            File file = new File("C:\\Users\\garoz\\Desktop\\2019\\Estructura de datos\\ultimaHDT\\src\\guategrafo.txt");

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

        matrix = new Integer[cities.size()][cities.size()];

        for (Route r : routes) {
            matrix[cities.get(r.getSource())][cities.get(r.getDestination())] = r.getLength();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == null && i != j) {
                    matrix[i][j] = 99999;
                }
                else if (matrix[i][j] == null && i == j){
                    matrix[i][j] = 0;
                }
            }
        }


        Floyd2 floyd = new Floyd2(matrix.length);
        Integer [][] result = floyd.floydWarshall(matrix);
        floyd.printSolution(matrix);
        //floyd.printSolution(result);

        System.out.println("Favor ingrese su ciudad de salida");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        String origin = myObj.nextLine();

        System.out.println("Favor ingrese su ciudad de destino");

        String destiny = myObj.nextLine();
        try{
            System.out.println(result[cities.get(origin)][cities.get(destiny)]);
        }catch (NullPointerException e){
            System.out.println("Las ciudades ingresadas no existen, favor intentar nuevamente");
        }
        System.out.println("El centro de su grafo es " + findCenter(matrix)[1]);
    }
}
