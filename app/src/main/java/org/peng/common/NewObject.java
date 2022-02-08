package org.peng.common;

public class NewObject {
    static public Object New(String className){
        Object o = null;
        try {
            Class<?> aClass = Class.forName(className);
            o = aClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return o;
    }

}
