import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static List<Integer> creados = new ArrayList<>();

    //Declaramos un booleano y lo inicializamos en false para las posiciones de cada columna.
    private static boolean cero, uno, dos, tres, cuatro, cinco, seis, siete, ocho;

    //De esta forma generamos un numero aleatorio entre dos valores establecidos (un minimo y un maximo).
    public static Integer randomNumber(int min, int max) {
        int number;
        do {
            number = (int) (Math.random() * (max - min) + min);
        } while (creados.contains(number));
        creados.add(number);
        return number;
    }

    //Definimos que cada fila va a tener como maximo 5 lugares ocupados / finaliza la lista cuando ya hay 5 o mas lugares sin "  "
    public static boolean finalizado(ArrayList<String> list) {
        int aux = 0;

        for(int i = 0; i < list.size(); ++i) {
            if (!((String)list.get(i)).equals("  ")) {
                ++aux;
            }
        }

        return aux >= 5;
    }

    public static boolean ocupado(Integer numero) {
        if (numero > 0 && numero < 10 && !cero) {
            cero = true;
            return true;
        } else if (numero >= 10 && numero < 20 && !uno) {
            uno = true;
            return true;
        } else if (numero >= 20 && numero < 30 && !dos) {
            dos = true;
            return true;
        } else if (numero >= 30 && numero < 40 && !tres) {
            tres = true;
            return true;
        } else if (numero >= 40 && numero < 50 && !cuatro) {
            cuatro = true;
            return true;
        } else if (numero >= 50 && numero < 60 && !cinco) {
            cinco = true;
            return true;
        } else if (numero >= 60 && numero < 70 && !seis) {
            seis = true;
            return true;
        } else if (numero >= 70 && numero < 80 && !siete) {
            siete = true;
            return true;
        } else if (numero >= 80 && numero <= 90 && !ocho) {
            ocho = true;
            return true;
        } else {
            return false;
        }
    }

    // Creamos cada fila con 9 posiciones(columna)
    // Retornamos un arrayList con las 3 listas(filas)
    public static List<ArrayList<String>> crearListas() {
        ArrayList<String> lista1 = new ArrayList<>(List.of("  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "));
        ArrayList<String> lista2 = new ArrayList<>(List.of("  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "));
        ArrayList<String> lista3 = new ArrayList<>(List.of("  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "));

        return new ArrayList<>(List.of(lista1, lista2, lista3));
    }

    // Cargamos las listas y por cada lista ejecutamos el metodo
    // Generamos un numero random entre 1 y 90
    // Si la lista(fila) NO contiene el numero random y ese numero random NO esta ocupado entonces lo setea en la posicion que corresponda
    public static void cargarListas(List<ArrayList<String>> lists) {
        lists.forEach((lista) -> {
            do {
                Integer random = randomNumber(1, 91);
                if (!lista.contains(random.toString()) && !ocupado(random)) {
                    if (random > 0 && random < 10) {
                        lista.set(0, String.format("%02d", random));
                    } else if (random >= 10 && random < 20) {
                        lista.set(1, random.toString());
                    } else if (random >= 20 && random < 30) {
                        lista.set(2, random.toString());
                    } else if (random >= 30 && random < 40) {
                        lista.set(3, random.toString());
                    } else if (random >= 40 && random < 50) {
                        lista.set(4, random.toString());
                    } else if (random >= 50 && random < 60) {
                        lista.set(5, random.toString());
                    } else if (random >= 60 && random < 70) {
                        lista.set(6, random.toString());
                    } else if (random >= 70 && random < 80) {
                        lista.set(7, random.toString());
                    } else if (random >= 80 && random <= 90) {
                        lista.set(8, random.toString());
                    }
                }
            } while(!finalizado(lista));

        });
    }

    public static void imprimirListas(List<ArrayList<String>> allLists) {
        allLists.forEach((lista) -> {
            lista.forEach((c) -> {
                System.out.print(c + " | ");
            });
            System.out.println("");
        });
    }
}