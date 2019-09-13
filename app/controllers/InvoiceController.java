package controllers;

import dto.InvoiceDTO;
import dto.ProductDTO;
import models.Product;
import play.mvc.*;
import views.html.*;

public class InvoiceController extends Controller {
    public Result create() { 
        System.out.println("Create");
        return ok(create.render());
    }
    public Result read() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(1L);
        productDTO.setProductName("Epa");
        productDTO.setItemPrice(10.00);

        InvoiceDTO invoiceDTO = new InvoiceDTO();

        return ok(read.render());
    }
    public Result update() { 
        return ok(update.render());
    }
    public Result delete(int id) { 
        return ok(delete.render());
    }
}
