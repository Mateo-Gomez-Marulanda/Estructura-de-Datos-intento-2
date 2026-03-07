package co.edu.uniquindio.poo.Unidad1.Preparcial.Punto3;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add(new String("Chicago"));
        set.add(new String("Boston"));
        set.add(new String("Alabama"));
        set.add(new String("Chicago")); //chao pescao
        set.add(new String("chicago")); //los sets dectectan mayusculas, asi que esto se agrega
        System.out.println(set);
    }
}