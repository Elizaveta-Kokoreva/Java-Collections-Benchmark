package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionTester {

    private final int COUNT;
    private static final int INITIAL_FILL = 100;

    public CollectionTester(int count) {
        this.COUNT = count;
    }

    /** Заполняет обе коллекции одинаковыми значениями */
    private void fillCollections(List<Integer> arrayList, List<Integer> linkedList) {
        for (int i = 0; i < INITIAL_FILL; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    // ADD TESTS

    /** add в конец */
    public Result testAddEnd() {

        List<Integer> modelArray = new ArrayList<>();
        List<Integer> modelLinked = new LinkedList<>();
        fillCollections(modelArray, modelLinked);

        long arrayTotal = 0;
        long linkedTotal = 0;

        for (int i = 0; i < COUNT; i++) {

            List<Integer> tempA = new ArrayList<>(modelArray);
            int finalI = i;
            arrayTotal += Benchmark.measure(() -> tempA.add(finalI));

            List<Integer> tempL = new LinkedList<>(modelLinked);
            int finalI1 = i;
            linkedTotal += Benchmark.measure(() -> tempL.add(finalI1));
        }

        return new Result("add(end)", COUNT,
                arrayTotal / 1_000_000.0,
                linkedTotal / 1_000_000.0);
    }


    /** add в начало */
    public Result testAddBegin() {

        List<Integer> modelArray = new ArrayList<>();
        List<Integer> modelLinked = new LinkedList<>();
        fillCollections(modelArray, modelLinked);

        long arrayTotal = 0;
        long linkedTotal = 0;

        for (int i = 0; i < COUNT; i++) {

            List<Integer> tempA = new ArrayList<>(modelArray);
            int finalI = i;
            arrayTotal += Benchmark.measure(() -> tempA.add(0, finalI));

            List<Integer> tempL = new LinkedList<>(modelLinked);
            int finalI1 = i;
            linkedTotal += Benchmark.measure(() -> tempL.add(0, finalI1));
        }

        return new Result("add(begin)", COUNT,
                arrayTotal / 1_000_000.0,
                linkedTotal / 1_000_000.0);
    }


    /** add в середину */
    public Result testAddMiddle() {

        List<Integer> modelArray = new ArrayList<>();
        List<Integer> modelLinked = new LinkedList<>();
        fillCollections(modelArray, modelLinked);

        long arrayTotal = 0;
        long linkedTotal = 0;

        for (int i = 0; i < COUNT; i++) {

            List<Integer> tempA = new ArrayList<>(modelArray);
            int indexA = tempA.size() / 2;
            int finalI = i;
            arrayTotal += Benchmark.measure(() -> tempA.add(indexA, finalI));

            List<Integer> tempL = new LinkedList<>(modelLinked);
            int indexL = tempL.size() / 2;
            int finalI1 = i;
            linkedTotal += Benchmark.measure(() -> tempL.add(indexL, finalI1));
        }

        return new Result("add(mid)", COUNT,
                arrayTotal / 1_000_000.0,
                linkedTotal / 1_000_000.0);
    }

    // GET TEST

    public Result testGet() {

        List<Integer> modelArray = new ArrayList<>();
        List<Integer> modelLinked = new LinkedList<>();
        fillCollections(modelArray, modelLinked);

        long arrayTotal = 0;
        long linkedTotal = 0;

        for (int i = 0; i < COUNT; i++) {

            List<Integer> tempA = new ArrayList<>(modelArray);
            int idxA = i % INITIAL_FILL;
            arrayTotal += Benchmark.measure(() -> tempA.get(idxA));

            List<Integer> tempL = new LinkedList<>(modelLinked);
            int idxL = i % INITIAL_FILL;
            linkedTotal += Benchmark.measure(() -> tempL.get(idxL));
        }

        return new Result("get", COUNT,
                arrayTotal / 1_000_000.0,
                linkedTotal / 1_000_000.0);
    }

    // REMOVE TESTS

    /** remove из начала */
    public Result testRemoveBegin() {

        List<Integer> modelArray = new ArrayList<>();
        List<Integer> modelLinked = new LinkedList<>();
        fillCollections(modelArray, modelLinked);

        long arrayTotal = 0;
        long linkedTotal = 0;

        for (int i = 0; i < COUNT; i++) {

            List<Integer> tempA = new ArrayList<>(modelArray);
            arrayTotal += Benchmark.measure(() -> tempA.remove(0));

            List<Integer> tempL = new LinkedList<>(modelLinked);
            linkedTotal += Benchmark.measure(() -> tempL.remove(0));
        }

        return new Result("remove(begin)", COUNT,
                arrayTotal / 1_000_000.0,
                linkedTotal / 1_000_000.0);
    }


    /** remove из середины */
    public Result testRemoveMiddle() {

        List<Integer> modelArray = new ArrayList<>();
        List<Integer> modelLinked = new LinkedList<>();
        fillCollections(modelArray, modelLinked);

        long arrayTotal = 0;
        long linkedTotal = 0;

        for (int i = 0; i < COUNT; i++) {

            List<Integer> tempA = new ArrayList<>(modelArray);
            int indexA = tempA.size() / 2;
            arrayTotal += Benchmark.measure(() -> tempA.remove(indexA));

            List<Integer> tempL = new LinkedList<>(modelLinked);
            int indexL = tempL.size() / 2;
            linkedTotal += Benchmark.measure(() -> tempL.remove(indexL));
        }

        return new Result("remove(mid)", COUNT,
                arrayTotal / 1_000_000.0,
                linkedTotal / 1_000_000.0);
    }


    /** remove с конца */
    public Result testRemoveEnd() {

        List<Integer> modelArray = new ArrayList<>();
        List<Integer> modelLinked = new LinkedList<>();
        fillCollections(modelArray, modelLinked);

        long arrayTotal = 0;
        long linkedTotal = 0;

        for (int i = 0; i < COUNT; i++) {

            List<Integer> tempA = new ArrayList<>(modelArray);
            int indexA = tempA.size() - 1;
            arrayTotal += Benchmark.measure(() -> tempA.remove(indexA));

            List<Integer> tempL = new LinkedList<>(modelLinked);
            int indexL = tempL.size() - 1;
            linkedTotal += Benchmark.measure(() -> tempL.remove(indexL));
        }

        return new Result("remove(end)", COUNT,
                arrayTotal / 1_000_000.0,
                linkedTotal / 1_000_000.0);
    }


    // CLEAR TEST

    public Result testClear() {

        List<Integer> modelArray = new ArrayList<>();
        List<Integer> modelLinked = new LinkedList<>();
        fillCollections(modelArray, modelLinked);

        long arrayTotal = 0;
        long linkedTotal = 0;

        for (int i = 0; i < COUNT; i++) {

            List<Integer> tempA = new ArrayList<>(modelArray);
            arrayTotal += Benchmark.measure(tempA::clear);

            List<Integer> tempL = new LinkedList<>(modelLinked);
            linkedTotal += Benchmark.measure(tempL::clear);
        }

        return new Result("clear", COUNT,
                arrayTotal / 1_000_000.0,
                linkedTotal / 1_000_000.0);
    }
}
