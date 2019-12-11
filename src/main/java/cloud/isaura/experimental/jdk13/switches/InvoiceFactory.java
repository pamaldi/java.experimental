package cloud.isaura.experimental.jdk13.switches;


import java.util.List;

public class InvoiceFactory {

    private final static Double STANDARD_VAT = 22d;
    private final static Double STANDARD_DISCOUNT = 10d;
    private final static Double LOW_DISCOUNT = 5d;
    private final static Double STRONG_DISCOUNT = 5d;


    public Invoice createInvoice(String holder, Customer customerType, List<Item> items) throws Exception
    {
        Invoice invoice = fillHolderAndItems(holder, items);
        invoice.setTotalPrice(computeFinalPrice(customerType, invoice.getItemList()));
        return invoice;
    }

    public Invoice createInvoiceOldWay(String holder, Customer customerType, List<Item> items) throws Exception
    {
        Invoice invoice = fillHolderAndItems(holder, items);
        invoice.setTotalPrice(computeFinalPriceOldWay(customerType, invoice.getItemList()));
        return invoice;
    }


    private Double computeFinalPrice(Customer customerType, List<Item> items)
    {
        Double totalPrice = items.stream().map(item -> item.getPrice()).reduce(0d, Double::sum);
        Double vat = (totalPrice / 100 * STANDARD_VAT);
        Double invoicePrice = switch (customerType)
                {
                    case SIMPLE -> {
                        yield totalPrice;
                    }
                    case BUSINESS, PRIVATE -> {
                        Double finalPrice = totalPrice + vat;

                        yield finalPrice;
                    }
                    case PRIVILIGED -> {
                        Double discount = (totalPrice / 100 * STANDARD_DISCOUNT);
                        Double finalPrice = totalPrice + vat - discount;
                        Integer finalPriceOver = (int) Math.round(finalPrice / 100d);
                        finalPrice = switch (finalPriceOver)
                                {
                                    case 0,1 -> finalPrice;
                                    case 2, 3, 4, 5, 6 -> finalPrice - (finalPrice / 100 * LOW_DISCOUNT);
                                    default -> finalPrice - (finalPrice / 100 * STRONG_DISCOUNT);
                                };
                        yield finalPrice;

                    }
                };
        return invoicePrice;

    }



    private Double computeFinalPriceOldWay(Customer customerType, List<Item> items)
    {
        Double totalPrice = items.stream().map(item -> item.getPrice()).reduce(0d, Double::sum);
        Double vat = (totalPrice / 100 * STANDARD_VAT);
        Double invoicePrice = null;
        switch (customerType)
        {
            case SIMPLE:
                invoicePrice = totalPrice;
                break;
            case BUSINESS:
            case PRIVATE:

                    Double finalPrice = totalPrice + vat;
                    invoicePrice = finalPrice;
                    break;

            case PRIVILIGED:
                Double discount =  (totalPrice / 100 * STANDARD_DISCOUNT);
                Double finalPricePrivileged = totalPrice + vat - discount;
                Integer finalPriceOver = (int) Math.round(finalPricePrivileged / 100d);
                switch (finalPriceOver)
                {
                    case 1:
                        invoicePrice = finalPricePrivileged;break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        invoicePrice = finalPricePrivileged - (finalPricePrivileged / 100 * LOW_DISCOUNT);break;

                    default:
                        invoicePrice = finalPricePrivileged - (finalPricePrivileged / 100 * STRONG_DISCOUNT);
                }
                ;


        }
        return invoicePrice;

    }

    private Invoice fillHolderAndItems(String holder, List<Item> items)
    {
        Invoice invoice = new Invoice();
        invoice.setItemList(items);
        invoice.setHolder(holder);
        return invoice;
    }

}
