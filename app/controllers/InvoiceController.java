package controllers;

import dao.InvoiceDao;
import dao.ProductDao;
import dto.ProductInvoiceDTO;
import models.Invoice;
import models.Product;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class InvoiceController extends Controller {

    @Inject
    InvoiceDao invoiceDao;

    @Inject
    protected JPAApi jpaApi;

    @Transactional
    public Result create() { 
        System.out.println("Create");
        return ok(create.render());
    }

    @Transactional
    public Result read() {
        Product product = new Product(1L, "pan", 1.00);
        Invoice invoice = new Invoice();

        ProductInvoiceDTO productInvoice = new ProductInvoiceDTO(4, invoice, product);
        ProductInvoiceDTO productInvoice2 = new ProductInvoiceDTO(2,invoice, product);

        List<ProductInvoiceDTO> productInvoices = new ArrayList<>();
        productInvoices.add(productInvoice);
        productInvoices.add(productInvoice2);

        invoice.addProducts(productInvoices);
        invoiceDao.create(invoice);

        return ok(read.render());
    }
    @Transactional
    public Result update() { 
        return ok(update.render());
    }
    @Transactional
    public Result delete(int id) { 
        return ok(delete.render());
    }
}
