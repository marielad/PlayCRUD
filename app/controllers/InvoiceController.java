package controllers;

import com.fasterxml.jackson.databind.JsonNode;
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

    private List<ProductInvoiceDTO> productInvoiceDTOList = new ArrayList<>();

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
    public Result edit(Long id) {
        Invoice invoice = invoiceDao.findByPk(id);
        InvoiceDTO invoiceDTO = new InvoiceDTO(invoice);

        List<ProductInvoice> productInvoices = productInvoiceDao.findByInvoiceId(id);
        List<ProductInvoiceDTO> productInvoiceDTOS = new ArrayList<>();
        for (ProductInvoice productInvoice: productInvoices) {
            productInvoiceDTOS.add(new ProductInvoiceDTO(productInvoice));
        }

        return ok(update.render(invoiceDTO,productInvoiceDTOS));
    }
    @Transactional
    public Result show(Long id) {
        Invoice invoice = invoiceDao.findByPk(id);
        InvoiceDTO invoiceDTO = new InvoiceDTO(invoice);

        List<ProductInvoice> productInvoices = productInvoiceDao.findByInvoiceId(id);
        List<ProductInvoiceDTO> productInvoiceDTOS = new ArrayList<>();
        for (ProductInvoice productInvoice: productInvoices) {
            productInvoiceDTOS.add(new ProductInvoiceDTO(productInvoice));
        }

        return ok(show.render(invoiceDTO,productInvoiceDTOS));
    }

    @Transactional
    public Result editOne() {
        JsonNode json = request().body().asJson();
        Long id = json.findPath("productInvoiceId").asLong();
        int value = json.findPath("value").asInt();

        ProductInvoiceDTO productInvoiceDTO = new ProductInvoiceDTO(productInvoiceDao.findById(id));
        productInvoiceDTO.amount = value;
        productInvoiceDTO.price = productInvoiceDTO.getPrice(productInvoiceDTO.product, productInvoiceDTO.amount);

        productInvoiceDTOList.add(productInvoiceDTO);

        System.out.println(productInvoiceDTO.productInvoiceId + " price " +productInvoiceDTO.price+" amount "+productInvoiceDTO.amount);
        return ok();
    }

    @Transactional
    public Result update() {
        System.out.println("update");

        if (productInvoiceDTOList.isEmpty()){
            System.out.println("Nothing to update");
        }else{
            for (ProductInvoiceDTO productInvoiceDTO: productInvoiceDTOList) {
                ProductInvoice productInvoice = productInvoiceDao.findById(productInvoiceDTO.productInvoiceId);
                productInvoice.amount = productInvoiceDTO.amount;
                productInvoice.price = productInvoiceDTO.price;
                System.out.println(productInvoice.productInvoiceId + " price " +productInvoice.price+" amount "+productInvoice.amount);
            }
            System.out.println("Updateo done");
            productInvoiceDTOList.clear();
        }
        return redirect(routes.InvoiceController.read());
    }
    @Transactional
    public Result delete(Long id) {
        System.out.println(id);
        Invoice invoice = invoiceDao.findByPk(id);
        invoiceDao.delete(invoice);
        return redirect(routes.InvoiceController.read());
    }

    @Transactional
    public Result cart() {
        System.out.println("cart");

        return ok(create.render());
    }
    @Transactional
    public Result shop() {
        System.out.println("shop");

        List<Product> productList = productDao.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();

        for (Product product: productList) {
            productDTOS.add(new ProductDTO(product));
        }
        return ok(index.render(productDTOS));
    }
}
