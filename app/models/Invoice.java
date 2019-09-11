package models;

import dto.InvoiceDTO;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Invoice")
@DynamicUpdate
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id", nullable = false)
    public Long invoiceId;

    @Column(name = "total_price", columnDefinition = "double", nullable = false)
    public double totalPrice;

    @Column(name = "invoice_date", columnDefinition = "date", nullable = false)
    public Date invoiceDate;

    @OneToMany(mappedBy = "invoice")
    public Set<ProductInvoice> productInvoices = new HashSet<>();

    public Invoice(InvoiceDTO invoiceDTO){
        this.invoiceId = invoiceDTO.invoiceId;
        this.totalPrice = invoiceDTO.totalPrice;
        this.invoiceDate = invoiceDTO.invoiceDate;

    }
}

