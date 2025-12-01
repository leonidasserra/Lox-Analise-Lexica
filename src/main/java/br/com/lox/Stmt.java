package br.com.lox;

public abstract class Stmt {
    public interface Visitor<R> {
        R visitExpressionStmt(Expression stmt);
        R visitPrintStmt(Print stmt);
        R visitVarStmt(Var stmt);
        R visitBlockStmt(Block stmt); // placeholder, Block implemented in commit 4
    }

    public static class Expression extends Stmt {
        public final Expr expression;
        public Expression(Expr expression) { this.expression = expression; }
        @Override <R> R accept(Visitor<R> visitor) { return visitor.visitExpressionStmt(this); }
    }

    public static class Print extends Stmt {
        public final Expr expression;
        public Print(Expr expression) { this.expression = expression; }
        @Override <R> R accept(Visitor<R> visitor) { return visitor.visitPrintStmt(this); }
    }

    public static class Var extends Stmt {
        public final Token name;
        public final Expr initializer;
        public Var(Token name, Expr initializer) { this.name = name; this.initializer = initializer; }
        @Override <R> R accept(Visitor<R> visitor) { return visitor.visitVarStmt(this); }
    }

    // Block class placeholder — will be replaced in commit 4 with full implementation
    public static class Block extends Stmt {
        public final java.util.List<Stmt> statements;
        public Block(java.util.List<Stmt> statements) { this.statements = statements; }
        @Override <R> R accept(Visitor<R> visitor) { return visitor.visitBlockStmt(this); }
    }

    abstract <R> R accept(Visitor<R> visitor);
}
