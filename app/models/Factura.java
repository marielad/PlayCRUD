package models;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "Factura")
@DynamicUpdate
public class Factura {
    @Id
    @GeneratedValue()
    public Long id;


}
