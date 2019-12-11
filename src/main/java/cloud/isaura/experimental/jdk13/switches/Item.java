package cloud.isaura.experimental.jdk13.switches;

public class Item {

    private String productCode;
    private Long quantity;
    private Double price;

    public Item(String productCode, Long quantity, Double price)
    {
        this.productCode = productCode;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductCode()
    {
        return productCode;
    }

    public Long getQuantity()
    {
        return quantity;
    }

    public Double getPrice()
    {
        return price;
    }
}
