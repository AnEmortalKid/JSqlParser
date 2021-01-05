package net.sf.jsqlparser.expression.operators.hierarchical;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.ExpressionVisitor;
import net.sf.jsqlparser.parser.ASTNodeAccessImpl;

public class ConnectByRootExpression extends ASTNodeAccessImpl implements Expression {

    private String connectBy;

    public ConnectByRootExpression() {
        // empty constructor
    }

    public ConnectByRootExpression(String connectByRoot) {
        this.connectBy = connectByRoot;
    }

    @Override
    public void accept(ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
    }

    public String getConnectBy() {
        return connectBy;
    }

    public void setConnectBy(String connectBy) {
        this.connectBy = connectBy;
    }

    @Override
    public String toString() {
        return "CONNECT_BY_ROOT " + connectBy;
    }

}
