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
        Query query = jpaApi.em().createQuery("Select * from ProductInvoice");
        return query.getResultList();
    }

    @Override
    public  List<Double> findByInvoiceId(Long id) {
        Query query = jpaApi.em().createQuery("Select price from ProductInvoice where invoiceId= :id");
        return query.getResultList();
    }
}
