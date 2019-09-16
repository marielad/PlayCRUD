package controllers;

import models.Invoice;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;

import javax.inject.Inject;
import javax.persistence.Query;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    @Inject
    protected JPAApi jpaApi;

    @Transactional
    public Result index() {
        Query query = jpaApi.em().createQuery("from Invoice");
        List<Invoice> invoiceList = query.getResultList();
        System.out.println(invoiceList);
        return ok(index.render());
    }

}
