import java.util.Collections;
import java.util.List;

/**
 * Performs sorting of products
 * in descending order of Product Price.
 */
public class PriceSort
{
    public void sortByProductPrice(List<Product> productList)
    {
        try
        {
            Collections.sort(productList, new PriceComparator());


            System.out.println("\n===== Products Sorted by Price (Descending) =====");


            for(Product product : productList)
            {
                System.out.println(product);
            }
        }
        catch(NullPointerException e)
        {
            System.out.println("Product list is null.");
        }
        catch(Exception e)
        {
            System.out.println("Error : " + e.getMessage());
        }
    }
}