import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculadora {

    public static void main(String[] args) {
        String[] expressoes = {
                "(2 + 3) * 4",
                "10 / 2 - 3",
                "3.5 * (2 + 1.5)",
                "8 + 2 * (3 - 1) / 4",
                "((1 + 2) * (3 + 4)) / 7"
        };

        for (String expr : expressoes) {
            List<String> tokens = tokenizar(expr);
            List<String> rpn = paraRPN(tokens);
            double resultado = calcularRPN(rpn);

            System.out.println("Infixa: " + expr);
            System.out.println("RPN: " + String.join(" ", rpn));
            System.out.println("Resultado: " + resultado);
            System.out.println();
        }
    }

    // tokenizar
    static List<String> tokenizar(String expr) {
        List<String> tokens = new ArrayList<>();
        String numero = "";

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (c == ' ') {
                continue;
            }

            if (Character.isDigit(c) || c == '.') {
                numero += c;
                continue;
            }

            if (numero.length() > 0) {
                tokens.add(numero);
                numero = "";
            }

            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                tokens.add(String.valueOf(c));
            }
        }

        if (numero.length() > 0) {
            tokens.add(numero);
        }

        return tokens;
    }

    static int precedencia(String op) {
        if (op.equals("+") || op.equals("-")) {
            return 1;
        }
        if (op.equals("*") || op.equals("/")) {
            return 2;
        }
        return 0;
    }

    static boolean isOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    static boolean isNumero(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // infixa pra RPN
    static List<String> paraRPN(List<String> tokens) {
        List<String> saida = new ArrayList<>();
        Stack<String> pilha = new Stack<>();

        for (String token : tokens) {
            if (isNumero(token)) {
                saida.add(token);
            } else if (isOperador(token)) {
                while (!pilha.isEmpty() && isOperador(pilha.peek()) && precedencia(pilha.peek()) >= precedencia(token)) {
                    saida.add(pilha.pop());
                }
                pilha.push(token);
            } else if (token.equals("(")) {
                pilha.push(token);
            } else if (token.equals(")")) {
                while (!pilha.peek().equals("(")) {
                    saida.add(pilha.pop());
                }
                pilha.pop();
            }
        }

        while (!pilha.isEmpty()) {
            saida.add(pilha.pop());
        }

        return saida;
    }

    // calcular RPN
    static double calcularRPN(List<String> rpn) {
        Stack<Double> pilha = new Stack<>();

        for (String token : rpn) {
            if (isNumero(token)) {
                pilha.push(Double.parseDouble(token));
            } else {
                double b = pilha.pop();
                double a = pilha.pop();

                if (token.equals("+")) pilha.push(a + b);
                if (token.equals("-")) pilha.push(a - b);
                if (token.equals("*")) pilha.push(a * b);
                if (token.equals("/")) pilha.push(a / b);
            }
        }

        return pilha.pop();
    }
}