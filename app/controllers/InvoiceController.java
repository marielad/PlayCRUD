package controllers;

import dao.InvoiceDao;
import dto.InvoiceDTO;
import models.Invoice;
import play.mvc.*;
import views.html.*;

import javax.inject.Inject;
import java.util.List;

public class InvoiceController extends Controller {

    @Inject
    InvoiceDao invoiceDao;

    public Result create() { 
        System.out.println("Create");
        return ok(create.render());
    }
    public Result read() {
//        List<InvoiceDTO> invoiceDTOList = invoiceDao.findAll();
        return ok(read.render());
    }
    public Result update() { 
        return ok(update.render());
    }
    public Result delete(int id) { 
        return ok(delete.render());
    }
}
