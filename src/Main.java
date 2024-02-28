import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String[] strings = Stream.generate(() -> String.valueOf((int) (Math.random() * 10)))
                .limit(12)
                .toArray(String[]::new);

        System.out.println(Arrays.toString(strings));
        System.out.println(uniqueString(strings));
    }

    public static String uniqueString(String... strings) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String s : strings) {
            Integer count = map.getOrDefault(s, 0);
            map.put(s, count + 1);
        }
        return map.entrySet().stream()
                .filter(stringIntegerEntry -> stringIntegerEntry.getValue().equals(1))
                .map(stringIntegerEntry -> new StringBuilder(stringIntegerEntry.getKey()))
                .reduce(StringBuilder::append)
                .orElse(new StringBuilder()).toString();
    }
}