package models;

import dto.InvoiceDTO;
import dto.ProductInvoiceDTO;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "invoice")
@DynamicUpdate
public class Invoice  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id", nullable = false)
    public Long invoiceId;

    @Column(name = "total_price",  columnDefinition = "double precision", nullable = false)
    public Double totalPrice = 0.00;

    @Column(name = "invoice_date", columnDefinition = "date", nullable = false)
    public LocalDate invoiceDate;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ProductInvoice> productInvoices = new HashSet<>();

    public Invoice(){}
    public Invoice(InvoiceDTO invoiceDTO){
        this.invoiceId = invoiceDTO.invoiceId;
        this.invoiceDate = invoiceDTO.invoiceDate;
        this.totalPrice = invoiceDTO.totalPrice;
    }

    public Set<ProductInvoice> addProducts(List<ProductInvoiceDTO> productInvoiceList){
        for (int i = 0; i < productInvoiceList.size(); i++) {
            this.productInvoices.add(new ProductInvoice(productInvoiceList.get(i)));
        }
        return productInvoices;
    }

    public void addProduct(ProductInvoice productInvoice){
        this.productInvoices.add(productInvoice);
    }
    public void removeProduct(ProductInvoice productInvoice){
        this.productInvoices.remove(productInvoice);
    }
}

