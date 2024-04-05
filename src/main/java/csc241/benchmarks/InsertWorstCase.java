package csc241.benchmarks;

import csc241.ds.DoubleLinkedList;
import csc241.sorting.SelectionSort;
import csc241.playground.ExternalOrderedList;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Random;

public class InsertWorstCase {
    private static final int iterations = 10000;

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

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void addAtStart_ArrayList() {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = iterations; i > 0; i--){
            al.add(0, i);
        }
    }

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(InsertWorstCase.class.getSimpleName())
                .build();
        new Runner(options).run();
    }
}
