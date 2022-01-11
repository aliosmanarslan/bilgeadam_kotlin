package json_parser;

import product.Bilgiler;
import product.ProductData;


public class MainProduct {
    public static void main(String[] args) {
        ProductService pService = new ProductService();

        DataCheck gelenVeriler = new DataCheck();
        int start = gelenVeriler.CheckData();

        try {
            ProductData pr = pService.productResult(String.valueOf(start));
            for (Bilgiler item : pr.getProducts().get(0).getBilgiler()) {
                System.out.println(item.getProductName());
            }
        } catch (Exception ex) {
            System.err.println("Error : " + ex);
        }
    }
}
