package dao.impl;

import dao.InvoiceDao;
import dto.ProductInvoiceDTO;
import models.Invoice;
import models.ProductInvoice;
import play.Logger;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
import java.util.List;

import static org.springframework.core.GenericTypeResolver.resolveTypeArguments;

public class InvoiceDaoImpl implements InvoiceDao {

    @Inject
    protected JPAApi jpaApi;

    @Override
    public List<Invoice> findAll() {
        Query query = jpaApi.em().createQuery("from Invoice");
        List<Invoice> invoiceList = query.getResultList();
        return invoiceList;
    }

    @Override
    public Invoice findByPk(Long id) {
        try {
            return jpaApi.em().find(Invoice.class, id);
        } catch (Exception ex){
            Logger.error("(findByPk) Error: ", ex);
            jpaApi.em().getTransaction().rollback();
            return null;
        }
    }

    @Override
    public Invoice create(Invoice invoice) {
        EntityManager em = jpaApi.em();
        try {
            em.persist(invoice);
        } catch (Exception ex) {
            Logger.error("[AbstractDao](persist) Error: ", ex);
            em.getTransaction().rollback();
        }
        return invoice;
    }

    @Override
    public Invoice update(Invoice invoice) {
        EntityManager em = jpaApi.em();
        try {
            em.merge(invoice);
        } catch (Exception ex) {
            Logger.error("[AbstractDao](merge) Error: ", ex);
            em.getTransaction().rollback();
        }
        return invoice;
    }

    @Override
    public Invoice delete(Invoice invoice) {
        EntityManager em = jpaApi.em();
        try {
            em.remove(em.merge(invoice));
        } catch (Exception ex) {
            Logger.error("[AbstractDao](remove) Error: ", ex);
            em.getTransaction().rollback();
        }
        return invoice;
    }
}
