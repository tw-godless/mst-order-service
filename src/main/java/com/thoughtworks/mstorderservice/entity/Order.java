package com.thoughtworks.mstorderservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "t_order")
@JsonSerialize
@Getter
@Setter
public class Order implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "good_id")
    @JsonProperty("good_id")
    private Integer goodId;

    @Column(name = "good_number")
    @JsonProperty("good_number")
    private Integer goodNumber;

    @Column(name = "total_price", precision = 2)
    @JsonProperty("total_price")
    private BigDecimal totalPrice;

    @Column(name = "status")
    @JsonProperty("status")
    private String status;
}
