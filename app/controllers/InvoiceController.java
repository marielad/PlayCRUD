package controllers;

import play.mvc.*;

public class InvoiceController extends Controller {
    public Result index() { return ok(views.html.index.render());}
    public Result create() { return ok(views.html.index.render());}
    public Result read() { return ok(views.html.index.render());}
    public Result update() { return ok(views.html.index.render());}
    public Result delete(int id) { return ok(views.html.index.render());}
}
