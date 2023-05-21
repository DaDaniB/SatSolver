package parser.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ParserUtils {

    public final static String TEST_FORMULAS_BASE_PATH = "testFormulas/test-formulas/";

    public static List<String> readFile(String fileName) throws IOException {
        Path path = Paths.get(TEST_FORMULAS_BASE_PATH + fileName);
        BufferedReader reader;
        reader = Files.newBufferedReader(path);

        return readAllLines(reader);
    }

    private static List<String> readAllLines(BufferedReader reader) {
        List<String> lines = new LinkedList<>();
        reader.lines().forEach(lines::add);
        return lines;
    }
    public static void removeLineFromList(List<?> list, int index) {
        list.remove(index);
    }

    public static String removeFirstCharFromString(String str) {
        return str.substring(1);
    }

    public static String[] removeLineSeperator(String[] line) {
        return Arrays.copyOf(line, line.length - 1);
    }
}
