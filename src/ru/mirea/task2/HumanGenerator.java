package ru.mirea.task2;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class HumanGenerator {

    static final String[] names = new String[] {
            "Patricia",
            "Virginia",
            "Abelardo",
            "Jonathan",
            "Adrián",
            "Josep",
            "Porfirio",
            "Belén",
            "César",
            "Tito",
            "Lucano",
            "Rita",
    };
    static final String[] surnames = new String[] {
            "Fisher",
            "Mosley",
            "Freeman",
            "Mccall",
            "Giles",
            "Soto",
            "Esparza",
            "Andrade",
            "Mcknight",
            "Gould",
            "Aguilar",
            "Jacobs"
    };

    static final LocalDate[] dates = new LocalDate[] {
            LocalDate.parse("1957-12-11"),
            LocalDate.parse("1969-04-28"),
            LocalDate.parse("1985-06-25"),
            LocalDate.parse("1986-06-11"),
            LocalDate.parse("1995-08-15"),
            LocalDate.parse("1995-09-06"),
            LocalDate.parse("1998-07-20"),
            LocalDate.parse("2008-07-07"),
            LocalDate.parse("2009-07-20"),
            LocalDate.parse("2021-04-06"),
    };

    static ArrayList<Human> generate() {
        ArrayList<Human> humans = new ArrayList<>();
        Random random = new SecureRandom();
        for (int i = 0; i < 10; ++i) {
            humans.add(new Human(
                    random.nextInt(60)+15,
                    names[random.nextInt(10)],
                    surnames[random.nextInt(10)],
                    dates[random.nextInt(10)],
                    random.nextInt(10)+40
                    ));
        }
        return humans;
    }
}
