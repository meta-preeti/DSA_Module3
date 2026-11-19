import java.util.Comparator;

/**
 * Comparator class to sort Products
 * in descending order of Product Price.
 */
public class PriceComparator implements Comparator<Product>
{
    @Override
    public int compare(Product product1, Product product2)
    {
        return Double.compare(product2.getProductPrice(),
                              product1.getProductPrice());
    }


}