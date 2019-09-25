package modules;

import com.google.inject.AbstractModule;
import dao.InvoiceDao;
import dao.ProductDao;
import dao.ProductInvoiceDao;
import dao.impl.InvoiceDaoImpl;
import dao.impl.ProductDaoImpl;
import dao.impl.ProductInvoiceDaoImpl;

public class DaoModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(InvoiceDao.class).to(InvoiceDaoImpl.class);
        bind(ProductDao.class).to(ProductDaoImpl.class);
        bind(ProductInvoiceDao.class).to(ProductInvoiceDaoImpl.class);
    }
}
