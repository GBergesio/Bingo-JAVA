import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static List<Integer> creados = new ArrayList<>();
    private static boolean cero, uno, dos, tres, cuatro, cinco, seis, siete, ocho;

    public static Integer randomNumber(int min, int max) {
        int number;
        do {
            number = (int) (Math.random() * (max - min) + min);
        } while (creados.contains(number));
        creados.add(number);
        return number;
    }

    public static boolean finalizado(ArrayList<String> list) {
        int aux = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals("X")) {
                aux++;
            }
        }
        return aux >= 5;
    }

    public static boolean ocupado(Integer numero) {
        if (numero > 0 && numero < 10 && !cero) {
            cero = true;
            return true;
        }
        if (numero >= 10 && numero < 20 && !uno) {
            uno = true;
            return true;
        }
        if (numero >= 20 && numero < 30 && !dos) {
            dos = true;
            return true;
        }
        if (numero >= 30 && numero < 40 && !tres) {
            tres = true;
            return true;
        }
        if (numero >= 40 && numero < 50 && !cuatro) {
            cuatro = true;
            return true;
        }
        if (numero >= 50 && numero < 60 && !cinco) {
            cinco = true;
            return true;
        }
        if (numero >= 60 && numero < 70 && !seis) {
            seis = true;
            return true;
        }
        if (numero >= 70 && numero < 80 && !siete) {
            siete = true;
            return true;
        }
        if (numero >= 80 && numero <= 90 && !ocho) {
            ocho = true;
            return true;
        }
        return false;
    }

    public static List<ArrayList<String>> crearListas() {
        ArrayList<String> lista1 = new ArrayList<>(List.of("X", "X", "X", "X", "X", "X", "X", "X", "X"));
        ArrayList<String> lista2 = new ArrayList<>(List.of("X", "X", "X", "X", "X", "X", "X", "X", "X"));
        ArrayList<String> lista3 = new ArrayList<>(List.of("X", "X", "X", "X", "X", "X", "X", "X", "X"));

        return new ArrayList<>(List.of(lista1, lista2, lista3));
    }

    public static void cargarListas(List<ArrayList<String>> lists) {
        lists.forEach(lista -> {
            do {
                Integer random = Utils.randomNumber(1, 91);
                if (!lista.contains(random.toString()) && !Utils.ocupado(random)) {
                    if (random > 0 && random < 10)
                        lista.set(0, random.toString());
                    else if (random >= 10 && random < 20)
                        lista.set(1, random.toString());
                    else if (random >= 20 && random < 30)
                        lista.set(2, random.toString());
                    else if (random >= 30 && random < 40)
                        lista.set(3, random.toString());
                    else if (random >= 40 && random < 50)
                        lista.set(4, random.toString());
                    else if (random >= 50 && random < 60)
                        lista.set(5, random.toString());
                    else if (random >= 60 && random < 70)
                        lista.set(6, random.toString());
                    else if (random >= 70 && random < 80)
                        lista.set(7, random.toString());
                    else if (random >= 80 && random <= 90)
                        lista.set(8, random.toString());
                }
            } while (!Utils.finalizado(lista));
        });
    }

    public static void imprimirListas(List<ArrayList<String>> allLists) {
        allLists.forEach(lista -> {
            lista.forEach(c -> {
                System.out.print(c + " | ");
            });
            System.out.println("");
        });
    }
}