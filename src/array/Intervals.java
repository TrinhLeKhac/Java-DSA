package array;

// Given a list of intervals, merge all the overlapping intervals and return a list of non-ovrerlapping intervals
// Example -
// Input: intervals = [{2, 6}, {1, 3}, {8, 10}]
// Output: [{1, 6}, 8, 0}]

// Given a list of non-overlapping intervals sorted by their start time, insert a given interval at a valid position
// merge all the overlapping intervals and return a list of mutually exclusive intervals
// Example -
// Input: intervals = [{1, 3}, {5, 7}, {8, 10}]
// Insert interval {4, 9}
// Output: intervals = [{1, 3}, {4, 10}]

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Intervals {
    private int size;
    private List<Interval> intervals;

    public Intervals() {
        size = 0;
        intervals = new LinkedList<>();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static class Interval {
        private final int start;
        private final int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(start).append(", ").append(end).append(")");
            return sb.toString();
        }
    }

    public void add(Interval newInterval) {
        intervals.add(newInterval);
        size++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Intervals");
        }
        for (int i = 0; i < size; i++) {
            Interval current = this.intervals.get(i);
            if (i < size - 1) {
                sb.append(current).append(" => ");
            } else {
                sb.append(current);
            }
        }
        return sb.toString();
    }


    public void merge() {
        if (size < 2) {
            return;
        }
        intervals.sort(Comparator.comparingInt(i -> i.start));
        List<Interval> result = new LinkedList<>();
        int count = 0;
        Interval first = intervals.getFirst();
        int start = first.start;
        int end = first.end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.start <= end) {
                end = Math.max(end, current.end);
            } else {
                result.add(new Interval(start, end));
                count++;
                start = current.start;
                end = current.end;
            }
        }
        result.add(new Interval(start, end));
        count++;
        size = count;
        intervals = result;
    }

    // Insert a new interval to a list of sorted non-overlapping intervals
    public void insert(Interval newInterval) {
        if (intervals == null || intervals.isEmpty()) {
            return;
        }
        List<Interval> result = new LinkedList<>();
        int i = 0;
        int count = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) { // under non-overlap
            result.add(intervals.get(i));
            i++;
            count++;
        }
        int start = newInterval.start;
        int end = newInterval.end;
        while (i < intervals.size() && intervals.get(i).start <= end) {  // overlap
            Interval current = intervals.get(i);
            start = Math.min(current.start, start);
            end = Math.max(current.end, end);
            i++;
        }
        result.add(new Interval(start, end));
        count++;
        while (i < intervals.size()) {  // over non-overlap
            result.add(intervals.get(i));
            i++;
            count++;
        }
        size = count;
        intervals = result;
    }

    public static void main(String[] args) {
        System.out.println("----------------Add interval into Intervals-----------------------");
        Intervals intervals = new Intervals();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(7, 10));
        intervals.add(new Interval(11, 13));
        intervals.add(new Interval(8, 15));
        intervals.add(new Interval(27, 30));
        System.out.println(intervals);
        System.out.println('\n');

        System.out.println("----------------Merge Intervals-----------------------");
        intervals.merge();
        System.out.println(intervals);
        System.out.println('\n');

        System.out.println("----------------Insert interval to Intervals-----------------------");

        Interval interval1 = new Interval(16, 20);
        System.out.println("Insert interval " + interval1 + " to Intervals");
        intervals.insert(interval1);
        System.out.println(intervals);

        Interval interval2 = new Interval(13, 17);
        System.out.println("Insert interval " + interval2 + " to Intervals");
        intervals.insert(interval2);
        System.out.println(intervals);
    }
}
