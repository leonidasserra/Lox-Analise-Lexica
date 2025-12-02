package br.com.lox;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String source = """
                var a = 1;
                var b = 2;

                print a + b;

                if (a < b) {
                    print "a menor que b";
                } else {
                    print "a maior ou igual a b";
                }

                var i = 0;
                while (i < 3) {
                    print i;
                    i = i + 1;
                }

                for (var j = 0; j < 3; j = j + 1) {
                    print j * 10;
                }
                """;

        // Executa o Lox
        run(source);
    }

    private static void run(String source) {
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        Parser parser = new Parser(tokens);
        List<Stmt> statements = parser.parse();

        Interpreter interpreter = new Interpreter();
        interpreter.interpret(statements);
    }
}
