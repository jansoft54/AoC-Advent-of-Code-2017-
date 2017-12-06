import static java.lang.System.in;
import static java.lang.System.out;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day6 {
    public static void main(String... args) {
        ArrayList<String> encountered = new ArrayList<>();
        int counter = 0;
        String input = "5\t1\t10\t0\t1\t7\t13\t14\t3\t12\t8\t10\t7\t12\t0\t6";
        ArrayList<Integer> bank = (ArrayList<Integer>) Arrays.stream(input.split("\t"))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        while (!encountered.contains(bank.toString())) {
            ++counter;
            encountered.add(bank.toString());
            int max = Collections.max(bank);
            int index = bank.indexOf(max);
            bank.set(index, 0);
            IntStream.range(1, max + 1).map(i -> (index + i) % bank.size()).forEach(i -> bank.set(i, bank.get(i) + 1));
        }
        out.printf("Part one: %s", counter);
        out.printf("Part two: %s", counter - encountered.indexOf(bank.toString()));
    }
}
