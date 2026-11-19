import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Removes duplicate products
 * based on Product Code.
 */
public class DuplicateProduct
{
    /**
     * Displays only unique products.
     *
     * @param productList List of products
     */
    public void displayUniqueProducts(List<Product> productList)
    {
        try
        {
            Set<Product> uniqueProducts = new HashSet<>(productList);
            System.out.println("\n===== Unique Products =====");
            for(Product product : uniqueProducts)
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