package dataTypes;

import dataTypes.Clause.State;
import exceptions.BCPException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Variable {

    public enum State {
        VARIABLE_UNASSIGNED, VARIABLE_FALSE, VARIABLE_TRUE
    }

    private final String name;

    private State state;

    private final List<Clause> clauses = new LinkedList<>();

    public Variable(String name, State state) {
        this.name = name;
        this.state = state;
    }


    public Clause.State assign(State state) throws BCPException {
        if (this.state != State.VARIABLE_UNASSIGNED) {
            throw new BCPException("Variable state must be unassigned before it can be assigned: " + this.toString());
        }

        this.state = state;

        for (Clause clause: clauses) {
            Clause.State clauseState = clause.updateOnAssignment();
            if (clauseState == Clause.State.CLAUSE_UNSATISFIED) {
                return Clause.State.CLAUSE_UNSATISFIED;
            }
        }
        return Clause.State.CLAUSE_UNDECIDED;
    }


    public void unassign() {
        this.state = State.VARIABLE_UNASSIGNED;

        for (Clause clause: clauses) {
            clause.updateOnUnassignment();
        }
    };




    public String getName() {
        return name;
    }

    public List<Clause> getClauses() {
        return clauses;
    }

    public void addClause(Clause clause) {
        clauses.add(clause);
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Variable variable = (Variable) o;
        return Objects.equals(name, variable.name) && state == variable.state
            && Objects.equals(clauses, variable.clauses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, state, clauses);
    }

    @Override
    public String toString() {
        return this.name + " " + this.state.name();
    }
}
