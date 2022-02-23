package org.peng.calculator;

import java.util.ArrayList;
import java.util.List;

public class CalStack{

    private List l;
    private int size = 0;
    public String top;

    public CalStack() {
        l = new ArrayList();
        size = 0;
        top = null;
    }

    public int size() {
        return size;
    }

    public void push(String s) {
        l.add(s);
        top = s;
        size++;
    }

    public String pop() {
        String s = (String) l.get(size - 1);
        l.remove(size - 1);
        size--;
        top = size == 0 ? null : (String) l.get(size - 1);
        return s;
    }
}
