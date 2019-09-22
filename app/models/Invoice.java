package models;

import dto.InvoiceDTO;
import dto.ProductInvoiceDTO;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
    public Double totalPrice;

    @Column(name = "invoice_date", columnDefinition = "date", nullable = false)
    public Date invoiceDate;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ProductInvoice> productInvoices = new HashSet<>();

    public Invoice(){}
    public Invoice(InvoiceDTO invoiceDTO){
        this.invoiceId = invoiceDTO.invoiceId;
        this.totalPrice = invoiceDTO.totalPrice;
        this.invoiceDate = invoiceDTO.invoiceDate;
        this.productInvoices = addProducts(invoiceDTO.productInvoiceDTOList);
    }

    public Set<ProductInvoice> addProducts(List<ProductInvoiceDTO> productInvoiceDTOList){
        Set<ProductInvoice> productInvoiceSet = new HashSet<>();
        for (int i = 0; i >= productInvoiceDTOList.size(); i++) {
            productInvoiceSet.add(new ProductInvoice(productInvoiceDTOList.get(i)));
        }
        return productInvoiceSet;
    }

    public void addProduct(ProductInvoiceDTO productInvoiceDTO){
        this.productInvoices.add(new ProductInvoice(productInvoiceDTO));
    }
    public void removeProduct(ProductInvoiceDTO productInvoiceDTO){
        this.productInvoices.remove(productInvoiceDTO);
    }
}

