package ru.philosophyit.internship.javabase.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Main {
    public static void printDirectory(String s) {
        try {
            File[] files = new File(s).listFiles();
            if (files.length == 0) System.out.println(String.format("В директории \"%s\" нет файлов и поддиректорий", s));
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println(f.getPath());
                }
                if (f.isDirectory()) {
                    printDirectory(f.getPath());
                }
            }
        } catch (NullPointerException e) {
            System.out.println(String.format("Директория \"%s\" не существует", s));
        }
    }

    public static void main(String... args) throws IOException {
       // System.out.println(Files.readString(Path.of("src/main/resources/hello.txt")));
        printDirectory("src/main/java/ru/philosophyit/internship/javabase");

        // Отобразите рекурсивно дерево директорий src/main/java/ru/philosophyit/internship/javabase
        // например
        // src/main/java/ru/philosophyit/internship/javabase/files/Main.java
        // src/main/java/ru/philosophyit/internship/javabase/locks/DeadLock.java
        // src/main/java/ru/philosophyit/internship/javabase/locks/LiveLock.java
        // src/main/java/ru/philosophyit/internship/javabase/threads/Completable.java
        // и т.д.
        /// Более удачные оформления вывода в консоль приветствуются
    }
}

