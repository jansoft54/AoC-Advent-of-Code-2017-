import java.util.*;
import java.util.stream.IntStream;

import static java.lang.System.*;

public class Day7 {
    private static ArrayList<Node> nodes;

    public static void main(String... args) {

        ArrayList<String> lines = new ArrayList<>();
        nodes = new ArrayList<>();
        lines.addAll(IO.ReadLine("FILENAME"));
        String subTowers = "";
        String root = "";

        for (String line : lines) {
            String nodeName = line.split("\\(")[0].trim();
            int weight = Integer.parseInt(line.substring(line.indexOf("(") + 1, line.indexOf(")")));
            nodes.add(new Node(nodeName, weight));
            if (line.contains("->"))
                subTowers += line.split("->")[1].trim();
        }

        for (String line : lines) {
            if (line.contains("->")) {
                String nodeName = line.split("\\(")[0].trim();
                String otherNodes = line.split("->")[1].trim();
                if (!subTowers.contains(line.split("\\(")[0].trim()))
                    out.println("Part one: " + (root = line.split("\\(")[0].trim()));
                for (String otherNode : otherNodes.split(",")) {
                    otherNode = otherNode.trim();
                    getNodebyName(nodeName).addNode(getNodebyName(otherNode));
                }
            }
        }
        getNodebyName(root).checkBalanced(0);
    }

    private static Node getNodebyName(String name) {
        for (Node n : nodes)
            if (n.name.equals(name))
                return n;
        return null;
    }

    private static class Node {
        int weight;
        String name;
        ArrayList<Node> children = new ArrayList<>();

        Node(String name, int weight) {
            this.weight = weight;
            this.name = name;
        }

        void checkBalanced(int prev) {
            List<Integer> childrenweights = new ArrayList<>();
            List<Integer> help = new ArrayList<>();
            for (Node n : children)
                childrenweights.add(n.getWeight());

            help.addAll(childrenweights);
            Collections.sort(childrenweights);

            if (childrenweights.stream().distinct().count() > 1) {
                int right = childrenweights.get(0);
                int wrong = childrenweights.get(childrenweights.size() - 1);
                children.get(help.indexOf(wrong)).checkBalanced(right);
            } else {
                if (prev != 0)
                    out.println("Part two: " + (prev - childrenweights.stream().mapToInt(f -> f).sum()));
            }
        }

        void addNode(Node node) {
            children.add(node);
        }

        int getWeight() {
            int sum = 0;
            for (Node n : children)
                sum += n.getWeight();
            return weight + sum;
        }
    }
}
//start: uownj
