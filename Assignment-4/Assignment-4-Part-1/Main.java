import java.util.ArrayList;
import java.util.List;


public class Main
{
    public static void main(String[] args)
    {
        try
        {
            List<Product> productList = new ArrayList<>();
            // Adding Products
            productList.add(new Product(103, "Mouse", 700));
            productList.add(new Product(101, "Laptop", 65000));
            productList.add(new Product(105, "Monitor", 12000));
            productList.add(new Product(102, "Keyboard", 1500));
            productList.add(new Product(104, "Speaker", 3500));

            // Duplicate Product
            productList.add(new Product(101, "Laptop", 65000));

            // Program 1 : Natural Sorting
            NaturalSort naturalSort = new NaturalSort();
            naturalSort.sortByProductCode(productList);

            // Program 2 : Price Sorting
            PriceSort priceSort = new PriceSort();
            priceSort.sortByProductPrice(productList);

            // Program 3 : Duplicate Removal
            DuplicateProduct duplicateProduct = new DuplicateProduct();
            duplicateProduct.displayUniqueProducts(productList);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid Product Data : " + e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Unexpected Error : " + e.getMessage());
        }
    }
}