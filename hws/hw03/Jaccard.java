import java.io.*;
import java.util.*;

public class Jaccard {

    //TODO: put the targt test prefix here
    public static final String TARGET_PREFIX = "";

    public static Set<String> getWords(String line) {
        return new HashSet<>(Arrays.asList(line.split("\\s+"))); 
    }

    public static double jaccard(Set t1, Set t2) {
        //TODO: implement jaccard similarity score
    }

    public static void main(String[] args) throws FileNotFoundException {

        String filePath = "corpus.txt"; 
        String assertPath = "corpusAsserts.txt";

        Scanner scanner = new Scanner(new File(filePath));
        Scanner assertScanner = new Scanner(new File(assertPath));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String assertion = assertScanner.nextLine();

            Set<String> words = Jaccard.getWords(line);

            //TODO: create a data structure to store a set of words and its corresponding asertion. 
        }

        String retrievedAssertion = "";
        double bestSimilarity = 0;

        //TODO: Find the most similar document 
        for (/*each corpusAssertion,corpusTest in the corpus*/) {
            double similarity = Jaccard.jaccard(Jaccard.getWords(TARGET_PREFIX), corpusTest);
            
            if (similarity > bestSimilarity) {
                retrievedAssertion = corpusAssertion;
                bestSimilarity = similarity;
            }
        }

        System.out.println(retrievedAssertion);
    }
}
