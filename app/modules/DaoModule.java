package modules;

import com.google.inject.AbstractModule;
import dao.InvoiceDao;
import dao.InvoiceDaoImpl;

public class DaoModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(InvoiceDao.class).to(InvoiceDaoImpl.class);
    }
}
