package modules;

import com.google.inject.AbstractModule;
import dao.InvoiceDao;
import dao.ProductDao;
import dao.impl.InvoiceDaoImpl;
import dao.impl.ProductDaoImpl;

public class DaoModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(InvoiceDao.class).to(InvoiceDaoImpl.class);
        bind(ProductDao.class).to(ProductDaoImpl.class);
    }
}
