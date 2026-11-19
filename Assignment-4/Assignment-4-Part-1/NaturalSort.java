import java.util.Collections;
import java.util.List;

/**
 * This class performs natural sorting
 * of products based on Product Code.
 */
public class NaturalSort
{
    /**
     * Sorts products in ascending order
     * using Comparable interface.
     *
     * @param productList List of products
     */
    public void sortByProductCode(List<Product> productList)
    {
        try
        {
            Collections.sort(productList);
            System.out.println("\n===== Natural Sorting (Product Code) =====");

            for(Product product : productList)
            {
                System.out.println(product);
            }
        }
        catch(NullPointerException e)
        {
            System.out.println("Product list cannot be null.");
        }
        catch(Exception e)
        {
            System.out.println("Error : " + e.getMessage());
        }
    }
}