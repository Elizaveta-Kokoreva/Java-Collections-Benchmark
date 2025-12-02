package org.example;

import java.util.List;

public class TablePrinter {

    /**
     * Печатает таблицу с результатами.
     *
     * @param results список результатов тестов
     */
    public static void print(List<Result> results) {

        // Заголовок
        System.out.printf("%-15s | %-10s | %-18s | %-18s%n",
                "Method", "Count", "ArrayList (ms)", "LinkedList (ms)");

        System.out.println("--------------------------------------------------------------------------");

        // Строки таблицы
        for (Result r : results) {
            System.out.printf("%-15s | %-10d | %-18.3f | %-18.3f%n",
                    r.method,
                    r.count,
                    r.arrayListTime,
                    r.linkedListTime);
        }
    }
}
