package br.com.lox;

public class Main {
    public static void main(String[] args) {

        String source = """
            1 + 2 * (3 - 4);
            """;

        Scanner scanner = new Scanner(source);
        var tokens = scanner.scanTokens();

        Parser parser = new Parser(tokens);
        Expr expression = parser.parse();

        Interpreter interpreter = new Interpreter();
        interpreter.interpret(expression);  // <<< NÃO retorna, apenas executa

        System.out.println("Execução concluída.");
    }
}
