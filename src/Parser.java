import java.util.*;

public class Parser {

    public boolean isBalanced(String next) {
        if (next.trim().isEmpty()) return true;

        final HashMap<String, String> brackets = new HashMap<>();
        brackets.put(")", "(");
        brackets.put("}", "{");

        HashSet<String> openingBrackets = new HashSet<>(Arrays.asList("(", "{"));
        HashSet<String> closingBrackets = new HashSet<>(Arrays.asList("}", ")"));


        Stack<String> opened = new Stack<>();


        for (String bracket : next.split("")) {
            if (closingBrackets.contains(bracket) && opened.isEmpty()) return false;
            if (openingBrackets.contains(bracket))
                opened.push(bracket);
            else if (!opened.isEmpty() && closingBrackets.contains(bracket)) {
                if (brackets.get(bracket).equals(opened.peek())) opened.pop();
                else return false;
            }
        }

        return opened.isEmpty();
    }
}
