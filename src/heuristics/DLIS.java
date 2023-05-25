package heuristics;

import dataTypes.Clause;
import dataTypes.Clause.State;
import dataTypes.Formula;
import dataTypes.Literal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DLIS {

    public static Literal getNextLiteral(Formula formula, Stack<Literal> trail) {

        Map<Literal, Integer> literalCount = new HashMap<>();

        for (Clause clause : formula.getClauses()) {
            if (clause.getState() == State.CLAUSE_SATISFIED) continue;
            for (Literal l : clause.getLiterals()) {
                literalCount.put(l, literalCount.getOrDefault(l, 0) + 1);
            }
        }

        if (literalCount.isEmpty()) return null;

        Literal next = Collections.max(literalCount.entrySet(), Map.Entry.comparingByValue())
            .getKey();
        while (trail.contains(next) || trail.contains(next.getNegatedCopy())) {
            literalCount.remove(next);
            literalCount.remove(next.getNegatedCopy());
            next = Collections.max(literalCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        }

        return next;
    }
}
