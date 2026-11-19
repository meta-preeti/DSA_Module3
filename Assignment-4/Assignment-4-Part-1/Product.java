/**
 * Product class represents a product with
 * product code, product name and product price.
 *
 * Natural ordering is based on productCode.
 */


public class Product implements Comparable<Product>
{
    private int productCode;
    private String productName;
    private double productPrice;
    /**
     * Parameterized Constructor
     */
    public Product(int productCode, String productName, double productPrice)
    {
        if(productCode <= 0)
        {
            throw new IllegalArgumentException("Product code must be greater than zero.");
        }


        if(productName == null || productName.trim().isEmpty())
        {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }

        if(productPrice < 0)
        {
            throw new IllegalArgumentException("Product price cannot be negative.");
        }

        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
    }


    // Getter Methods


    public int getProductCode()
    {
        return productCode;
    }

    public String getProductName()
    {
        return productName;
    }

    public double getProductPrice()
    {
        return productPrice;
    }


    /**
     * Natural Sorting
     * Sort products according to Product Code
     */
    @Override
    public int compareTo(Product otherProduct)
    {
        return Integer.compare(this.productCode,
                               otherProduct.productCode);
    }

    /**
     * Two Products are equal
     * if Product Code is same.
     */
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }

        if(obj == null || getClass() != obj.getClass())
        {
            return false;
        }

        Product otherProduct = (Product)obj;
        return this.productCode == otherProduct.productCode;
    }


    /**
     * Hash Code based on Product Code
     */
    @Override
    public int hashCode()
    {
        return Integer.hashCode(productCode);
    }


    /**
     * Display Product Details
     */
    @Override
    public String toString()
    {
        return "Product Code : " + productCode +
               "\nProduct Name : " + productName +
               "\nProduct Price : " + productPrice +
               "\n--------------------------------";
    }
}