package cloud.isaura.experimental.jdk13.switches;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Invoice {

    private Double totalPrice;
    private String holder;
    private Customer customerType;
    private List<Item> itemList;

    public Double getTotalPrice()
    {

        BigDecimal bd = new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void setTotalPrice(Double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public String getHolder()
    {
        return holder;
    }

    public void setHolder(String holder)
    {
        this.holder = holder;
    }

    public Customer getCustomerType()
    {
        return customerType;
    }

    public void setCustomerType(Customer customerType)
    {
        this.customerType = customerType;
    }

    public List<Item> getItemList()
    {
        return itemList;
    }

    public void setItemList(List<Item> itemList)
    {
        this.itemList = itemList;
    }
}
