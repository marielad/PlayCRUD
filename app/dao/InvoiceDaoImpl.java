package dao;

import models.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDaoImpl implements InvoiceDao {
    @Override
    public void create(Invoice invoice) {

    }

    @Override
    public void delete(int invoiceID) {

    }

    @Override
    public void update(Invoice invoice) {

    }

    @Override
    public List<Invoice> findAll() {
        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(new Invoice());
        System.out.println("Entró");
        return null;
    }

    @Override
    public Invoice findById(int id) {
        return null;
    }
}
