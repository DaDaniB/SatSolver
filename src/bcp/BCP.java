package bcp;

import dataTypes.Clause;
import dataTypes.Formula;
import dataTypes.Literal;
import dataTypes.Variable.State;
import exceptions.BCPException;
import java.util.List;
import java.util.Stack;

public class BCP {


    public static void bcp(Formula formula, Stack<Literal> trail, Literal unitClauseLiteral)
        throws BCPException {



        if (bcpOnUnitClauseLiteral(trail, unitClauseLiteral) == Clause.State.CLAUSE_UNSATISFIED) {
            formula.setState(Formula.State.FORMULA_UNSATISFIED);
            return;
        }

        List<Clause> unitClauses = formula.findUnitClauses();
        if (unitClauses.isEmpty()) {
            return;
        }

        for (Clause unitClause : unitClauses) {

            Clause.State clauseState = unitClause.getState();

            if (clauseState != Clause.State.CLAUSE_SATISFIED) {
                Literal unitLiteral = unitClause.getUnitLiteral();
                trail.push(unitLiteral);

                if (unitLiteral.isNegated()) {
                    clauseState = unitLiteral.getVariable().assign(State.VARIABLE_FALSE);
                } else {
                    clauseState = unitLiteral.getVariable().assign(State.VARIABLE_TRUE);
                }

                if (clauseState == Clause.State.CLAUSE_UNSATISFIED) {
                    formula.setState(Formula.State.FORMULA_UNSATISFIED);
                    return;
                }
            }
        }

        bcp(formula, trail, null);

    }

    private static Clause.State bcpOnUnitClauseLiteral(Stack<Literal> trail,
        Literal unitClauseLiteral) throws BCPException {

        if (unitClauseLiteral == null) return Clause.State.CLAUSE_SATISFIED;

        trail.push(unitClauseLiteral);

        Clause.State clauseState;
        if (unitClauseLiteral.isNegated()) {
            clauseState = unitClauseLiteral.getVariable().assign(State.VARIABLE_FALSE);
        } else {
            clauseState = unitClauseLiteral.getVariable().assign(State.VARIABLE_TRUE);
        }
        return clauseState;
    }
}
