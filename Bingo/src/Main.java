import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Bingo!");

        List<ArrayList<String>> allLists = Utils.crearListas();
        Utils.cargarListas(allLists);
        Utils.imprimirListas(allLists);

    }
}