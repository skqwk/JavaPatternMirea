package ru.mirea.task2;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Filter {
    public static void main(String[] args) {
        ArrayList<Human> humans = HumanGenerator.generate();

        System.out.println("All humans:");
        for (Human human : humans) System.out.println(human);
        System.out.println();

        System.out.println("Humans with weight more than age:");
        Predicate<Human> weightLessThanAge = human -> human.getAge() < human.getWeight();
        humans.stream().filter(weightLessThanAge).forEach(System.out::println);
        System.out.println();

        System.out.println("Common weight:");
        int commonWeight = humans.stream().map(Human::getWeight).reduce(0, Integer::sum);
        System.out.println(commonWeight);
        System.out.println();

        System.out.println("Sort by last name in descending order:");
        humans.stream().sorted(new NameComparator()).forEach(System.out::println);
    }
}
