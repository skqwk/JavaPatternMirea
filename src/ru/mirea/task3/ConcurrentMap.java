package ru.mirea.task3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ConcurrentMap<K, V> implements Map<K, V> {
    private final Map<K, V> map = new HashMap<>();
    private static final Semaphore semaphore = new Semaphore(1);

    @Override
    public int size() {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        int size = map.size();
        semaphore.release();
        return size;
    }

    @Override
    public boolean isEmpty() {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        boolean isEmpty = map.isEmpty();
        semaphore.release();
        return isEmpty;
    }

    @Override
    public boolean containsKey(Object key) {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        boolean containsKey = map.containsKey(key);
        semaphore.release();
        return containsKey;
    }

    @Override
    public boolean containsValue(Object value) {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        boolean containsValue = map.containsValue(value);
        semaphore.release();
        return containsValue;
    }

    @Override
    public V get(Object key) {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        V value = map.get(key);
        semaphore.release();
        return value;
    }

    @Override
    public V put(K key, V value) {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        V v = map.put(key, value);
        semaphore.release();
        return v;
    }

    @Override
    public V remove(Object key) {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        V value = map.remove(key);
        semaphore.release();
        return value;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        map.putAll(m);
        semaphore.release();
    }

    @Override
    public void clear() {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        map.clear();
        semaphore.release();
    }

    @Override
    public Set<K> keySet() {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        Set<K> keySet = map.keySet();
        semaphore.release();
        return keySet;
    }

    @Override
    public Collection<V> values() {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        Collection<V> values = map.values();
        semaphore.release();
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        Set<Entry<K, V>> entrySet = map.entrySet();
        semaphore.release();
        return entrySet;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        V getOrDefault = map.getOrDefault(key, defaultValue);
        semaphore.release();
        return getOrDefault;
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        map.forEach(action);
        semaphore.release();
    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        map.replaceAll(function);
        semaphore.release();
    }

    @Override
    public V putIfAbsent(K key, V value) {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        V v = map.putIfAbsent(key, value);
        semaphore.release();
        return v;
    }

    @Override
    public boolean remove(Object key, Object value) {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        boolean res = map.remove(key, value);
        semaphore.release();
        return res;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        boolean res = map.replace(key, oldValue, newValue);
        semaphore.release();
        return res;
    }

    @Override
    public V replace(K key, V value) {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        V v = map.replace(key, value);
        semaphore.release();
        return v;
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        V v = map.computeIfAbsent(key, mappingFunction);
        semaphore.release();
        return v;
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        V v = map.computeIfPresent(key, remappingFunction);
        semaphore.release();
        return v;
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        V v = map.compute(key, remappingFunction);
        semaphore.release();
        return v;
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        try { semaphore.acquire();}
        catch (InterruptedException e) {e.printStackTrace();}
        V v = map.merge(key, value, remappingFunction);
        semaphore.release();
        return v;
    }
}
