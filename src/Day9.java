import static java.lang.System.out;

public class Day9 {
    public static void main(String... args) {
        String line = IO.ReadLine("FILENAME").get(0);
        StringBuilder builder = new StringBuilder(line);
        int garbagecount = 0;
        while (line.contains("!")) {
            int i = line.indexOf("!");
            builder.deleteCharAt(i);
            builder.deleteCharAt(i);
            line = builder.toString();
        }
        while (line.contains("<")) {
            int start = line.indexOf("<");
            int end = line.indexOf(">");
            if (start != -1 && end != -1) {
                garbagecount += line.substring(start + 1, end).length();
                line = builder.delete(start, end + 1).toString();
            }
        }
        int counter=0,score = 0;
        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == '{') {
                counter++;
                score += counter;
            } else if (line.charAt(i) == '}')
                counter--;
        }
        out.println("Score " + score);
        out.println("Garbage " +garbagecount);


    }
}
