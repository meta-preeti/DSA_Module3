public class Main
{
    public static void main(String[] args)
    {
        try
        {
            WordCounter wordCounter = new WordCounter();


            String sentence1 = "Java, java JAVA Python Python!";
            String sentence2 = "Java is Easy.";
            String sentence3 = "Java, java JAVA Python Python!";


            System.out.println("Sentence 1 : " + sentence1);
            System.out.println("Distinct Words : "
                    + wordCounter.countDistinctWords(sentence1));


            System.out.println();


            System.out.println("Sentence 2 : " + sentence2);
            System.out.println("Distinct Words : "
                    + wordCounter.countDistinctWords(sentence2));


            System.out.println();


            System.out.println("Sentence 3 : " + sentence3);
            System.out.println("Distinct Words : "
                    + wordCounter.countDistinctWords(sentence3));
        }
        catch(Exception e)
        {
            System.out.println("Error : " + e.getMessage());
        }
    }
}