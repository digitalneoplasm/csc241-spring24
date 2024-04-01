package csc241.benchmarks;

import csc241.playground.ExternalOrderedList;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class InsertionSort {
    private static final int iterations = 2000;

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void addAtEnd_noIterator() {
        ExternalOrderedList<Integer> eol = new ExternalOrderedList<>();
        for (int i = 0; i < iterations; i++){
            eol.add(i);
        }
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void addAtEnd_iterator() {
        ExternalOrderedList<Integer> eol = new ExternalOrderedList<>();
        for (int i = 0; i < iterations; i++){
            eol.addWithIterator(i);
        }
    }

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(InsertionSort.class.getSimpleName())
                .build();
        new Runner(options).run();
    }
}
