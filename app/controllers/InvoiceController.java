package controllers;

import play.mvc.*;
import views.html.*;

public class InvoiceController extends Controller {
    public Result create() { 
        System.out.println("Create");
        return ok(create.render());
    }
    public Result read() { 
        return ok(read.render());
    }
    public Result update() { 
        return ok(update.render());
    }
    public Result delete(int id) { 
        return ok(delete.render());
    }
}
