import java.util.ArrayList;

public class Day5 {
    public static void main(String... msrgs) {
        ArrayList<String> instructions = IO.ReadLine("FILENAME");
        int[] nums = new int[instructions.size()];
        for (int i = 0; i < instructions.size(); i++) {
            nums[i] = Integer.parseInt(instructions.get(i));
            System.out.println(nums[i]);
        }
        int counter = 0, current = 0, jump = 0;
        for (; ; ) {
            counter++;
            jump = nums[current];
            if (current + jump >= nums.length) break;
            nums[current] += nums[current] >= 3 ? -1 : 1;
            current += jump;

        }
        System.out.println("counter" + counter);
    }
}
