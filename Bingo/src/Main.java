import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Bingox!");
//        List<ArrayList<String>> allLists = Utils.crearListas();
//        Utils.cargarListas(allLists);
//        Utils.imprimirListas(allLists);

        String bingo = "  ____ _____ _   _  _____  ____  \n" +
                " |  _ \\_   _| \\ | |/ ____|/ __ \\ \n" +
                " | |_) || | |  \\| | |  __| |  | |\n" +
                " |  _ < | | | . ` | | |_ | |  | |\n" +
                " | |_) || |_| |\\  | |__| | |__| |\n" +
                " |____/_____|_| \\_|\\_____|\\____/ \n" +
                "                                ";
        String gracias = "Muchas gracias! Vuelva pronto";
        boolean jugar;
        Scanner lector = new Scanner(System.in);
        System.out.println(bingo);
        System.out.println("Desea comprar un carton de bingo? true/false");

        jugar = lector.nextBoolean();
        if(jugar){
        do {
                List<ArrayList<String>> allLists = Utils.crearListas();
                Utils.cargarListas(allLists);
                Utils.imprimirListas(allLists);
                System.out.println("Desea volver a jugar?");
                jugar = lector.nextBoolean();
        } while(jugar);
            System.out.println(gracias);
        }
        else {
            System.out.println(gracias);
        }

    }
}