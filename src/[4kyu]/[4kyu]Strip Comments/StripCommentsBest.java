import java.util.Arrays;
import java.util.stream.Collectors;

public class StripComments {
    public static String stripComments(String text, String[] symbols) {
        return Arrays.stream(text.split("\n")).map(s -> {
            for (String symbol : symbols) s = s.replaceAll("(\\s+$)|(\\s*[" + symbol + "].*)", "");
            return s;
        }).collect(Collectors.joining("\n"));
    }
}