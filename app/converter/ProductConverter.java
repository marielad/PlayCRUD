package converter;

import dto.ProductDTO;
import models.Product;

public class ProductConverter {

    public static Product dtoToEntity(ProductDTO productDto) {
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setItemPrice(productDto.getItemPrice());
//        product.setProductInvoices(productDto.get);
        return product;
    }
}
