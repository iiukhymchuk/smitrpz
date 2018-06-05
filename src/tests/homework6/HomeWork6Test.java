package tests.homework6;

import homework6.Processor;
import junit.framework.Assert;
import org.junit.Test;

public class HomeWork6Test {

    @Test
    public void addProductSummsUpAllProducts() {
        Processor processor = new Processor();
        processor.addProduct("product1", 3);
        processor.addProduct("product2", 1);
        processor.addProduct("product2", 2);
        processor.addProduct("product3", 5);
        processor.addProduct("product3", 5);
        processor.addProduct("product1", 1);
        processor.addProduct("product1", 2);

        int produc1Expected = processor.getPurchase().get("product1");
        int produc2Expected = processor.getPurchase().get("product2");
        int produc3Expected = processor.getPurchase().get("product3");

        Assert.assertEquals(produc1Expected, 6);
        Assert.assertEquals(produc2Expected, 3);
        Assert.assertEquals(produc3Expected, 10);

        processor.clearPurchase();
    }
}
