package com.company;

import java.util.ArrayList;


/**
 * Created by Oskar on 2017-01-09.
 */

public class MyStackList<E> extends ArrayList<E> {


        public E pop() {
            E e = get(size() - 1);
            remove(size() - 1);
            return e;
        }

        public void push(E e) {
            add(e);
        }

    }
