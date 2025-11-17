package br.com.lox;

public class Main {
    public static void main(String[] args) {

        String source = """
            1 + 2 * (3 - 4) == 5;
            """;

        Scanner scanner = new Scanner(source);
        var tokens = scanner.scanTokens();

        Parser parser = new Parser(tokens);
        Expr expr = parser.parse();

        AstPrinter printer = new AstPrinter();
        System.out.println(printer.print(expr));
    }

}
