package com.example.task17;

import java.util.List;

public interface Driver<T> {

    List<T> readAll();

    T read(long id);

}
