package dao.impl;

import dao.ProductDao;
import models.Product;
import play.Logger;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.Query;
import java.util.List;

import static org.springframework.core.GenericTypeResolver.resolveTypeArguments;

public class ProductDaoImpl implements ProductDao {

    @Inject
    protected JPAApi jpaApi;

    @Override
    public List<Product> findAll() {
        Query query = jpaApi.em().createQuery("from Product");
        return query.getResultList();
    }

    @Override
    public Product findByPk(Long id) {
        try {
            return jpaApi.em().find(Product.class, id);
        } catch (Exception ex){
            Logger.error("(findByPk) Error: ", ex);
            jpaApi.em().getTransaction().rollback();
        }
        return null;
    }
}
