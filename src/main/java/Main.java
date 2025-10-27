public class Main {
    public static void main(String[] args) {
        String source = "( ){ } + - * ;";
        Scanner scanner = new Scanner(source);
        for (Token token : scanner.scanTokens()) {
            System.out.println(token);
        }
    }
}
