import java.util.HashMap;
import java.util.HashSet;


/**
 * This class counts distinct words in a sentence
 * and stores previous results using HashMap (Cache).
 */
public class WordCounter
{
    // Cache to store previously processed sentences
    private HashMap<String, Integer> cache;
    /**
     * Constructor
     * Initializes the HashMap.
     */
    public WordCounter()
    {
        cache = new HashMap<>();
    }

    /**
     * Counts the number of distinct words
     * in the given sentence.
     */
   public int countDistinctWords(String sentence)
{
    try
    {
        // Check for null or empty sentence
        if(sentence == null || sentence.trim().isEmpty())
        {
            throw new IllegalArgumentException("Sentence cannot be null or empty.");
        }

        // Check if result is already available in cache
        if(cache.containsKey(sentence))
        {
            System.out.println("Result fetched from cache.");
            return cache.get(sentence);
        }


        // Create HashSet to store distinct words
        HashSet<String> uniqueWords = new HashSet<>();

        // Split sentence into words
        String[] words = sentence.split("\\s+");


        for(String word : words)
        {
            // Convert to lowercase
            word = word.toLowerCase();

            // Remove leading and trailing punctuation
            word = word.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "");

            // Ignore empty words
            if(!word.isEmpty())
            {
                uniqueWords.add(word);
            }
        }

        // Count distinct words
        int count = uniqueWords.size();


        // Store result in cache
        cache.put(sentence, count);

        return count;
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
        return 0;
    }
}
}