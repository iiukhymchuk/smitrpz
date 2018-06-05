package homework6;

import java.util.HashMap;

public class Processor {
    private static HashMap<String, Integer> purchase = new HashMap<>();

    public void addProduct(String productCode, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException();
        }

        if(purchase.containsKey(productCode)) {
            purchase.put(productCode, purchase.get(productCode) + count);
        }
        else {
            purchase.put(productCode, count);
        }
    }


    public HashMap<String, Integer> getPurchase() {
        return purchase;
    }

    public void clearPurchase() {
        purchase = new HashMap<>();
    }


}
