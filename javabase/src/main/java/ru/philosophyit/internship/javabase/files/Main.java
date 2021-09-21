package ru.philosophyit.internship.javabase.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    public static void printDirectory(String s) {
        String[] line = s.split("[(/) | (\\)]");
        String generalPath = String.join(File.separator, line);
        File[] files = new File(generalPath).listFiles();
        if (!Files.exists(Paths.get(generalPath))) {
            System.out.println(String.format("Директория \"%s\" не существует", generalPath));
            return;
        }
        for (File f : files) {
            if (f.isFile()) {
                System.out.println(f.getPath());
            }
            if (f.isDirectory()) {
                printDirectory(f.getPath());
            }
        }
    }

    public static void main(String... args) throws IOException {

        printDirectory("src/main/java/ru/philosophyit/internship/javabase");

        //Вывести содержимое всего проекта
        printDirectory("./");

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

