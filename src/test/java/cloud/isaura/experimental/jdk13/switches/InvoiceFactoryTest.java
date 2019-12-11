package cloud.isaura.experimental.jdk13.switches;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InvoiceFactoryTest {


    @Test
    public void when_computing_invoice_price_old_way_for_simple_customer_then_total_price_equals_to_invoice_price() throws Exception
    {
        String holder = "John Doe";
        List<Item> items = new ArrayList<>();
        items.add(new Item("c01",1L,80d));
        items.add(new Item("c02",1L,3d));
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        Invoice invoiceOldWay = invoiceFactory.createInvoiceOldWay(holder, Customer.SIMPLE, items);
        Assert.assertThat(invoiceOldWay.getTotalPrice(),CoreMatchers.is(CoreMatchers.equalTo(83d)));

    }


    @Test
    public void when_computing_invoice_price_for_simple_customer_then_total_price_equals_to_invoice_price() throws Exception
    {
        String holder = "John Doe";
        List<Item> items = new ArrayList<>();
        items.add(new Item("c01",1L,80d));
        items.add(new Item("c02",1L,3d));
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        Invoice invoice = invoiceFactory.createInvoice(holder, Customer.SIMPLE, items);
        Assert.assertThat(invoice.getTotalPrice(),CoreMatchers.is(CoreMatchers.equalTo(83d)));

    }

    @Test
    public void when_computing_invoice_price_old_way_for_business_customer_then_total_price_equals_to_invoice_price_plus_vat() throws Exception
    {
        String holder = "John Doe";
        List<Item> items = new ArrayList<>();
        items.add(new Item("c01",1L,80d));
        items.add(new Item("c02",1L,3d));
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        Invoice invoiceOldWay = invoiceFactory.createInvoiceOldWay(holder, Customer.BUSINESS, items);
        Assert.assertThat(invoiceOldWay.getTotalPrice(),CoreMatchers.is(CoreMatchers.equalTo(101.26d)));

    }

    @Test
    public void when_computing_invoice_price_for_business_customer_then_total_price_equals_to_invoice_price_plus_vat() throws Exception
    {
        String holder = "John Doe";
        List<Item> items = new ArrayList<>();
        items.add(new Item("c01",1L,80d));
        items.add(new Item("c02",1L,3d));
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        Invoice invoice = invoiceFactory.createInvoice(holder, Customer.BUSINESS, items);
        Assert.assertThat(invoice.getTotalPrice(),CoreMatchers.is(CoreMatchers.equalTo(101.26d)));

    }

    @Test
    public void when_computing_invoice_price_lt_100_old_way_for_privileged_customer_then_total_price_equals_to_invoice_price_plus_vat_minus_standard_discount() throws Exception
    {
        String holder = "John Doe";
        List<Item> items = new ArrayList<>();
        items.add(new Item("c01",1L,80d));
        items.add(new Item("c02",1L,3d));
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        Invoice invoiceOldWay = invoiceFactory.createInvoiceOldWay(holder, Customer.PRIVILIGED, items);
        Assert.assertThat(invoiceOldWay.getTotalPrice(),CoreMatchers.is(CoreMatchers.equalTo(92.96d)));

    }


    @Test
    public void when_computing_invoice_price_lt_100_for_privileged_customer_then_total_price_equals_to_invoice_price_plus_vat_minus_standard_discount() throws Exception
    {
        String holder = "John Doe";
        List<Item> items = new ArrayList<>();
        items.add(new Item("c01",1L,80d));
        items.add(new Item("c02",1L,3d));
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        Invoice invoice = invoiceFactory.createInvoice(holder, Customer.PRIVILIGED, items);
        Assert.assertThat(invoice.getTotalPrice(),CoreMatchers.is(CoreMatchers.equalTo(92.96d)));

    }


    @Test
    public void when_computing_invoice_price_gt_100_old_way_for_privileged_customer_then_total_price_equals_to_invoice_price_plus_vat_minus_standard_and_low_discount() throws Exception
    {
        String holder = "John Doe";
        List<Item> items = new ArrayList<>();
        items.add(new Item("c01",1L,80d));
        items.add(new Item("c03",1L,90d));
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        Invoice invoiceOldWay = invoiceFactory.createInvoiceOldWay(holder, Customer.PRIVILIGED, items);
        Assert.assertThat(invoiceOldWay.getTotalPrice(),CoreMatchers.is(CoreMatchers.equalTo(180.88d)));

    }

    @Test
    public void when_computing_invoice_price_gt_100_for_privileged_customer_then_total_price_equals_to_invoice_price_plus_vat_minus_standard_and_low_discount() throws Exception
    {
        String holder = "John Doe";
        List<Item> items = new ArrayList<>();
        items.add(new Item("c01",1L,80d));
        items.add(new Item("c03",1L,90d));
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        Invoice invoice = invoiceFactory.createInvoice(holder, Customer.PRIVILIGED, items);
        Assert.assertThat(invoice.getTotalPrice(),CoreMatchers.is(CoreMatchers.equalTo(180.88d)));

    }

    @Test
    public void when_computing_invoice_price_gt_600_old_way_for_privileged_customer_then_total_price_equals_to_invoice_price_plus_vat_minus_standard_and_strong_discount() throws Exception
    {
        String holder = "John Doe";
        List<Item> items = new ArrayList<>();
        items.add(new Item("c01",1L,400d));
        items.add(new Item("c03",1L,390d));
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        Invoice invoiceOldWay = invoiceFactory.createInvoiceOldWay(holder, Customer.PRIVILIGED, items);
        Assert.assertThat(invoiceOldWay.getTotalPrice(),CoreMatchers.is(CoreMatchers.equalTo(840.56d)));

    }

    @Test
    public void when_computing_invoice_price_gt_600_for_privileged_customer_then_total_price_equals_to_invoice_price_plus_vat_minus_standard_and_strong_discount() throws Exception
    {
        String holder = "John Doe";
        List<Item> items = new ArrayList<>();
        items.add(new Item("c01",1L,400d));
        items.add(new Item("c03",1L,390d));
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        Invoice invoice = invoiceFactory.createInvoiceOldWay(holder, Customer.PRIVILIGED, items);
        Assert.assertThat(invoice.getTotalPrice(),CoreMatchers.is(CoreMatchers.equalTo(840.56d)));

    }


}
