package ru.mirea.task5;

public class TestSingleton {
    public static void main(String[] args) {
        EnumSingleton s1 = EnumSingleton.instance;
        EnumSingleton s2 = EnumSingleton.instance;
        System.out.println("s1=" + s1 + "\ns2=" + s2);
        System.out.println();

        LazyInitSingleton s3 = LazyInitSingleton.getInstance();
        LazyInitSingleton s4 = LazyInitSingleton.getInstance();
        System.out.println("s3=" + s3 + "\ns4=" + s4);
        System.out.println();

        ThreadSafeSingleton s5 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton s6 = ThreadSafeSingleton.getInstance();
        System.out.println("s5=" + s5 + "\ns6=" + s6);
        System.out.println();
    }
}
