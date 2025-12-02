package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int COUNT = 50_000; // можешь менять количество операций

        CollectionTester tester = new CollectionTester(COUNT);

        List<Result> results = new ArrayList<>();

        results.add(tester.testAddEnd());
        results.add(tester.testAddBegin());
        results.add(tester.testAddMiddle());
        results.add(tester.testGet());
        results.add(tester.testRemoveBegin());
        results.add(tester.testRemoveMiddle());
        results.add(tester.testRemoveEnd());
        results.add(tester.testClear());

        TablePrinter.print(results);
    }
}
