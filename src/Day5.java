import java.util.ArrayList;

import static java.lang.System.out;

public class Day5 {
    public static void main(String... msrgs) {
        ArrayList<String> instructions = IO.ReadLine("C:\\Users\\jhard\\IdeaProjects\\Advent of Code\\src\\inputs\\day5.txt");
        int[] nums0 = new int[instructions.size()];
        int[] nums1 = new int[instructions.size()];
        for (int i = 0; i < instructions.size(); i++) {
            nums0[i] = Integer.parseInt(instructions.get(i));
            nums1[i] = Integer.parseInt(instructions.get(i));
        }
        compute(nums0,Integer.MAX_VALUE,"one");
        compute(nums1,3,"two");
    }

    private static void compute(int[] nums, int size, String part) {
        int counter = 0, current = 0, jump = 0;
        for (; ; ) {
            counter++;
            jump = nums[current];
            if (current + jump >= nums.length) break;
            nums[current] += nums[current] >= size ? -1 : 1;
            current += jump;
        }
        out.printf("%s: %s", part, counter);
    }
}
