package controllers;

import dao.InvoiceDao;
import dao.ProductDao;
import dao.ProductInvoiceDao;
import dto.InvoiceDTO;
import dto.ProductDTO;
import dto.ProductInvoiceDTO;
import models.Invoice;
import models.Product;
import models.ProductInvoice;
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
    ProductDao productDao;

    @Inject
    ProductInvoiceDao productInvoiceDao;

    @Inject
    protected JPAApi jpaApi;

    @Transactional
    public Result create() {
//        ProductDTO productDTO = new ProductDTO(1L, "pan", 1.00);
//        Product product = new Product(productDTO);
//
//        InvoiceDTO invoiceDTO = new InvoiceDTO(10.00);
//        Invoice invoice = new Invoice(invoiceDTO);
//
//        ProductInvoiceDTO productInvoice = new ProductInvoiceDTO(4, invoice, product);
//        ProductInvoiceDTO productInvoice2 = new ProductInvoiceDTO(6,invoice, product);
//
//        List<ProductInvoiceDTO> productInvoices = new ArrayList<>();
//        productInvoices.add(productInvoice);
//        productInvoices.add(productInvoice2);
//
//        invoice.addProducts(productInvoices);
//        invoiceDao.create(invoice);
        return ok(create.render());
    }

    @Transactional
    public Result read() {
//        ProductDTO productDTO = new ProductDTO(1L, "pan", 1.00);
//        Product product = new Product(productDTO);
//
//        InvoiceDTO invoiceDTO = new InvoiceDTO(10.00);
//        Invoice invoice1 = new Invoice(invoiceDTO);
//
//        ProductInvoiceDTO productInvoice = new ProductInvoiceDTO(4, invoice1, product);
//        ProductInvoiceDTO productInvoice2 = new ProductInvoiceDTO(6,invoice1, product);
//
//        List<ProductInvoiceDTO> productInvoices = new ArrayList<>();
//        productInvoices.add(productInvoice);
//        productInvoices.add(productInvoice2);
//
//        invoice1.addProducts(productInvoices);
//        invoiceDao.create(invoice1);

        List<Invoice> invoiceList = invoiceDao.findAll();
        List<InvoiceDTO> invoiceDTOList = new ArrayList<>();
        for (Invoice invoice : invoiceList) {
            invoiceDTOList.add(new InvoiceDTO(invoice));
        }

        return ok(read.render(invoiceDTOList));
    }
    @Transactional
    public Result update() {

        return ok();
    }
    @Transactional
    public Result delete(Long id) {
        System.out.println(id);
        Invoice invoice = invoiceDao.findByPk(id);
        invoiceDao.delete(invoice);
        return redirect(routes.InvoiceController.read());
    }
    @Transactional
    public Result edit(Long id) {
        Invoice invoice = invoiceDao.findByPk(id);
        InvoiceDTO invoiceDTO = new InvoiceDTO(invoice);

        List<Product> products = productInvoiceDao.productsByInvoiceId(id);
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product: products) {
            productDTOS.add(new ProductDTO(product));
        }

        return ok(update.render(invoiceDTO,productDTOS));
    }
    @Transactional
    public Result show(Long id) {


        return ok(delete.render());
    }
}
