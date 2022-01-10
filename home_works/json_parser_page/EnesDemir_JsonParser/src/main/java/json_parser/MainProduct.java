package json_parser;
import product.Bilgiler;
import product.ProductData;
import java.io.IOException;

public class MainProduct {
    static NumberControl nc =new NumberControl();
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        int start = 0;
        int newStart = nc.control(start);
        try {
            ProductData productData = productService.productList(newStart);
            for (Bilgiler item : productData.getProducts().get(0).getBilgiler()) {
                System.out.println(item.getProductName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
