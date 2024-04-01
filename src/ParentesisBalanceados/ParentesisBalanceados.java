package ParentesisBalanceados;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ParentesisBalanceados {

    public static boolean checkBalance(String s) {
        HashMap<Character, Character> parentesis = new HashMap<>();
        parentesis.put('(', ')');
        parentesis.put('[', ']');
        parentesis.put('{', '}');

        Stack<Character> balanceador = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                balanceador.push(s.charAt(i));
            } else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (balanceador.isEmpty() || s.charAt(i) != parentesis.get(balanceador.peek())) {
                    return false;
                } else {
                    balanceador.pop();
                }
            }
        }
        return balanceador.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(checkBalance("()"));
        System.out.println(checkBalance("()[]{}"));
        System.out.println(checkBalance("(]"));
        System.out.println(checkBalance("([)]"));
        System.out.println(checkBalance("{[]}"));
    }

}
