package parser;

import dataTypes.Clause;
import dataTypes.Clause.State;
import dataTypes.Formula;
import dataTypes.Literal;
import dataTypes.Variable;
import exceptions.FileFormatException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import parser.utils.ParserUtils;

public class Parser {

    private final List<Clause> clauses = new LinkedList<>();

    private final List<Variable> variables = new LinkedList<>();

    public void parse(String fileName) throws IOException, FileFormatException {
        parseLines(ParserUtils.readFile(fileName));
    }

    private void parseLines(List<String> lines) throws FileFormatException {
        checkFirstLineAndRemoveIt(lines);
        parseClauseLines(lines);
    }

    private void checkFirstLineAndRemoveIt(List<String> data) throws FileFormatException {
        String firstLine = data.get(0);
        System.out.println(data.get(0));
        if (!firstLine.startsWith("p cnf")) {
            throw new FileFormatException("Incorrect first Line: " + firstLine);
        }

        ParserUtils.removeLineFromList(data, 0);
    }

    private void parseClauseLines(List<String> clauseLines) {

        for (String unparsedClause : clauseLines) {
            List<Literal> literals = new LinkedList<>();

            String[] splittedClause = unparsedClause.split(" ");
            splittedClause = ParserUtils.removeLineSeperator(splittedClause);

            for (String unparsedLiteral : splittedClause) {
                parseLiteral(unparsedLiteral, literals);
            }

            clauses.add(new Clause(literals));
        }
    }

    private void parseLiteral(String unparsedLiteral, List<Literal> literals) {
        boolean negated = unparsedLiteral.startsWith("-");
        if (negated) unparsedLiteral = ParserUtils.removeFirstCharFromString(unparsedLiteral);

        Variable v = getVariableOrCreate(unparsedLiteral);

        Literal l = new Literal(v, negated);
        literals.add(l);
    }

    private Variable getVariableOrCreate(String unparsedLiteral) {
        Variable newVariable = null;

        for (Variable variable: variables) {
            if (variable.getName().equals(unparsedLiteral)) {
                newVariable = variable;
            }
        }

        if (newVariable == null) {
            newVariable = new Variable(unparsedLiteral, Variable.State.VARIABLE_UNASSIGNED);
            variables.add(newVariable);
        }

        return newVariable;
    }

    public void checkAndSetIfUnitClause(Clause clause) {
        if (clause.getLiterals().size() == 1) {
            clause.setState(State.CLAUSE_UNIT);
            clause.setUnitLiteral(clause.getLiterals().get(0));
        }
    }


    public List<Clause> getClauses() {
        return clauses;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public Formula getFormula() {
        return new Formula(clauses, variables);
    }
}
