package org.example;

public class Benchmark {

    /**
     * Измеряет время выполнения переданного действия.
     *
     * @param action Runnable, который будет выполнен
     * @return время в наносекундах
     */
    public static long measure(Runnable action) {
        long start = System.nanoTime();
        action.run();
        return System.nanoTime() - start;
    }
}
