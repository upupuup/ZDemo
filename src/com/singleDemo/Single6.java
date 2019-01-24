package com.singleDemo;

import java.io.*;

public class Single6 {
    private static Single6 single6;

    private Single6() {
    }

    public static Single6 getInstance() {
        return Single6.InnerClass.single6;
    }

    private static class InnerClass {
        private static final Single6 single6 = new Single6();
    }

    public Object readResolve() {
        return InnerClass.single6;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, IOException, ClassNotFoundException {
        Single6 single6 = Single6.class.newInstance();
        Single6 single6Two = getInstance();
        System.out.println(single6 + "\n" + single6Two);

        String filePath = "";
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath));

        outputStream.writeObject(getInstance());

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath));
        Single6 single = (Single6) inputStream.readObject();
    }
}
