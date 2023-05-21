package dataTypes;

import dataTypes.Clause.State;
import java.util.LinkedList;
import java.util.List;

public class Formula {

    public enum State {
        FORMULA_SATISFIED, FORMULA_UNSATISFIED, FORMULA_UNDECIDED
    }

    private final List<Clause> clauses;


    private final List<Variable> variables;

    private State state;




    public Formula(List<Clause> clauses, List<Variable> variables) {
        this.clauses = new LinkedList<>(clauses);
        this.variables = new LinkedList<>(variables);
        this.state = State.FORMULA_UNDECIDED;
    }

    public List<Clause> findUnitClauses() {
        List<Clause> unitClauses = new LinkedList<>();
        for (Clause clause: clauses) {
            if (clause.isUnitClause()) unitClauses.add(clause);
        }
        return unitClauses;
    }

    public void checkAndSetIfSatisfied() {
        for (Clause clause: clauses) {
            if (clause.getState() != Clause.State.CLAUSE_SATISFIED) {
                return;
            }
        }
        state = State.FORMULA_SATISFIED;
    }

    public Formula getCopy() {
        return new Formula(this.clauses, this.variables);
    }

    public State getState() {
        return state;
    }

    public boolean isSatisfied() {
        return state == State.FORMULA_SATISFIED;
    }

    public boolean isUnsatisfied() {
        return state == State.FORMULA_UNSATISFIED;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Clause> getClauses() {
        return clauses;
    }

    public List<Variable> getVariables() {
        return variables;
    }
}
