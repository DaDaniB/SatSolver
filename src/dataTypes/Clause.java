package dataTypes;

import dataTypes.Literal.State;
import java.util.LinkedList;
import java.util.List;

public class Clause {

    public enum State {
        CLAUSE_SATISFIED, CLAUSE_UNSATISFIED, CLAUSE_UNIT, CLAUSE_UNDECIDED
    }

    private State state;

    private final List<Literal> literals;

    private final List<Literal> watchedLiterals = new LinkedList<>();

    private Literal unitLiteral;


    public Clause(List<Literal> literals) {
        this.literals = literals;
        checkAndSetInitState();
        addClauseToVariables();
    }

    private void checkAndSetInitState() {
        if (literals.isEmpty()) {
            state = State.CLAUSE_UNSATISFIED;
        } else if (literals.size() == 1) {
            state = State.CLAUSE_UNIT;
            unitLiteral = literals.get(0);
            watchedLiterals.add(literals.get(0));
        } else {
            state = State.CLAUSE_UNDECIDED;
            watchedLiterals.add(literals.get(0));
            watchedLiterals.add(literals.get(1));
        }
    }

    private void addClauseToVariables() {
        for (Literal l: literals) {
            l.getVariable().addClause(this);
        }
    }

    public State updateOnAssignment() {
        switch (state) {
            case CLAUSE_SATISFIED, CLAUSE_UNSATISFIED -> {
            }
            case CLAUSE_UNIT -> {
                updateStateOnUnitLiteral();
            }
            case CLAUSE_UNDECIDED -> {
                updateOnWatchedLiterals();
            }
        }
        return state;
    }

    private void updateStateOnUnitLiteral() {
        Literal.State literalState = unitLiteral.getState();
        switch (literalState) {
            case LITERAL_UNDECIDED -> {
            }
            case LITERAL_TRUE -> {
                state = State.CLAUSE_SATISFIED;
            }
            case LITERAL_FALSE -> {
                state = State.CLAUSE_UNSATISFIED;
            }
        }
    }

    private void updateOnWatchedLiterals() {

        Literal watchedLiteral = watchedLiterals.get(0);
        if (watchedLiteral.getState() != Literal.State.LITERAL_UNDECIDED) {
            if (watchedLiteral.getState() == Literal.State.LITERAL_TRUE) {
                state = State.CLAUSE_SATISFIED;
            } else {
                updateWatchPointer(watchedLiteral);
            }
            return;
        }

        watchedLiteral = watchedLiterals.get(1);
        if (watchedLiteral.getState() != Literal.State.LITERAL_UNDECIDED) {
            if (watchedLiteral.getState() == Literal.State.LITERAL_TRUE) {
                state = State.CLAUSE_SATISFIED;
            } else {
                updateWatchPointer(watchedLiteral);
            }
        }
    }

    private void updateWatchPointer(Literal watchedLiteral) {
        Literal newWatchedLiteral = null;
        for (Literal l : literals) {
            Literal.State literalState = l.getState();

            if (literalState == Literal.State.LITERAL_TRUE) {
                state = State.CLAUSE_SATISFIED;
                return;
            }

            if (literalState == Literal.State.LITERAL_UNDECIDED && !watchedLiterals.contains(l)) {
                newWatchedLiteral = l;
            }
        }

        if (newWatchedLiteral != null) {
            watchedLiterals.remove(watchedLiteral);
            watchedLiterals.add(newWatchedLiteral);
        } else {
            state = State.CLAUSE_UNIT;

            for (Literal wl: watchedLiterals) { // assign other watched literal as unitLiteral
                if (!wl.equals(watchedLiteral)) {

                    if (wl.getState() == Literal.State.LITERAL_FALSE){      // if other wl is also false
                        state = State.CLAUSE_UNSATISFIED;
                        return;
                    }

                    unitLiteral = wl;
                }
            }
        }
    }

    public void updateOnUnassignment() {
        boolean isSatisfied = isSatisfied();
        if (literals.isEmpty()) {       //just to make sure
            state = State.CLAUSE_UNSATISFIED;
        } else if (literals.size() == 1) {
            if (isSatisfied) {
                state = State.CLAUSE_SATISFIED;
            } else {
                state = State.CLAUSE_UNIT;
            }
            unitLiteral = literals.get(0);
        } else {
            if (isSatisfied) {
                state = State.CLAUSE_SATISFIED;
            } else {
                state = State.CLAUSE_UNDECIDED;
            }

        }
    }

    private boolean isSatisfied() {
        for (Literal l: literals) {
            if (l.getState() == Literal.State.LITERAL_TRUE) return true;
        }
        return false;
    }


    public boolean isUnitClause() {
        return this.state == State.CLAUSE_UNIT;
    }

    public Literal getUnitLiteral() {
        return unitLiteral;
    }

    public void setUnitLiteral(Literal unitLiteral) {
        this.unitLiteral = unitLiteral;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Literal> getLiterals() {
        return literals;
    }



}
