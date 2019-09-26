package dao.impl;

import dao.ProductInvoiceDao;
import models.Product;
import models.ProductInvoice;
import play.Logger;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.Query;
import java.util.List;

import static org.springframework.core.GenericTypeResolver.resolveTypeArguments;

public class ProductInvoiceDaoImpl implements ProductInvoiceDao {

    @Inject
    protected JPAApi jpaApi;

    @Override
    public List<ProductInvoice> findAll() {
        Query query = jpaApi.em().createQuery("from ProductInvoice");
        return query.getResultList();
    }

    @Override
    public List<ProductInvoice> findByInvoiceId(Long id) {
        Query query = jpaApi.em().createQuery("from ProductInvoice where invoice_id= :id").setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<Product> productsByInvoiceId(Long id) {
        Query query = jpaApi.em().createQuery("SELECT product from ProductInvoice where invoice_id= :id").setParameter("id", id);
        return query.getResultList();
    }
}
