package com.etiyacrm.catalogservice.entities;


import com.etiyacrm.catalogservice.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Where(clause = "deleted_date IS NULL")
@Table(name = "product_offers")
public class ProductOffer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description") //Gereksiz olabilir
    private String description;

<<<<<<< HEAD
    @Column(name = "code") //Gereksiz olabilir
    private String code;
=======
    @Column(name = "price")
    private double price;
>>>>>>> c2b4a2872a5df6589a417c3273811eb868faab4c

    @OneToMany(mappedBy = "productOffer")
    private List<CampaignProductOffer> campaignProductOffers;

    @OneToMany(mappedBy = "productOffer")
    private List<CatalogProductOffer> catalogProductOffers;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    private Product product;
}
