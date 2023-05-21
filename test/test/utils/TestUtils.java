package test.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;

import DPLL.DPLL;
import exceptions.BCPException;
import exceptions.FileFormatException;
import java.io.IOException;
import parser.Parser;

public class TestUtils {


    public static boolean test(DPLL dpll, String fileName, boolean print) {
        Parser parser = new Parser();
        try {
            parser.parse(fileName);

            boolean satisfiable = dpll.evaluate(parser.getFormula());

            if (print) {
                System.out.println("Model: " + dpll.printModel());
                System.out.println("formula is satisfiable: " + satisfiable);
            }

            return satisfiable;

        } catch (IOException | BCPException | FileFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
