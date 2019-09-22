package controllers;

import dao.InvoiceDao;
import dto.InvoiceDTO;
import dto.ProductDTO;
import dto.ProductInvoiceDTO;
import models.Invoice;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;

import javax.inject.Inject;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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
        ProductDTO productDTO = new ProductDTO();
        productDTO.productName = "pan";
        productDTO.itemPrice = 1.00;
        productDTO.productInvoiceDTOList = new ArrayList<>();

        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.invoiceDate= new Date();
        invoiceDTO.productInvoiceDTOList = new ArrayList<>();


        ProductInvoiceDTO productInvoiceDTO = new ProductInvoiceDTO();
        productInvoiceDTO.product = productDTO;
        productInvoiceDTO.invoice = invoiceDTO;
        productInvoiceDTO.amount = 4;
        productInvoiceDTO.price = productDTO.itemPrice * productInvoiceDTO.amount;

        invoiceDTO.totalPrice = productInvoiceDTO.price;
        productDTO.productInvoiceDTOList.add(productInvoiceDTO);
        invoiceDTO.productInvoiceDTOList.add(productInvoiceDTO);

        System.out.println(invoiceDTO.productInvoiceDTOList.get(0).price);

        Invoice invoice = new Invoice(invoiceDTO);
        invoiceDao.create(invoice);

        Query query = jpaApi.em().createQuery("Select * from  ");

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
