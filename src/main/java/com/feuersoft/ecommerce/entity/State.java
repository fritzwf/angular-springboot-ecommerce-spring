package com.feuersoft.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by ffeuerbacher on 5/6/2021
 */

@Entity
@Table(name="state")
@Data
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

}
