package DPLL;

import bcp.BCP;
import dataTypes.Clause;
import dataTypes.Formula;
import dataTypes.Formula.State;
import dataTypes.Literal;
import dataTypes.Variable;
import exceptions.BCPException;
import heuristics.DLIS;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DPLL {


    private final Stack<Literal> literalStack = new Stack<>();

    Stack<Integer> control = new Stack<>();
    Stack<Literal> trail = new Stack<>();

    Literal unitClauseLiteral = null;

    public boolean evaluate(Formula formula) throws BCPException {

        while (true) {

            BCP.bcp(formula, trail, unitClauseLiteral);

            formula.checkAndSetIfSatisfied();

            switch (formula.getState()) {
                case FORMULA_SATISFIED -> {
                    return true;
                }
                case FORMULA_UNSATISFIED -> {
                    if (literalStack.isEmpty()) return false;
                    unitClauseLiteral = backtrack();
                    formula.setState(State.FORMULA_UNDECIDED);
                }
                case FORMULA_UNDECIDED -> {
                    //Literal l = getNextLiteral(formula);
                    Literal l = DLIS.getNextLiteral(formula, trail);
                    if (l == null) {
                        System.out.println("next literal is null");
                        return false;
                    }

                    literalStack.push(l.getNegatedCopy());
                    unitClauseLiteral = l;
                    control.push(trail.size());
                }
            }

        }
    }

    private Literal backtrack() {
        unassignVariablesToOldTrailHeight();
        return literalStack.pop();
    }

    private void unassignVariablesToOldTrailHeight() {
        int oldTrailHeight = control.pop();

        while (trail.size() > oldTrailHeight) {
            trail.pop().getVariable().unassign();
        }
    }

    private Literal getNextLiteral(Formula formula) {
        for (Variable v: formula.getVariables()) {

            boolean contained = false;
            for (Literal trailLiteral: trail) {
                if (v.getName().equals(trailLiteral.getVariable().getName())) {
                    contained = true;
                }
            }

            if (!contained) return new Literal(v, false);
        }
        return null;
    }


    public String printModel() {
        StringBuilder sb = new StringBuilder();

        for (Literal l: trail) {
            sb.append(l.toString());
            sb.append(" ");
        }
        return sb.toString();
    }
}
