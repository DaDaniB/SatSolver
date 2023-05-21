package dataTypes;

import java.util.Objects;

public class Literal {

    public enum State {
        LITERAL_UNDECIDED, LITERAL_FALSE, LITERAL_TRUE
    }

    private final Variable variable;

    private boolean negated;

    public Literal(Variable variable, boolean negated) {
        this.variable = variable;
        this.negated = negated;
    }

    public Literal getNegatedCopy() {
        return new Literal(variable, !negated);
    }

    public Variable getVariable() {
        return variable;
    }

    public boolean isNegated() {
        return negated;
    }

    public State getState() {
        if (variable.getState() == Variable.State.VARIABLE_UNASSIGNED) {
            return State.LITERAL_UNDECIDED;
        } else if ((variable.getState() == Variable.State.VARIABLE_TRUE && !isNegated())
            || (variable.getState() == Variable.State.VARIABLE_FALSE && isNegated())) {
            return State.LITERAL_TRUE;
        }
        return State.LITERAL_FALSE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Literal literal = (Literal) o;
        return negated == literal.negated && Objects.equals(variable, literal.variable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variable, negated);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (negated) {
            sb.append("-");
        }
        sb.append(variable.getName());
        return sb.toString();
    }
}
