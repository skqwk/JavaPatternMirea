package ru.mirea.task6.prototype;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestNinjaPrototype {
    public static void main(String[] args) {
        List<Ninja> ninjaList = new ArrayList<>();

        Random random = new SecureRandom();
        // add KokaRu
        for (int i = 0; i < 5; ++i) {
            ninjaList.add(
                    new KokaRu(
                            random.nextInt(10),
                            random.nextInt(10),
                            random.nextInt(10),
                            random.nextInt(10)
                    )
            );
        }

        for (int i = 0; i < 5; ++i) {
            ninjaList.add(
                    new IgaRu(
                            random.nextInt(10),
                            random.nextInt(10),
                            random.nextInt(10),
                            random.nextInt(10)
                    )
            );
        }


        for (int i = 0; i < 10; ++i) ninjaList.add(ninjaList.get(i).clone());


        for (Ninja n : ninjaList) System.out.println(n);
    }
}
