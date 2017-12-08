import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Day8 {
    public static void main(String... args) {
        HashMap<String, Integer> variables = new HashMap<>();
        int highest = 0;

        for (String line : IO.ReadLine("FILENAME")) {
            String[] elements = line.split(" ");
            variables.putIfAbsent(elements[4], 0);
            variables.putIfAbsent(elements[0], 0);
            highest = variables.get(elements[0]) > highest ? variables.get(elements[0]) : highest;
            if (logicAnalyser(elements[5], variables.get(elements[4]),Integer.parseInt(elements[6])))
                if (elements[1].equals("inc"))
                    variables.put(elements[0], variables.get(elements[0]) + Integer.parseInt(elements[2]));
                else if (elements[1].equals("dec"))
                    variables.put(elements[0], variables.get(elements[0]) - Integer.parseInt(elements[2]));
        }
        List u=variables.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        out.printf("Part one: %s",u.get(u.size() - 1));
        out.printf(" Part two: %s",highest);

    }
    private static boolean logicAnalyser(String op, int a, int b) {
        switch (op) {
            case ">":
                return a > b;
            case "<":
                return a < b;
            case ">=":
                return a >= b;
            case "<=":
                return a <= b;
            case "==":
                return a == b;
            case "!=":
                return a != b;
            default:
                return false;

        }
    }
}
