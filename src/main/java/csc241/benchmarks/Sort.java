package csc241.benchmarks;

import csc241.ds.DoubleLinkedList;
import csc241.sorting.SelectionSort;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;
import java.util.stream.Collectors;

public class Sort {

    @State(Scope.Benchmark)
    public static class BenchmarkState {
        @Param({"10000"}) //, "20000", "40000", "80000", "160000"})
        public int listSize;

        public List<Integer> testList;

        @Setup(Level.Trial)
        public void setUp() {
            testList = new Random()
                    .ints()
                    .limit(listSize)
                    .boxed()
                    .collect(Collectors.toList());
        }
    }

    /*
    Insertion sort on arrays.
     */
    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void addInOrder_Random_ArrayList(BenchmarkState benchmarkState) {
        ArrayList<Integer> al = new ArrayList<>();
        outer: for (int i = 0; i < benchmarkState.listSize; i++){
            int num = benchmarkState.testList.get(i);
            for (int j = 0; j < al.size(); j++){
                if (al.get(j).compareTo(num) > 0) {
                    al.add(j, num);
                    continue outer;
                }
            }
            al.add(num);
        }
    }

    /*
    Insertion sort on linked lists
     */
    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void addInOrder_Random_LinkedList(BenchmarkState benchmarkState) {
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        for (int i = 0; i < benchmarkState.listSize; i++){
            dll.addInOrder(benchmarkState.testList.get(i));
        }
    }

    /*
    Insertion sort on Java'slinked lists
    */
    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void addInOrder_Random_JavaLinkedList(BenchmarkState benchmarkState) {
        LinkedList<Integer> ll = new LinkedList<>();
        outer: for (int i = 0; i < benchmarkState.listSize; i++){
            ListIterator<Integer> li = ll.listIterator();
            while (li.hasNext()){
                Integer in = li.next();
                if (in > benchmarkState.testList.get(i)) {
                    li.add(benchmarkState.testList.get(i));
                    continue outer;
                }
            }
            li.add(benchmarkState.testList.get(i));
        }
    }

    /*
    Selection sort on ArrayLists.
     */
    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void selectionSort_Random_ArrayList(BenchmarkState benchmarkState) {
        ArrayList<Integer> listToSort = new ArrayList<>(benchmarkState.testList);
        SelectionSort.selectionSort(listToSort);
    }

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(Sort.class.getSimpleName())
                .build();
        new Runner(options).run();
    }
}
