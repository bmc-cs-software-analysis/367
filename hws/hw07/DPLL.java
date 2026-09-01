import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class DPLL {

    public static boolean dpll(List<List<String>> clauses, Map<String, Boolean> assignment) {
        // TODO: Implement the DPLL algorithm here
        return false; 
    }

    public static List<List<String>> unitPropogation(List<List<String>> clauses, Map<String, Boolean> assignment) {
        // TODO
        return clauses;
    }

    public static boolean isClauseSatisfied(List<String> clause, Map<String, Boolean> assignment) {
        // TODO
        return false;
    }

    public static boolean isFormulaSatisfied(List<List<String>> clauses, Map<String, Boolean> assignment) {
        // TODO
        return false;
    }



    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java DPLL <input-file>");
            return;
        }

        String filename = args[0];
        List<List<String>> clauses = new ArrayList<>();
        Set<String> variables = new HashSet<>();

        // Read the CNF file in the new format
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] rawClauses = line.split("\\) \\(");
                for (String rawClause : rawClauses) {
                    rawClause = rawClause.replace("(", "").replace(")", "").trim();
                    List<String> clause = Arrays.asList(rawClause.split("\\s+"));
                    clauses.add(clause);
                    for (String literal : clause) {
                        variables.add(literal.replace("~", ""));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Call the DPLL algorithm
        Map<String, Boolean> assignment = new HashMap<>();
        boolean satisfiable = dpll(clauses, assignment);

        if (satisfiable) {
            System.out.println("SATISFIABLE");
            System.out.println("Assignment: " + assignment);
        } else {
            System.out.println("UNSATISFIABLE");
        }
    }
}
