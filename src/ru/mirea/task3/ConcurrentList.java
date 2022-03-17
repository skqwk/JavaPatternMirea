package ru.mirea.task3;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.UnaryOperator;

public class ConcurrentList<T> implements List<T> {

    private final Lock lock = new ReentrantLock();
    private final List<T> list = new ArrayList<>();

    public void print() {
        lock.lock();
        System.out.println(list);
        lock.unlock();
    }


    @Override
    public int size() {
        lock.lock();
        int size = list.size();
        lock.unlock();
        return size;
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        boolean isEmpty = list.isEmpty();
        lock.lock();
        return isEmpty;
    }

    @Override
    public boolean contains(Object o) {
        lock.lock();
        boolean contains = list.contains(o);
        lock.lock();
        return contains;
    }

    @Override
    public Iterator<T> iterator() {
        lock.lock();
        Iterator iterator = list.iterator();
        lock.lock();
        return iterator;
    }

    @Override
    public Object[] toArray() {
        lock.lock();
        Object[] array = list.toArray();
        lock.lock();
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        lock.lock();
        T1[] array = list.toArray(a);
        lock.unlock();
        return array;
    }

    @Override
    public boolean add(T t) {
        lock.lock();
        boolean res = list.add(t);
        lock.unlock();
        return res;
    }

    @Override
    public boolean remove(Object o) {
        lock.lock();
        boolean res = list.remove(o);
        lock.unlock();
        return res;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        lock.lock();
        boolean res = list.containsAll(c);
        lock.unlock();
        return res;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        lock.lock();
        boolean res = list.addAll(c);
        lock.unlock();
        return res;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        lock.lock();
        boolean res = list.addAll(index, c);
        lock.unlock();
        return res;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        lock.lock();
        boolean res = list.removeAll(c);
        lock.unlock();
        return res;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        lock.lock();
        boolean res = list.retainAll(c);
        lock.unlock();
        return res;
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        lock.lock();
        List.super.replaceAll(operator);
        lock.unlock();
    }

    @Override
    public void sort(Comparator<? super T> c) {
        List.super.sort(c);
    }

    @Override
    public void clear() {
        lock.lock();
        list.clear();
        lock.unlock();
    }

    @Override
    public T get(int index) {
        lock.lock();
        T t = list.get(index);
        lock.unlock();
        return t;
    }

    @Override
    public T set(int index, T element) {
        lock.lock();
        T t = list.set(index, element);
        lock.unlock();
        return t;
    }

    @Override
    public void add(int index, T element) {
        lock.lock();
        list.add(index, element);
        lock.unlock();
    }

    @Override
    public T remove(int index) {
        lock.lock();
        T t = list.remove(index);
        lock.unlock();
        return t;
    }

    @Override
    public int indexOf(Object o) {
        lock.lock();
        int index = list.indexOf(o);
        lock.unlock();
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        lock.lock();
        int index = list.lastIndexOf(o);
        lock.unlock();
        return index;
    }

    @Override
    public ListIterator<T> listIterator() {
        lock.lock();
        ListIterator<T> listIterator = list.listIterator();
        lock.unlock();
        return listIterator;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        lock.lock();
        ListIterator<T> listIterator = list.listIterator(index);
        lock.unlock();
        return listIterator;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        lock.lock();
        List<T> subList = list.subList(fromIndex, toIndex);
        lock.unlock();
        return subList;
    }


    @Override
    public String toString() {
        lock.lock();
        String str = list.toString();
        lock.unlock();
        return str;
    }
}
