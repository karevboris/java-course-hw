package com.netcracker;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;

@Entity
@Table(name = "buyers")
@EnableTransactionManagement
public class Buyer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "region")
    private String region;

    @Column(name = "sale")
    private double sale;

    public Buyer() {
    }

    public Buyer(String name, String region, double sale) {
        this.name = name;
        this.region = region;
        this.sale = sale;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", sale='" + sale + '\'' +
                '}';
    }
}
