import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main (String[]args){
        String[] parts = new String[3];
        ArrayList<Route> routes = new ArrayList<>();
        ArrayList<String> cities = new ArrayList<>();

        try{
            File file =
                    new File("C:\\Users\\garoz\\Desktop\\2019\\Estructura de datos\\ultimaHDT\\src\\distancias.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
                parts = sc.nextLine().split(",");
                Route newRoute = new Route(parts[0], parts[1], Integer.valueOf(parts[2]));
                routes.add(newRoute);
                System.out.println("We added one");
        }catch (FileNotFoundException e){
            System.out.print("No se encontró el archivo");
        }
        for (Route currentRoute:routes){
            System.out.print(currentRoute.getSource());
        }
        FloydAlgorithm myAlgorithm = new FloydAlgorithm(3);
    }
}
