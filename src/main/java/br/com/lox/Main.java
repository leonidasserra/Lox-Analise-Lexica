package br.com.lox;

public class Main {
    public static void main(String[] args) {
        String source = """
            var nome = "João";
            var idade = 22;
            if (idade >= 18) {
                print nome;
            } else {
                print "Menor de idade";
            }
            """;

        Scanner scanner = new Scanner(source);
        var tokens = scanner.scanTokens();

        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}
