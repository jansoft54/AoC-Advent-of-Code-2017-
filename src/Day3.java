import static java.lang.System.in;
import static java.lang.System.out;

public class Day3 {
    private static final int input = 325489;
    private static final int origin = 499;
    private static int[][] nums = new int[1000][1000];


    public static void main(String... args) {
        prefaceA();
        computeA();
        nums = new int[1000][1000];
        prefaceB();
        computeB();

    }

    private static void prefaceB() {
        nums[origin][origin] = 1;
        nums[origin][origin + 1] = findSum(origin, origin + 1);
        nums[origin - 1][origin + 1] = findSum(origin + 1, origin - 1);
        nums[origin - 1][origin] = findSum(origin, origin - 1);
        nums[origin - 1][origin - 1] = findSum(origin - 1, origin - 1);
        nums[origin][origin - 1] = findSum(origin - 1, origin);
    }

    private static void prefaceA() {
        nums[origin][origin] = 1;
        nums[origin][origin + 1] = 2;
        nums[origin - 1][origin + 1] = 3;
        nums[origin - 1][origin] = 4;
        nums[origin - 1][origin - 1] = 5;
        nums[origin][origin - 1] = 6;
    }


    private static void computeB() {
        int sign = 1, direction = 4;

        for (int x = origin - 1, y = origin + 1; ; ) {
            for (int i = 0; i < direction; ++i) {
                nums[y][x + (i * sign)] = findSum(x + (i * sign), y);
                if (nums[y][x + i * sign] > input) {
                    out.println(nums[y][x + i * sign]);
                    return;
                }
            }
            x += (direction - 1) * sign;
            for (int i = 0; i < direction; ++i) {
                nums[y - i * sign][x] = findSum(x, y - i * sign);
                if (nums[y - i * sign][x] > input) {
                    out.println(nums[y - i * sign][x]);
                    return;
                }
            }
            y -= (direction - 1) * sign;
            sign *= -1;
            direction++;
        }
    }
    private static void computeA() {
        int sign = 1, direction = 4, counter = 7;

        for (int x = origin - 1, y = origin + 1; ; ) {
            for (int i = 0; i < direction; ++i) {
                nums[y][x + (i * sign)] = i > 0 ? ++counter : nums[y][x + (i * sign)];
                if (nums[y][x + i * sign] == input) {
                    int distance = Math.abs(origin - y) + Math.abs(origin - (x + i * sign));
                    out.println(distance);
                    return;
                }
            }
            x += (direction - 1) * sign;
            for (int i = 0; i < direction; ++i) {
                nums[y - i * sign][x] = i > 0 ? ++counter : nums[y - i * sign][x];
                if (nums[y - i * sign][x] == input) {
                    int distance = Math.abs(origin - (y - i * sign)) + Math.abs(origin - x);
                    out.println(distance);
                    return;
                }
            }
            y -= (direction - 1) * sign;
            sign *= -1;
            direction++;
        }
    }

    private static int findSum(int x, int y) {
        return nums[y - 1][x - 1] + nums[y - 1][x] + nums[y - 1][x + 1]
                + nums[y][x - 1] + nums[y][x + 1] +
                nums[y + 1][x - 1] + nums[y + 1][x] + nums[y + 1][x + 1];
    }
}
